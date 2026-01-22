package user;

import java.time.LocalDateTime;

public class UserClockLS {

    public String titleClock;
    public LocalDateTime date;

    public void copyAllData(){

        titleClock = UserClock.getTitleClock();
        date = UserClock.getDate();

    }

    public void loadAllData(){

        UserClock.setTitleClock(titleClock);
        UserClock.setDate(date);

    }

}
