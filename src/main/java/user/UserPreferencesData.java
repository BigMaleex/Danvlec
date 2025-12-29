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
            backgroundYearClockColor = UserPreferences.getBackgroundYearClockColor();
            backgroundMonthClockColor = UserPreferences.getBackgroundMonthClockColor();
            backgroundDayClockColor = UserPreferences.getBackgroundDayClockColor();
            backgroundHourClockColor = UserPreferences.getBackgroundHourClockColor();
            backgroundMinuteClockColor = UserPreferences.getBackgroundMinuteClockColor();
            backgroundSecondClockColor = UserPreferences.getBackgroundSecondClockColor();
            YearClockColor = UserPreferences.getYearClockColor();
            monthClockColor = UserPreferences.getMonthClockColor();
            dayClockColor = UserPreferences.getDayClockColor();
            hourClockColor = UserPreferences.getHourClockColor();
            minuteClockColor = UserPreferences.getMinuteClockColor();
            secondClockColor = UserPreferences.getSecondClockColor();

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
