package files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import connections.Users;
import controllers.AccountMenuController;
import user.UserData;
import user.UserDataLS;
import user.UserPreferencesData;
import utilities.FileConstants;
import utilities.ScreenManager;
import utilities.Titles;

import java.io.File;
import java.io.IOException;

public class UserDataFile {

    private static final String fileName = "UserData";

    private static ScreenManager sm = ScreenManager.getInstance();

    public static void deleteFile(){

        FileManager.deleteFile(FileManager.projectFolder, fileName, "json");

    }

    public static void createFile(boolean copyAllData){

        ObjectMapper mapper = new ObjectMapper();
        UserDataLS userDataLS = new UserDataLS();

        if(copyAllData){

            userDataLS.copyAllData();

        }else{

            userDataLS.copyOnlyUserID();

        }

        try{

            FileManager.deleteFile(FileManager.projectFolder, fileName, "json");

            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            mapper.writeValue(new File(FileManager.projectFolder.resolve(fileName + ".json").toString()), userDataLS);

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    public static void theUserHaveAnyAccount(){

        ObjectMapper mapper = new ObjectMapper();

        if(FileManager.fileExists(FileManager.projectFolder, fileName, "json")){

            //Leer Archivo
            try {

                UserDataLS userData = mapper.readValue(new File(FileManager.projectFolder.resolve("UserData.json").toString()), UserDataLS.class);
                userData.load();
                if(UserData.getUserID() == null && UserData.getName() != null){

                    //El usuario es Local, envíar al FXML del inicio
                    System.out.println("Sesión local");


                } else if (UserData.getUserID() != null) {

                    //El usuario no es local, pero sí existe
                    Users us = new Users();
                    if(us.loginWithUserID()){

                        //Se pudo acceder, envíar al FXML del inicio


                    }else{

                        System.out.println("Login Failed");

                        sm.setScreen(FileConstants.AccountMenu, Titles.AccountMenu);

                    }

                }else{

                    //Los datos del usuario están corrompidos
                    sm.setScreen(FileConstants.AccountMenu, Titles.AccountMenu);

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

        }else{

            //No hay ningún archivo
            sm.setScreenAtPosition(FileConstants.AccountMenu, Titles.AccountMenu);

        }

    }

}
