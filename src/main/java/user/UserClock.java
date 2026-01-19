package user;

import java.time.LocalDateTime;

public class UserClock {

    public static String titleClock;
    public static LocalDateTime date;

    public static void logout(){

        titleClock = null;
        date = null;

    }

    public static String getTitleClock() {
        return titleClock;
    }

    public static void setTitleClock(String titleClock) {
        UserClock.titleClock = titleClock;
    }

    public static LocalDateTime getDate() {
        return date;
    }

    public static void setDate(LocalDateTime date) {
        UserClock.date = date;
    }
}
