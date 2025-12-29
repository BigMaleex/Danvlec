package utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScreenManager {

    private static ScreenManager instance;
    private Stage primaryStage;
    private final StackPane mainContainer = new StackPane();
    private final Map<String, Parent> screens = new HashMap<>();
    private final Map<String, Object> controllers = new HashMap<>();

    @FunctionalInterface
    public interface PopupControllerConfigurator {
        void configure(Object controller);
    }

    private ScreenManager() {}

    public static synchronized ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    /**
     * Configura y muestra el stage principal con transparencia y esquinas redondeadas.
     */
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
        // Icono, estilo transparente y sin decoración
        configureStage(primaryStage);

        // Asegurar que el contenedor no pinte ningún fondo
        mainContainer.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, null)));

        // Crear escena con fondo transparente
        Scene scene = new Scene(mainContainer);
        scene.setFill(Color.TRANSPARENT);

        // Clip de esquinas redondeadas para recortar borde
        Rectangle clip = new Rectangle();
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        clip.widthProperty().bind(scene.widthProperty());
        clip.heightProperty().bind(scene.heightProperty());
        mainContainer.setClip(clip);

        primaryStage.setScene(scene);
    }

    /**
     * Carga un FXML pero no lo muestra aún.
     */
    public boolean loadScreen(String id, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource(PathManager.getFxmlPath(fxmlFile)));
            Parent root = loader.load();
            controllers.put(id, loader.getController());
            screens.put(id, root);
            return true;
        } catch (IOException e) {
            System.err.println("Error loading FXML: " + fxmlFile);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Muestra la pantalla cargada previamente.
     */
    public boolean setScreen(String id, String title) {
        Parent screen = screens.get(id);
        if (screen == null) return false;

        primaryStage.setTitle(title);
        mainContainer.getChildren().setAll(screen);
        screen.applyCss();
        screen.layout();
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();

        if (!primaryStage.isShowing()) {
            primaryStage.show();
        }
        return true;
    }

    /**
     * Muestra pantalla sin cambiar posición del stage.
     */
    public boolean setScreenAtPosition(String id, String title) {
        double x = primaryStage.getX();
        double y = primaryStage.getY();
        boolean shown = setScreen(id, title);
        if (shown) {
            primaryStage.setX(x);
            primaryStage.setY(y);
        }
        return shown;
    }

    /**
     * Abre un popup modal con controlador configurable.
     */
    public boolean openDynamicPopup(String fxmlFile, String title, PopupControllerConfigurator configurator) {
        Rectangle overlay = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource(PathManager.getFxmlPath(fxmlFile)));
            Parent root = loader.load();

            if (configurator != null) {
                configurator.configure(loader.getController());
            }

            // Crear overlay y ligarlo al tamaño del mainContainer
            overlay = new Rectangle();
            overlay.widthProperty().bind(mainContainer.widthProperty());
            overlay.heightProperty().bind(mainContainer.heightProperty());
            overlay.setFill(Color.rgb(0, 0, 0, 0.45)); // negro semi-transparente
            overlay.setMouseTransparent(false); // consume eventos (opcional)
            // insertar overlay encima del contenido actual
            mainContainer.getChildren().add(overlay);

            Stage popup = new Stage();
            configureStage(popup);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.initOwner(primaryStage);
            popup.setTitle(title);

            // Fondo transparente para popup (si tu FXML usa formas con esquinas)
            Scene popupScene = new Scene(root);
            popupScene.setFill(Color.TRANSPARENT);
            popup.setScene(popupScene);

            root.applyCss();
            root.layout();
            popup.sizeToScene();
            popup.centerOnScreen();

            // showAndWait() bloqueará hasta que el popup se cierre
            popup.showAndWait();
            return true;
        } catch (IOException e) {
            System.err.println("Error en popup: " + fxmlFile);
            e.printStackTrace();
            return false;
        } finally {
            // Asegurarse de quitar el overlay aunque ocurra un error
            if (overlay != null) {
                mainContainer.getChildren().remove(overlay);
            }
        }
    }

    /**
     * Establece icono, estilo transparente y sin bordes.
     */
    private void configureStage(Stage stage) {
        stage.getIcons().add(new Image(
                getClass().getResourceAsStream(
                        PathManager.getImagePath(FileConstants.faviconImage)
                )));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
    }

    public Object getController(String id) {
        return controllers.get(id);
    }

    public void closeApplication() {
        primaryStage.close();
    }
}