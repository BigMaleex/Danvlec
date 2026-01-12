package connections;

import user.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SecurityCodes {

    private final String table = "securitycodes";

    public boolean deleteCodes(){

        String query = "DELETE FROM danvlec." + table + " Where UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            return ps.executeUpdate() >0;

        }catch (SQLException e){

            e.printStackTrace();
            DataManager.showError(e.toString());

        }

        return false;

    }

    public boolean insertCodes(String[] codes) {

        String query = "INSERT INTO danvlec." + table + " (UserID, Code) VALUES (?, ?)";

        try (Connection conn = DataManager.validateConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            conn.setAutoCommit(false);

            for (String code : codes) {
                ps.setString(1, UserData.getUserID());
                ps.setString(2, code);
                ps.addBatch();
            }

            int[] results = ps.executeBatch();
            conn.commit();


            for (int r : results) {
                if (r == 0) return false;
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            DataManager.showError(e.toString());
            return false;
        }
    }

    public boolean haveAnyCode(){

        String query = "SELECT * FROM danvlec." + table + " WHERE UserID=? AND TheCodeWasUsed=0";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            try(ResultSet rs = ps.executeQuery()){

                return rs.next();

            }

        }catch(SQLException e){

            e.printStackTrace();
            DataManager.showError(e.toString());

        }

        return false;

    }

    public String[] getCodes(){

        ArrayList<String> codes = new ArrayList<String>();
        String query = "SELECT * FROM danvlec." + table + " WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            try(ResultSet rs = ps.executeQuery()){


                while(rs.next()){
                    if(rs.getBoolean("TheCodeWasUsed")){

                        //El código fue usado
                        codes.add("Este código ya fue usado");

                    }else{

                        codes.add(rs.getString("Code"));

                    }

                }

            }

        }catch(SQLException e){

            e.printStackTrace();
            DataManager.showError(e.toString());

        }

        return codes.toArray(new String[codes.size()]);

    }

}
