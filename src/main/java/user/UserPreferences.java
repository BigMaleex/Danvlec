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

    public static void setUserTheme( themeMode userTheme) {
        UserPreferences.userTheme = userTheme;
    }

    public static String getYearClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && yearClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d4ff" : "#192d91ff";

        return yearClockColor;

    }

    public static void setYearClockColor(String yearClockColor) {
        UserPreferences.yearClockColor = yearClockColor;
    }

    public static String getMonthClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && monthClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d4ff" : "#192d91ff";

        return monthClockColor;

    }

    public static void setMonthClockColor(String monthClockColor) {
        UserPreferences.monthClockColor = monthClockColor;
    }

    public static String getDayClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && dayClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d4ff" : "#192d91ff";

        return dayClockColor;

    }

    public static void setDayClockColor(String dayClockColor) {
        UserPreferences.dayClockColor = dayClockColor;
    }

    public static String getHourClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && hourClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d4ff" : "#192d91ff";

        return hourClockColor;

    }

    public static void setHourClockColor(String hourClockColor) {
        UserPreferences.hourClockColor = hourClockColor;
    }

    public static String getMinuteClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && minuteClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d4ff" : "#192d91ff";

        return minuteClockColor;

    }

    public static void setMinuteClockColor(String minuteClockColor) {
        UserPreferences.minuteClockColor = minuteClockColor;
    }

    public static String getSecondClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && secondClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d4ff" : "#192d91ff";

        return secondClockColor;

    }

    public static void setSecondClockColor(String secondClockColor) {
        UserPreferences.secondClockColor = secondClockColor;
    }

    public static String getBackgroundYearClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && backgroundYearClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d433" : "#192d9133";

        return backgroundYearClockColor;

    }

    public static void setBackgroundYearClockColor(String backgroundYearClockColor) {
        UserPreferences.backgroundYearClockColor = backgroundYearClockColor;
    }

    public static String getBackgroundMonthClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && backgroundMonthClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d433" : "#192d9133";

        return backgroundMonthClockColor;

    }

    public static void setBackgroundMonthClockColor(String backgroundMonthClockColor) {
        UserPreferences.backgroundMonthClockColor = backgroundMonthClockColor;
    }

    public static String getBackgroundDayClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && backgroundDayClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d433" : "#192d9133";

        return backgroundDayClockColor;

    }

    public static void setBackgroundDayClockColor(String backgroundDayClockColor) {
        UserPreferences.backgroundDayClockColor = backgroundDayClockColor;
    }

    public static String getBackgroundHourClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && backgroundHourClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d433" : "#192d9133";

        return backgroundHourClockColor;

    }

    public static void setBackgroundHourClockColor(String backgroundHourClockColor) {
        UserPreferences.backgroundHourClockColor = backgroundHourClockColor;
    }

    public static String getBackgroundMinuteClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && backgroundMinuteClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d433" : "#192d9133";

        return backgroundMinuteClockColor;

    }

    public static void setBackgroundMinuteClockColor(String backgroundMinuteClockColor) {
        UserPreferences.backgroundMinuteClockColor = backgroundMinuteClockColor;
    }

    public static String getBackgroundSecondClockColor(boolean isCalledFromTheFile) {

        if(!isCalledFromTheFile && backgroundSecondClockColor.equalsIgnoreCase("DEFAULT"))return userTheme == themeMode.DARK ? "#4dc0d433" : "#192d9133";

        return backgroundSecondClockColor;

    }

    public static void setBackgroundSecondClockColor(String backgroundSecondClockColor) {
        UserPreferences.backgroundSecondClockColor = backgroundSecondClockColor;
    }
}
