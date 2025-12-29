package files;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import user.UserPreferences;
import user.UserPreferencesData;

import java.io.File;
import java.io.IOException;

public class Preferences {

    private static final String fileName = "Preferences";

    public void toggleTheme(){

        ObjectMapper mapper = new ObjectMapper();
        UserPreferencesData upd =  new UserPreferencesData();

        UserPreferences.toggleTheme();

        upd.copy();

        try {

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(FileManager.projectFolder.resolve("Preferences.json").toString()), upd);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void theUserChooseATheme() {

        ObjectMapper mapper = new ObjectMapper();

        if(FileManager.fileExists(FileManager.projectFolder, fileName, "json")){

            try {

                UserPreferencesData userPreferencesData = mapper.readValue(new File(FileManager.projectFolder.resolve("Preferences.json").toString()), UserPreferencesData.class);
                userPreferencesData.load();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }else{

            UserPreferencesData upd =  new UserPreferencesData();

            UserPreferences.setUserTheme(isDarkMode() ? UserPreferences.themeMode.DARK : UserPreferences.themeMode.LIGHT);

            upd.copy();

            FileManager.createFile(FileManager.projectFolder, "Preferences", "json");

            try {

                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                mapper.writeValue(new File(FileManager.projectFolder.resolve("Preferences.json").toString()), upd);

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }

    public static boolean isDarkMode() {
        String PATH = "Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize";
        String VALUE = "AppsUseLightTheme";
        int light = com.sun.jna.platform.win32.Advapi32Util.registryGetIntValue(
                com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER,
                PATH, VALUE
        );
        return light == 0;
    }
}
