package user;

public class UserPreferences {

    public enum themeMode{

        DARK,LIGHT

    }

    private static themeMode userTheme = themeMode.LIGHT;
    private static String yearClockColor = "Default";
    private static String backgroundYearClockColor = "Default";
    private static String monthClockColor = "Default";
    private static String backgroundMonthClockColor = "Default";
    private static String dayClockColor = "Default";
    private static String backgroundDayClockColor = "Default";
    private static String hourClockColor = "Default";
    private static String backgroundHourClockColor = "Default";
    private static String minuteClockColor = "Default";
    private static String backgroundMinuteClockColor = "Default";
    private static String secondClockColor = "Default";
    private static String backgroundSecondClockColor = "Default";

    public static void logout(){

        yearClockColor = "Default";
        backgroundYearClockColor = "Default";
        monthClockColor = "Default";
        backgroundMonthClockColor = "Default";
        dayClockColor = "Default";
        backgroundDayClockColor = "Default";
        hourClockColor = "Default";
        backgroundHourClockColor = "Default";
        minuteClockColor = "Default";
        backgroundMinuteClockColor = "Default";
        secondClockColor = "Default";
        backgroundSecondClockColor = "Default";

    }

    protected static themeMode getUserTheme() {
        return userTheme;
    }

    public static boolean getUserThemeMode(){

        return userTheme.equals(themeMode.DARK);

    }

    public static void toggleTheme(){

        userTheme =  userTheme == themeMode.DARK ? themeMode.LIGHT : themeMode.DARK;

    }

    public static void setUserTheme(themeMode userTheme) {
        UserPreferences.userTheme = userTheme;
    }

    public static String getYearClockColor() {
        return yearClockColor;
    }

    public static void setYearClockColor(String yearClockColor) {
        UserPreferences.yearClockColor = yearClockColor;
    }

    public static String getMonthClockColor() {
        return monthClockColor;
    }

    public static void setMonthClockColor(String monthClockColor) {
        UserPreferences.monthClockColor = monthClockColor;
    }

    public static String getDayClockColor() {
        return dayClockColor;
    }

    public static void setDayClockColor(String dayClockColor) {
        UserPreferences.dayClockColor = dayClockColor;
    }

    public static String getHourClockColor() {
        return hourClockColor;
    }

    public static void setHourClockColor(String hourClockColor) {
        UserPreferences.hourClockColor = hourClockColor;
    }

    public static String getMinuteClockColor() {
        return minuteClockColor;
    }

    public static void setMinuteClockColor(String minuteClockColor) {
        UserPreferences.minuteClockColor = minuteClockColor;
    }

    public static String getSecondClockColor() {
        return secondClockColor;
    }

    public static void setSecondClockColor(String secondClockColor) {
        UserPreferences.secondClockColor = secondClockColor;
    }

    public static String getBackgroundYearClockColor() {
        return backgroundYearClockColor;
    }

    public static void setBackgroundYearClockColor(String backgroundYearClockColor) {
        UserPreferences.backgroundYearClockColor = backgroundYearClockColor;
    }

    public static String getBackgroundMonthClockColor() {
        return backgroundMonthClockColor;
    }

    public static void setBackgroundMonthClockColor(String backgroundMonthClockColor) {
        UserPreferences.backgroundMonthClockColor = backgroundMonthClockColor;
    }

    public static String getBackgroundDayClockColor() {
        return backgroundDayClockColor;
    }

    public static void setBackgroundDayClockColor(String backgroundDayClockColor) {
        UserPreferences.backgroundDayClockColor = backgroundDayClockColor;
    }

    public static String getBackgroundHourClockColor() {
        return backgroundHourClockColor;
    }

    public static void setBackgroundHourClockColor(String backgroundHourClockColor) {
        UserPreferences.backgroundHourClockColor = backgroundHourClockColor;
    }

    public static String getBackgroundMinuteClockColor() {
        return backgroundMinuteClockColor;
    }

    public static void setBackgroundMinuteClockColor(String backgroundMinuteClockColor) {
        UserPreferences.backgroundMinuteClockColor = backgroundMinuteClockColor;
    }

    public static String getBackgroundSecondClockColor() {
        return backgroundSecondClockColor;
    }

    public static void setBackgroundSecondClockColor(String backgroundSecondClockColor) {
        UserPreferences.backgroundSecondClockColor = backgroundSecondClockColor;
    }
}
