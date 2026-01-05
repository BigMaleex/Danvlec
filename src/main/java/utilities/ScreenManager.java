package utilities;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
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
import javafx.stage.Screen;
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

    public boolean setScreen(String id, String title) {
        Parent screen = screens.get(id);
        if (screen == null) return false;

        primaryStage.setTitle(title);
        mainContainer.getChildren().setAll(screen);

        // Forzar cálculo de CSS/layout y ajustar tamaño de stage a la escena
        screen.applyCss();
        screen.layout();
        primaryStage.sizeToScene();

        // Intento inmediato de centrar (normalmente funcionará si sizeToScene fue suficiente)
        centerStageOnScreen(primaryStage);

        // Aseguramos recenter después del siguiente frame (por si width/height cambian al mostrar)
        Platform.runLater(() -> centerStageOnScreen(primaryStage));

        // Mostrar si no está visible
        if (!primaryStage.isShowing()) {
            primaryStage.show();
        } else {
            // Si ya estaba visible, opcional: revalidate layout y volver a centrar
            primaryStage.sizeToScene();
            Platform.runLater(() -> centerStageOnScreen(primaryStage));
        }

        return true;
    }

    /**
     * Centra el stage en la pantalla (visual bounds).
     * Usa la pantalla primaria. Si quieres soporte multi-monitor más complejo
     * podemos buscar la Screen más adecuada según coordenadas.
     */
    private void centerStageOnScreen(Stage stage) {
        if (stage == null) return;

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        // Asegurarnos de que width/height estén definidos
        double stageWidth = stage.getWidth() <= 0 ? stage.getScene().getWidth() : stage.getWidth();
        double stageHeight = stage.getHeight() <= 0 ? stage.getScene().getHeight() : stage.getHeight();

        double x = visualBounds.getMinX() + (visualBounds.getWidth() - stageWidth) / 2.0;
        double y = visualBounds.getMinY() + (visualBounds.getHeight() - stageHeight) / 2.0;

        stage.setX(x);
        stage.setY(y);
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
        Stage popup = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(PathManager.getFxmlPath(fxmlFile)));
            Parent root = loader.load();

            if (configurator != null) {
                configurator.configure(loader.getController());
            }

            // --- crear y agregar overlay ---
            overlay = new Rectangle();
            overlay.widthProperty().bind(mainContainer.widthProperty());
            overlay.heightProperty().bind(mainContainer.heightProperty());
            overlay.setFill(Color.rgb(0, 0, 0, 0.45));
            overlay.setMouseTransparent(false);
            mainContainer.getChildren().add(overlay);

            // --- preparar popup ---
            popup = new Stage();
            configureStage(popup);
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.initOwner(primaryStage);
            popup.setTitle(title);

            Scene popupScene = new Scene(root);
            popupScene.setFill(Color.TRANSPARENT);
            popup.setScene(popupScene);

            root.applyCss();
            root.layout();
            popup.sizeToScene();
            popup.centerOnScreen();

            // cuando el popup se cierre, remover overlay (lo hace siempre, incluso si usamos Platform.runLater)
            final Rectangle overlayRef = overlay;
            popup.setOnHidden(evt -> {
                if (overlayRef != null && mainContainer.getChildren().contains(overlayRef)) {
                    mainContainer.getChildren().remove(overlayRef);
                }
            });

            // Mostrar el popup *después* de que termine la animación/layout para evitar IllegalStateException.
            // Lo hacemos con Platform.runLater, y dentro intentamos showAndWait; si aún falla, caemos a show().
            final Stage popupRef = popup;
            Platform.runLater(() -> {
                try {
                    popupRef.showAndWait();
                } catch (IllegalStateException ex) {
                    // Fallback: si por alguna razón aún da error, mostramos sin bloquear
                    try {
                        popupRef.show();
                    } catch (Exception ignore) {
                        // si esto falla, no hacemos nada más aquí
                        ignore.printStackTrace();
                    }
                }
            });

            // Nota: retornamos true porque la creación/programación del popup fue exitosa.
            // Si necesitas comportamiento estrictamente síncrono (esperar hasta que el popup termine),
            // debes evitar llamar a este método desde un handler de animación/layout y en su lugar
            // llamar a este método desde Platform.runLater() a nivel superior.
            return true;

        } catch (IOException e) {
            System.err.println("Error en popup: " + fxmlFile);
            e.printStackTrace();
            // si algo falló antes de llegar al popup, quitar overlay si fue agregado
            if (overlay != null && mainContainer.getChildren().contains(overlay)) {
                mainContainer.getChildren().remove(overlay);
            }
            return false;
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