package connections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Intensity {

    private static final String table = "intensity";
    private final Logger logger = LoggerFactory.getLogger(Intensity.class);

    public boolean addEntry(String entryID, String [] emotions, int [] scores){

        String query = "INSERT INTO danvlec." + table + " (UserID, EntryID, EmotionID, Score) VALUES(?,?,?,?)";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            conn.setAutoCommit(false);

            ps.setString(1, UserData.getUserID());
            ps.setString(2, entryID);

            for(int i = 0; i < emotions.length; i++){

                ps.setString(3, emotions[i]);
                ps.setInt(4, scores[i]);

                ps.addBatch();

            }

            ps.executeBatch();
            conn.commit();

            return true;

        }catch (SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return false;

    }

}
