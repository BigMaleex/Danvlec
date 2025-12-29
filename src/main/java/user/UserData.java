package user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserData {

    public enum Sex{

        MAN,WOMAN

    }

    private static String userID ;
    private static String name;
    private static String lastname;
    private static String nickname;
    private static String password;
    private static LocalDate birthday;
    private static LocalDateTime firstConnection;
    private static LocalDateTime lastConnection;
    private static Sex sex;
    private static String email;
    private static String motivation;
    private static boolean emailVerified;

    public UserData(String newUserID, String newName, String newLastname, String newNickname, String newPassword, LocalDate newBirthday, LocalDateTime newFirstConnection, LocalDateTime newLastConnection, Sex newSex, String newEmail, String newMotivation, boolean newEmailVerified) {

        userID = newUserID;
        name = newName;
        lastname = newLastname;
        nickname = newNickname;
        password = newPassword;
        birthday = newBirthday;
        firstConnection = newFirstConnection;
        lastConnection = newLastConnection;
        sex = newSex;
        email = newEmail;
        motivation = newMotivation;
        emailVerified = newEmailVerified;

    }

    public UserData(String newName, String newLastname, String newNickname, LocalDate newBirthday, LocalDateTime newFirstConnection, LocalDateTime newLastConnection, Sex newSex, String newMotivation) {

        userID = null;
        name = newName;
        lastname = newLastname;
        nickname = newNickname;
        password = null;
        birthday = newBirthday;
        firstConnection = newFirstConnection;
        lastConnection = newLastConnection;
        sex = newSex;
        email = null;
        motivation = newMotivation;
        emailVerified = false;

    }

    public static void logout(){

        userID = null;
        name = null;
        lastname = null;
        nickname = null;
        password = null;
        birthday = null;
        firstConnection = null;
        lastConnection = null;
        sex = null;
        email = null;
        motivation = null;
        emailVerified = false;

    }

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        UserData.userID = userID;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserData.name = name;
    }

    public static String getLastname() {
        return lastname;
    }

    public static void setLastname(String lastname) {
        UserData.lastname = lastname;
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        UserData.nickname = nickname;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserData.password = password;
    }

    public static LocalDate getBirthday() {
        return birthday;
    }

    public static void setBirthday(LocalDate birthday) {
        UserData.birthday = birthday;
    }

    public static LocalDateTime getFirstConnection() {
        return firstConnection;
    }

    public static void setFirstConnection(LocalDateTime firstConnection) {
        UserData.firstConnection = firstConnection;
    }

    public static LocalDateTime getLastConnection() {
        return lastConnection;
    }

    public static void setLastConnection(LocalDateTime lastConnection) {
        UserData.lastConnection = lastConnection;
    }

    public static Sex getSex() {
        return sex;
    }

    public static void setSex(Sex sex) {
        UserData.sex = sex;
    }

    public static String getMotivation() {
        return motivation;
    }

    public static void setMotivation(String motivation) {
        UserData.motivation = motivation;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserData.email = email;
    }

    public static boolean getEmailVerified() {
        return emailVerified;
    }

    public static void setEmailVerified(boolean emailVerified) {
        UserData.emailVerified = emailVerified;
    }
}
