package logical;

import connections.Users;
import controllers.LoginController;
import files.FileManager;
import files.UserDataFile;
import messagebuilder.MessageBuilder;
import user.UserData;
import utilities.FileConstants;
import utilities.ScreenManager;
import utilities.Titles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PopupTwoButtonInputs {

    private static ScreenManager sm = ScreenManager.getInstance();

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void askTheUserIfTheyWantToSaveTheirInformation(boolean saveInfo){

        if(saveInfo){

            UserDataFile.createFile(false);

        }else{

            UserDataFile.deleteFile();

        }

        StepsAfterLoggingIn.stepsAfterLoggingIn();

    }

    public static void allUserInformationIsCorrectFromGuestGenerateFile(ArrayList<String> data){

        UserData.setName(data.get(0));
        UserData.setLastname(data.get(1));
        UserData.setNickname(data.get(2));
        UserData.setSex(data.get(3).equalsIgnoreCase("HOMBRE") ? UserData.Sex.MAN : UserData.Sex.WOMAN);
        UserData.setBirthday(LocalDate.parse(data.get(4), dtf));

        UserDataFile.createFile(true);

    }

    public static void allUserInformationIsCorrectUploadToTheBD(ArrayList<String> data){

        UserData.setName(data.get(0));
        UserData.setLastname(data.get(1));
        UserData.setNickname(data.get(2));
        UserData.setEmail(data.get(3));
        UserData.setPassword(ValidateOutputs.sha256Hex(data.get(4)));
        UserData.setSex(data.get(5).equalsIgnoreCase("Hombre") ? UserData.Sex.MAN : UserData.Sex.WOMAN);
        UserData.setBirthday(LocalDate.parse(data.get(6), dtf));
        UserData.setFirstConnection(LocalDateTime.now());

        Users users = new Users();

        ValidateOutputs.createUserID();

        if(users.registerUser()){

            //El usuario se registró correctamente
            MessageBuilder.showOkMessageFromAllInfoUploadToTheBD();
            LoginController controller = (LoginController) sm.getController(FileConstants.Login);
            controller.initialize();
            sm.setScreen(FileConstants.Login, Titles.Login);


        }else{

            //El usuario no se pudo registrar
            MessageBuilder.showErrorMessageFromAllInfoUploadToTheBD();

        }

    }

}
