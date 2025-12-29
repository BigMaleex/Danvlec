package logical;

import controllers.LoadScreensController;
import files.UserDataFile;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import utilities.FileConstants;
import utilities.ScreenManager;
import utilities.Titles;

import java.io.File;

public class LoadScreens {

    //Referencias
    private ScreenManager sm = ScreenManager.getInstance();
    private LoadScreensController loadScreensController;

    //Variables
    private final String[][] screensToLoad = {

            {FileConstants.AccountMenu, FileConstants.AccountMenuFXML},
            {FileConstants.SignUp, FileConstants.SignUpFXML},
            {FileConstants.Guest, FileConstants.GuestFXML},
            {FileConstants.Login, FileConstants.LoginFXML},

    };

    //Constantes
    private final double maxProgress = 1;
    private final String message = "Cargando recursos...";

    public void loadScreens() {
        sm = ScreenManager.getInstance();
        loadScreensController = (LoadScreensController) sm.getController(FileConstants.LoadScreens);
        loadScreensController.setProgress(0.05, message);
        loadNextScreen(0);
    }

    private void loadNextScreen(int index) {
        if (index < screensToLoad.length) {
            String screenId = screensToLoad[index][0];
            String fxmlFile = screensToLoad[index][1];

            sm.loadScreen(screenId, fxmlFile);

            double progressStep = (maxProgress - 0.05) / screensToLoad.length;
            double currentProgress = 0.05 + ((index + 1) * progressStep);
            loadScreensController.setProgress(currentProgress, message);


            PauseTransition wait = new PauseTransition(Duration.seconds(1));
            wait.setOnFinished(e -> loadNextScreen(index + 1));
            wait.play();
        } else {
            loadScreensController.setProgress(maxProgress, "Recursos cargados...");

            PauseTransition finalWait = new PauseTransition(Duration.seconds(3));
            finalWait.setOnFinished(e -> changeScene());
            finalWait.play();
        }
    }

    private void changeScene() {

        UserDataFile.theUserHaveAnyAccount();

    }

}
