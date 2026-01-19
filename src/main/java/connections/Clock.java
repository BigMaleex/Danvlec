package connections;

import user.UserClock;
import user.UserData;

import java.sql.*;

public class Clock {

    private final static String table = "clock";

    public void updateColors(String field, String hexColor){

        if(hexColor.length() != 7){

            System.out.println("Color inválido " + hexColor);

            return;

        }

        if(field == null) return;

        if(field.endsWith("=")){

            field = field.substring(0, field.length()-1);

        }

        String query = "UPDATE danvlec."+ table + " SET " + field + "=?, " + field + "Background=? WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,hexColor);
            ps.setString(2,hexColor + "33");
            ps.setString(3, UserData.getUserID());



        }catch(SQLException e){

            e.printStackTrace();
            DataManager.showError(e.toString());

        }

    }

    public void updateOrCreateRow(){

        if(haveAnyData()){

            //Hay datos, solo actualizar
            updateOneField("TitleClock");
            updateOneField("Date");

        }else{

            createData();

        }

    }

    public void updateOneField(String column){

        if(column == null) return;

        if(column.endsWith("=")){

            column = column.substring(0, column.length()-1);

        }

        String query = "UPDATE danvlec." + table + " SET " + column + "=? WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            switch(column){

                case "TitleClock" ->{

                    ps.setString(1, UserClock.getTitleClock());

                }

                case "Date" ->{

                    ps.setTimestamp(1, Timestamp.valueOf(UserClock.getDate()));

                }

                default ->{

                    System.out.println("Ninguna celda es " +  column);

                }

            }

            ps.setString(2, UserData.getUserID());



        }catch(SQLException e){

            e.printStackTrace();
            DataManager.showError(e.toString());

        }

    }

    public void createData(){

        String query = "INSERT INTO danvlec." + table + " (UserID, TitleClock, Date), (?,?,?)";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());
            ps.setString(2, UserClock.getTitleClock());
            ps.setTimestamp(3, Timestamp.valueOf(UserClock.getDate()));

        }catch(SQLException e){

            e.printStackTrace();
            DataManager.showError(e.toString());

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
