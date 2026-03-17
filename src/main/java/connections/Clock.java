package connections;

import files.Preferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.UserClock;
import user.UserData;
import user.UserPreferences;

import java.sql.*;
import java.time.LocalDateTime;

public class Clock {

    private final static String table = "clock";
    private final Logger logger = LoggerFactory.getLogger(Clock.class);

    public void getClockData(){

        String query = "SELECT * FROM danvlec." + table + " WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            try(ResultSet rs = ps.executeQuery()){

                if(rs.next()){

                    UserClock.setTitleClock(rs.getString("TitleClock"));
                    UserClock.setDate(rs.getTimestamp("Date").toLocalDateTime());
                    UserPreferences.setYearClockColor(rs.getString("YearClockColor"));
                    UserPreferences.setBackgroundYearClockColor(rs.getString("YearClockColorBackground"));

                    UserPreferences.setMonthClockColor(rs.getString("MonthClockColor"));
                    UserPreferences.setBackgroundMonthClockColor(rs.getString("MonthClockColorBackground"));

                    UserPreferences.setDayClockColor(rs.getString("DayClockColor"));
                    UserPreferences.setBackgroundDayClockColor(rs.getString("DayClockColorBackground"));

                    UserPreferences.setHourClockColor(rs.getString("HourClockColor"));
                    UserPreferences.setBackgroundHourClockColor(rs.getString("HourClockColorBackground"));

                    UserPreferences.setMinuteClockColor(rs.getString("MinuteClockColor"));
                    UserPreferences.setBackgroundMinuteClockColor(rs.getString("MinuteClockColorBackground"));

                    UserPreferences.setSecondClockColor(rs.getString("SecondClockColor"));
                    UserPreferences.setBackgroundSecondClockColor(rs.getString("SecondClockColorBackground"));

                    Preferences file = new Preferences();

                    file.updateClockColors();

                }

            }

        }catch(SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

    }

    public void resetClock(){

        String query = "UPDATE danvlec." + table + " SET Date=? WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(2, UserData.getUserID());

            ps.executeUpdate();

        }catch(SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

    }

    public void updateColors(String field, String hexColor){

        if(hexColor.length() != 7){

            logger.error("Color inválido " + hexColor);

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

            ps.executeUpdate();

        }catch(SQLException e){

            logger.error(e.toString());
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

                    logger.error("Ninguna celda es " +  column);

                }

            }

            ps.setString(2, UserData.getUserID());



        }catch(SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

    }

    public void createData(){

        String query = "INSERT INTO danvlec." + table + " (UserID, TitleClock, Date) VALUES (?,?,?)";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());
            ps.setString(2, UserClock.getTitleClock());
            ps.setTimestamp(3, Timestamp.valueOf(UserClock.getDate()));

            ps.executeUpdate();

        }catch(SQLException e){

            logger.error(e.toString());
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

            logger.error(e.toString());

            DataManager.showError(e.toString());

        }

        return false;

    }

}
