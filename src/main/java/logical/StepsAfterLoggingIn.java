package logical;

import connections.Users;
import utilities.FileConstants;
import utilities.ScreenManager;

public class StepsAfterLoggingIn {

    public static void stepsAfterLoggingIn() {

        //Verificar si el usuario ya dío de alta su correo
        ScreenManager sm = ScreenManager.getInstance();
        Users users = new Users();

        if (!users.theUserHaveVerifiedTheirEmail()) {

            sm.openDynamicPopup(

                    FileConstants.PopupVerifyEmailFXML,
                    "Verifica tu correo electrónico",
                    controller -> {



                    }

            );

        }

        sm.openDynamicPopup(

                FileConstants.PopupSecurityCodesFXML,
                "Verifica tu correo electrónico",
                controller -> {



                });


    }

}
