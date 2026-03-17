package connections;

import files.CloudEntry;
import user.UserData;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CloudEntriesManager {

    private static final String query =
        "SELECT e.EntryID, e.Date, e.Context, e.Feelings, e.AdditionalNotes, e.GeneralState, " +
        "i.EmotionID, i.Score " +
        "FROM danvlec.entry e " +
        "LEFT JOIN danvlec.intensity i ON e.EntryID = i.EntryID AND e.UserID = i.UserID " +
        "WHERE e.UserID = ? " +
        "ORDER BY e.Date ASC, e.EntryID";

    public List<CloudEntry> getAllEntries() {

        // LinkedHashMap para mantener el orden de inserción por EntryID
        Map<String, CloudEntry.Builder> builders = new LinkedHashMap<>();

        try (Connection conn = DataManager.validateConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, UserData.getUserID());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String entryID = rs.getString("EntryID");

                    // Si es la primera fila de esta entrada, crea el builder
                    builders.computeIfAbsent(entryID, id -> {
                        try {
                            return new CloudEntry.Builder(
                                rs.getTimestamp("Date").toLocalDateTime(),
                                rs.getString("Context"),
                                rs.getString("Feelings"),
                                rs.getString("AdditionalNotes"),
                                rs.getInt("GeneralState")
                            );
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    });

                    // Agrega la emoción y su score al builder correspondiente
                    String emotionID = rs.getString("EmotionID");
                    int score        = rs.getInt("Score");
                    if (emotionID != null) {
                        builders.get(entryID).addEmotion(emotionID, score);
                    }
                }
            }

        } catch (SQLException e) {
            DataManager.showError(e.toString());
        }

        // Convierte cada builder en un CloudEntry
        List<CloudEntry> result = new ArrayList<>();
        for (CloudEntry.Builder b : builders.values()) {
            result.add(b.build());
        }
        return result;
    }
}