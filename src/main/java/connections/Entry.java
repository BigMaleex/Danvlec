package connections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.UserData;

import java.sql.*;
import java.time.LocalDateTime;

public class Entry {

    private static final String table = "entry";
    private final Logger logger = LoggerFactory.getLogger(Entry.class);

    public boolean isUniqueEntryID(String id){

        String query = "SELECT 1 FROM   danvlec." + table + " WHERE EntryID =? AND UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, id);
            ps.setString(2, UserData.getUserID());

            try(ResultSet rs = ps.executeQuery()){

                return !rs.next();

            }

        }catch (SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return false;

    }

    public boolean addEntry (String entryID, String context, String feelings, String additionalNotes, int generalState){

        String query = "INSERT INTO danvlec." + table + " (UserID, EntryID, Date, Context, Feelings, AdditionalNotes, GeneralState) VALUES(?,?,?,?,?,?, ?)";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, UserData.getUserID());
            ps.setString(2, entryID);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(4, context);
            ps.setString(5, feelings);
            ps.setString(6, additionalNotes);
            ps.setInt(7, generalState);

            return ps.executeUpdate() > 0;

        }catch (SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return false;

    }

    public void deleteEntry(String entryID){

        String query = "DELETE FROM danvlec." + table + " WHERE UserID =? AND EntryID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, UserData.getUserID());
            ps.setString(2, entryID);

            ps.executeUpdate();

        }catch (SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

    }

    public int getAllEntriesCount (){

        String query = "SELECT COUNT(*) AS total FROM danvlec." + table + "  WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt("total");

            }

        }catch (SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return 0;

    }

    public int getMonthEntriesCount (){

        String query = "SELECT COUNT(*) AS total FROM danvlec." + table + " WHERE UserID = ? AND MONTH(Date) = MONTH(CURRENT_DATE()) AND YEAR(Date) = YEAR(CURRENT_DATE())";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt("total");

            }

        }catch (SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return 0;

    }

    public int getWeekEntriesCount (){

        String query = "SELECT COUNT(*) AS total FROM danvlec." + table + " WHERE UserID = ? AND Date >= DATE_SUB(CURRENT_DATE(), INTERVAL 7 DAY)";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt("total");

            }

        }catch (SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return 0;

    }

}
