package launcher;

import files.FileManager;
import files.Preferences;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utilities.FileConstants;
import utilities.PathManager;
import utilities.ScreenManager;
import utilities.Titles;

public class Program extends Application {

    public static void main(String[] args) {

        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {

        ScreenManager sm = ScreenManager.getInstance();
        sm.setPrimaryStage(stage);

        Font.loadFont(getClass().getResourceAsStream(PathManager.getFontPath(FileConstants.oswaldSemiBold)), 30);

        FileManager fm = new FileManager("Maleex Team", "Danvlec");

        Preferences pf = new Preferences();
        pf.theUserChooseATheme();

        sm.loadScreen(FileConstants.LoadScreens,FileConstants.LoadScreensFXML);
        sm.setScreen(FileConstants.LoadScreens, Titles.LoadScreens);

    }
}
