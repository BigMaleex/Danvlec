package connections;

import logical.ValidateOutputs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.UserData;
import utilities.FileConstants;
import utilities.ScreenManager;
import utilities.Titles;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Users {

    private final String table = "users";
    private final Logger logger = LoggerFactory.getLogger(Users.class);

    public boolean theUserHaveVerifiedTheirEmail(){

        String query = "SELECT EmailVerified FROM danvlec." + table + " WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query) ){

            ps.setString(1, UserData.getUserID());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getBoolean("EmailVerified");
            }

        }catch(SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return false;

    }

    public boolean getUserIDWithEmailAndPassword(String email, String password){

        String query = "SELECT UserID FROM danvlec." + table + " WHERE email = ? AND password = ?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, email);
            ps.setString(2, password);

            try(ResultSet rs = ps.executeQuery()){

                if(rs.next()){

                    UserData.setUserID(rs.getString("UserID"));

                    return true;

                }

            }

        }catch(SQLException e){

            logger.error(e.toString());

            DataManager.showError(e.toString());

        }

        return false;

    }

    public boolean toggleEmailStatus(){

        String query = "UPDATE danvlec." + table +  " SET EmailVerified = NOT EmailVerified WHERE userID=? ";

        try(Connection con = DataManager.validateConnection(); PreparedStatement ps = con.prepareStatement(query);){

            ps.setString(1, UserData.getUserID());

            boolean updated = ps.executeUpdate() > 0;

            return updated;

        }catch(SQLException e){

            logger.error(e.toString());

            DataManager.showError(e.toString());

        }

        return false;

    }

    public long getDaysThatHavePassed(){

        String query = "SELECT DateTheEmailWasChanged FROM danvlec." + table + " WHERE UserID=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());

            try(ResultSet rs = ps.executeQuery()){

                if(rs.next()){

                    return Math.abs(ChronoUnit.DAYS.between(rs.getTimestamp("DateTheEmailWasChanged").toLocalDateTime().toLocalDate(), LocalDate.now()));

                }

            }

        }catch(SQLException e){

            logger.error(e.toString());

            DataManager.showError(e.toString());

        }

        return -1;

    }

    public boolean loginWithUserID(){

        String query = "SELECT * FROM danvlec." + table + " WHERE userID = ?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query);){

            ps.setString(1, UserData.getUserID());

            try(ResultSet rs = ps.executeQuery();){

                if(rs.next()){

                    //Se encontró el usuario
                    UserData ud = new UserData(

                            rs.getString("UserID"),
                            rs.getString("Name"),rs.getString("Lastname"),
                            rs.getString("Nickname"),rs.getString("Password"),
                            rs.getDate("Birthday").toLocalDate(),
                            rs.getTimestamp("FirstConnection").toLocalDateTime(),
                            rs.getTimestamp("LastConnection").toLocalDateTime(),
                            rs.getInt("Sex") == 1 ? UserData.Sex.MAN : UserData.Sex.WOMAN,
                            rs.getString("Email"), rs.getString("Motivation"),
                            rs.getBoolean("EmailVerified"), true

                    );

                    return true;

                }else{

                    ScreenManager sm = ScreenManager.getInstance();
                    sm.setScreen(FileConstants.AccountMenu, Titles.AccountMenu);

                }

            }

        }catch(SQLException e){

            logger.error(e.toString());
            DataManager.showError(e.toString());

        }

        return false;

    }

    public boolean registerUser(){

        String query = "INSERT INTO danvlec." + table + " (UserID, Name, Lastname, Nickname, Password, Birthday, FirstConnection, LastConnection, Sex, Email, FirstEmail, LatestPassword) VALUES(?,?,?,?,?,?,?,?,?,?, ?, ?)" ;

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, UserData.getUserID());
            ps.setString(2, UserData.getName());
            ps.setString(3, UserData.getLastname());
            ps.setString(4, UserData.getNickname());
            ps.setString(5, UserData.getPassword());
            ps.setDate(6, Date.valueOf(UserData.getBirthday()));
            ps.setTimestamp(7, Timestamp.valueOf(UserData.getFirstConnection()));
            ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(9, UserData.getSex() == UserData.Sex.MAN ? 1 : 0);
            ps.setString(10, UserData.getEmail());
            ps.setString(11, ValidateOutputs.sha256Hex(UserData.getEmail()));
            ps.setString(12, UserData.getPassword());

            return ps.executeUpdate() == 1;

        }catch(SQLException e){

            logger.error(e.toString());

            DataManager.showError(e.toString());

            return false;

        }

    }

    public boolean isUniqueUserID(){

        if(UserData.getUserID() == null) return false;

        return isUnique(UserData.getUserID(), "UserID");

    }

    public boolean isUniqueEmail(String email){

        if(email == null) return false;

        return isUnique(email, "Email");

    }

    private boolean isUnique(String input, String column){

        if((input == null || column == null) || input.equalsIgnoreCase(column)) return false;

        String query = "SELECT * FROM " + "danvlec." + table +  " WHERE " + column + "=?";

        try(Connection conn = DataManager.validateConnection(); PreparedStatement ps = conn.prepareStatement(query);){

            ps.setString(1, input);

            try(ResultSet rs = ps.executeQuery()) {

                return !rs.next();

            }

        }catch(SQLException e) {

            logger.error(e.toString());

            DataManager.showError(e.toString());

        }

        return true;

    }

}
