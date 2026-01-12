package files;

import connections.Users;
import logical.StepsAfterLoggingIn;
import user.UserData;
import user.UserDataLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
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
                mapper.registerModule(new JavaTimeModule());
                userData.load();
                if(!UserData.isHaveAnyAccount()){

                    //El usuario es Local, envíar al FXML del inicio
                    System.out.println("Sesión local");




                } else {

                    //El usuario no es local, pero sí existe
                    Users us = new Users();
                    if(us.loginWithUserID()){

                        //Se pudo acceder, envíar al FXML del inicio
                        StepsAfterLoggingIn.stepsAfterLoggingInWithAccount();

                    }else{



                    }

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
