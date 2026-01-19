package logical;

import connections.Clock;
import connections.SecurityCodes;
import connections.Users;
import controllers.PopupSecurityCodesController;
import user.UserData;
import utilities.FileConstants;
import utilities.ScreenManager;

public class StepsAfterLoggingIn {

    private static final Users users = new Users();
    private static final SecurityCodes securityCodes = new SecurityCodes();
    private static final Clock clock = new Clock();
    private static final ScreenManager sm = ScreenManager.getInstance();

    public static void stepsAfterLoggingInWithAccount() {
        if (UserData.isHaveAnyAccount()) {
            checkEmailVerification(); // Empezamos por el primero
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
                    () -> System.out.println("Secuencia terminada") // Fin
            );
        }
    }
}