package user;

public class UserPreferencesData {

    public UserPreferences.themeMode userTheme;
    public String YearClockColor;
    public String backgroundYearClockColor;
    public String monthClockColor;
    public String backgroundMonthClockColor;
    public String dayClockColor;
    public String backgroundDayClockColor;
    public String hourClockColor;
    public String backgroundHourClockColor;
    public String minuteClockColor;
    public String backgroundMinuteClockColor;
    public String secondClockColor;
    public String backgroundSecondClockColor;

        public void copy(){

            userTheme = UserPreferences.getUserTheme();
            backgroundYearClockColor = UserPreferences.getBackgroundYearClockColor(true);
            backgroundMonthClockColor = UserPreferences.getBackgroundMonthClockColor(true);
            backgroundDayClockColor = UserPreferences.getBackgroundDayClockColor(true);
            backgroundHourClockColor = UserPreferences.getBackgroundHourClockColor(true);
            backgroundMinuteClockColor = UserPreferences.getBackgroundMinuteClockColor(true);
            backgroundSecondClockColor = UserPreferences.getBackgroundSecondClockColor(true);
            YearClockColor = UserPreferences.getYearClockColor(true);
            monthClockColor = UserPreferences.getMonthClockColor(true);
            dayClockColor = UserPreferences.getDayClockColor(true);
            hourClockColor = UserPreferences.getHourClockColor(true);
            minuteClockColor = UserPreferences.getMinuteClockColor(true);
            secondClockColor = UserPreferences.getSecondClockColor(true);

        }

        public void load(){

            UserPreferences.setBackgroundYearClockColor(backgroundYearClockColor);
            UserPreferences.setBackgroundMonthClockColor(backgroundMonthClockColor);
            UserPreferences.setBackgroundDayClockColor(backgroundDayClockColor);
            UserPreferences.setBackgroundHourClockColor(backgroundHourClockColor);
            UserPreferences.setBackgroundMinuteClockColor(backgroundMinuteClockColor);
            UserPreferences.setBackgroundSecondClockColor(backgroundSecondClockColor);
            UserPreferences.setUserTheme(userTheme);
            UserPreferences.setYearClockColor(YearClockColor);
            UserPreferences.setMonthClockColor(monthClockColor);
            UserPreferences.setDayClockColor(dayClockColor);
            UserPreferences.setHourClockColor(hourClockColor);
            UserPreferences.setMinuteClockColor(minuteClockColor);
            UserPreferences.setSecondClockColor(secondClockColor);

        }

}
