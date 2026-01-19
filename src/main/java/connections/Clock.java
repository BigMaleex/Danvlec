package connections;

import user.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Clock {

    private final static String table = "clock";

    public void updateOrCreate(){

        if(haveAnyData()){

            //Hay datos, solo actualizar

        }else{



        }

    }

    public boolean haveAnyData(){

        String query = "SELECT * FROM danvlec." + table + " WHERE UserID=?";

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

}
