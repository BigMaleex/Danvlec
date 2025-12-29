package user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDataLS {

    public String userID;
    public String name;
    public String lastname;
    public String nickname;
    public String password;
    public LocalDate birthday;
    public LocalDateTime firstConnection;
    public LocalDateTime lastConnection;
    public UserData.Sex sex;
    public String email;
    public String motivation;
    public boolean emailVerified;

    public void copyAllData(){

        userID = UserData.getUserID();
        name = UserData.getName();
        email = UserData.getEmail();
        lastname = UserData.getLastname();
        password = UserData.getPassword();
        lastConnection = UserData.getLastConnection();
        motivation = UserData.getMotivation();
        emailVerified = UserData.getEmailVerified();
        nickname = UserData.getNickname();
        birthday = UserData.getBirthday();
        firstConnection = UserData.getFirstConnection();
        sex = UserData.getSex();

    }

    public void copyOnlyUserID(){

        userID = UserData.getUserID();
        name = null;
        email = null;
        lastname = null;
        password = null;
        lastConnection = null;
        motivation = null;
        emailVerified = false;
        nickname = null;
        birthday = null;
        firstConnection = null;
        sex = null;

    }

    public void load (){

        UserData.setUserID(userID);
        UserData.setLastConnection(lastConnection);
        UserData.setMotivation(motivation);
        UserData.setEmailVerified(emailVerified);
        UserData.setName(name);
        UserData.setEmail(email);
        UserData.setLastname(lastname);
        UserData.setPassword(password);
        UserData.setNickname(nickname);
        UserData.setBirthday(birthday);
        UserData.setFirstConnection(firstConnection);
        UserData.setSex(sex);

    }

}
