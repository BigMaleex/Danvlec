package logical;

import connections.Clock;
import connections.SecurityCodes;
import connections.Users;
import controllers.MainWindowController;
import controllers.PopupSecurityCodesController;
import files.ClockFile;
import user.UserData;
import utilities.FileConstants;
import utilities.ScreenManager;
import utilities.Titles;

public class StepsAfterLoggingIn {

    private static final Users users = new Users();
    private static final SecurityCodes securityCodes = new SecurityCodes();
    private static final Clock clock = new Clock();
    private static final ScreenManager sm = ScreenManager.getInstance();

    public static void stepsAfterLoggingIn() {
        if (UserData.haveAnyAccount()) {

            //Hay cuenta
            checkEmailVerification();

        }else{

            //No hay cuenta
            checkClockDataWithoutAccount();

        }
    }

    private static void checkClockDataWithoutAccount(){

        ClockFile file = new ClockFile();
        if(!file.isTheFileExists()){

            sm.openDynamicStringPopup(
                    FileConstants.PopupSetClockFXML,
                    "Define tu objetivo",
                    alertController -> {},
                    () -> {

                        System.out.println("Secuencia terminada");
                        loadAllData();

                    }
            );

        }else{

            loadAllData();

        }

    }

    private static void checkEmailVerification() {
        if (!users.theUserHaveVerifiedTheirEmail()) {
            sm.openDynamicStringPopup(
                    FileConstants.PopupVerifyEmailFXML,
                    "Verifica tu correo electrónico",
                    controller -> {},
                    StepsAfterLoggingIn::checkSecurityCodes // Cuando cierre, ve al siguiente
            );
        } else {
            checkSecurityCodes(); // Si ya está bien, salta al siguiente
        }
    }

    private static void checkSecurityCodes() {
        if (!securityCodes.haveAnyCode()) {
            sm.openDynamicStringPopup(
                    FileConstants.PopupSecurityCodesFXML,
                    "Revisa tu seguridad",
                    alertController -> {
                        PopupSecurityCodesController controller = (PopupSecurityCodesController) alertController;
                        controller.initializeLabels(false);
                    },
                    StepsAfterLoggingIn::checkClockData // Cuando cierre, ve al último
            );
        } else {
            checkClockData();
        }
    }

    private static void checkClockData() {
        if (!clock.haveAnyData()) {
            sm.openDynamicStringPopup(
                    FileConstants.PopupSetClockFXML,
                    "Define tu objetivo",
                    alertController -> {},
                    () -> {

                        System.out.println("Secuencia terminada");
                        loadAllData();

                    }
            );
        }else{

            loadAllData();

        }
    }

    private static void loadAllData(){

        if(UserData.haveAnyAccount()){

            //hay una cuenta
            System.out.println("Proceso de datos con cuenta");
            Clock clock = new Clock();

            clock.getClockData();


        }

        MainWindowController controller = (MainWindowController) sm.getController(FileConstants.MainWindow);

        controller.initialize();

        controller.loadData();

        controller.initializeAnimation();

        sm.setScreen(FileConstants.MainWindow, Titles.MainWindow);

    }
}