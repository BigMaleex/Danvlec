package logical;

import connections.SecurityCodes;
import connections.Users;
import controllers.PopupSecurityCodesController;
import utilities.FileConstants;
import utilities.ScreenManager;

public class StepsAfterLoggingIn {

    public static void stepsAfterLoggingInWithAccount() {

        //Verificar si el usuario ya dío de alta su correo
        ScreenManager sm = ScreenManager.getInstance();
        Users users = new Users();
        SecurityCodes securityCodes = new SecurityCodes();

        if (!users.theUserHaveVerifiedTheirEmail()) {

            sm.openDynamicPopup(

                    FileConstants.PopupVerifyEmailFXML,
                    "Verifica tu correo electrónico",
                    controller -> {



                    }

            );

        }

        if(!securityCodes.haveAnyCode()){

            sm.openDynamicPopup(

                    FileConstants.PopupSecurityCodesFXML,
                    "Verifica tu correo electrónico",
                    alertController -> {

                        PopupSecurityCodesController controller = (PopupSecurityCodesController) alertController;

                        controller.initializeLabels(false);

                    });

        }

        sm.openDynamicPopup(

                FileConstants.PopupSetClockFXML,
                "Verifica tu correo electrónico",
                alertController -> {



                });

    }

}
