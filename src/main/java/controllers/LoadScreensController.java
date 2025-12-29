package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import logical.LoadScreens;
import stylebuilder.StyleBuilder;
import user.UserPreferences;

public class LoadScreensController {

    //Referencias
    private Timeline currentAnimation;
    private PauseTransition pause, pause2;

    //Variables
    boolean isDarkMode;
    double actualProgress = 0;

    @FXML
    private AnchorPane APMain;

    @FXML
    private Label LBLContent;

    @FXML
    private ProgressBar PBProgress;

    @FXML
    public void initialize (){

        if (pause != null) pause.stop();
        if (pause2 != null) pause2.stop();
        isDarkMode = UserPreferences.getUserThemeMode();
        changeTheme();
        LBLContent.setText("Bienvenid@");

        pause = new PauseTransition(Duration.seconds(2.5));
        pause.setOnFinished(event -> {

            resetProgress("Bienvenid@");

            pause2 = new PauseTransition(Duration.seconds(2.2));
            pause2.setOnFinished(e ->{

                //Empezar a validar
                LoadScreens load = new LoadScreens();
                load.loadScreens();

            });

            pause2.play();

        });

        pause.play();

    }

    private void changeTheme(){

        StyleBuilder.setAnchorPaneClass(APMain);

    }

    public void setProgress(double progress, String message) {
        if (progress < 0 || progress > 1) {
            System.err.println("El valor de progreso debe estar entre 0.0 y 1.0: " + progress);
            return;
        }

        actualProgress = progress;

        animateProgressBar(message, progress);
    }

    public void animateProgressBar(String message, double finalValue) {
        if (currentAnimation != null) {
            currentAnimation.stop();
        }

        double startValue = PBProgress.getProgress();
        double distance = Math.abs(finalValue - startValue);

        double durationSeconds = Math.min(1.0, Math.max(0.3, distance * 1.5));

        currentAnimation = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(PBProgress.progressProperty(), startValue)),
                new KeyFrame(Duration.seconds(durationSeconds),
                        new KeyValue(PBProgress.progressProperty(), finalValue))
        );

        currentAnimation.play();

        if (message != null) {
            LBLContent.setText(message);
        }
    }

    public double getProgress() {
        return actualProgress;
    }

    public void completeProgress(String message) {
        setProgress(1.0, message != null ? message : "Proceso completado");
    }

    public void resetProgress(String message) {
        setProgress(0.0, message != null ? message : "Iniciando proceso...");
    }


}
