package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.Colors;
import utilities.PathManager;

import java.io.InputStream;
import java.util.List;

public class PopupOneButtonController {

    //Variables
    private boolean isDarkMode;

    //Variables de tamaño
    private static final double MIN_HEIGHT = 120.0;
    private static final double MAX_HEIGHT = 400.0;
    private static final double MAX_SCROLL = 225.0;
    private static final double MIN_SCROLL = 10.0;

    //Variables de color
    //Botón primario
    private static String principalButtonBackground;
    private static String principalButtonBorder;
    private static String principalButtonFontColor;
    private static String principalButtonBackgroundHover;
    private static String principalButtonBorderHover;
    private static String principalButtonFontColorHover;

    @FXML
    private AnchorPane APMain;

    @FXML
    private Button BTNAccept;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private ScrollPane SPContent;

    @FXML
    private TextFlow TFLContent;

    @FXML
    private TextFlow TFLFooter;

    @FXML
    private TextFlow TFLHeader;

    @FXML
    private VBox rootVBox;

    @FXML
    public void initialize(){

        isDarkMode = UserPreferences.getUserThemeMode();

        Platform.runLater(() -> {
            try {
                if (SPContent != null) {
                    SPContent.setFitToWidth(true);
                    SPContent.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                    SPContent.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                    SPContent.setMaxHeight(MAX_SCROLL);
                    SPContent.setPrefViewportHeight(MIN_SCROLL);
                }
                if (APMain != null) {
                    APMain.setPrefHeight(MIN_HEIGHT);
                    APMain.setMaxHeight(MAX_HEIGHT);
                }
                adjustSizeToContent();
            } catch (Exception ignored) {}
        });

        changeTheme();

    }

    private void changeTheme(){

        StyleBuilder.setAnchorPaneClass(APMain);

        ConfigureNodes.configureNodesForPopupOneButtonController(BTNAccept, isDarkMode);

        changeColors();

    }

    public boolean getMode() {
        return isDarkMode;
    }

    public void setTFLHeader(Text text) {
        if (TFLHeader == null) return;
        TFLHeader.getChildren().clear();
        if (text != null) TFLHeader.getChildren().add(text);
        adjustSizeToContent();
    }

    public void setTFLContent(List<Text> texts) {
        if (TFLContent == null) return;
        TFLContent.getChildren().clear();
        if (texts != null && !texts.isEmpty()) TFLContent.getChildren().addAll(texts);
        adjustSizeToContent();
    }

    public void setTFLFooter(Text text) {
        if (TFLFooter == null) return;
        TFLFooter.getChildren().clear();
        if (text != null) TFLFooter.getChildren().add(text);
        adjustSizeToContent();
    }

    public void setTextButton(String text) {
        if (BTNAccept != null) BTNAccept.setText(text == null ? "" : text);
        adjustSizeToContent();
    }

    public void setIcon(String darkImagePath, String lightImagePath) {
        if (IMGIcon == null) return;
        String path = isDarkMode ? darkImagePath : lightImagePath;
        if (path == null) return;

        try (InputStream is = getClass().getResourceAsStream(PathManager.getImagePath(path))) {
            if (is != null) {
                IMGIcon.setImage(new Image(is));
            } else {
                try (InputStream is2 = getClass().getResourceAsStream(path)) {
                    if (is2 != null) IMGIcon.setImage(new Image(is2));
                } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}

        adjustSizeToContent();
    }

    /**
     * Ajusta el tamaño del ScrollPane y del AnchorPane según el contenido real.
     * Si el contenido excede MAX_SCROLL, el ScrollPane se fija en MAX_SCROLL y se muestra scrollbar.
     */
    private void adjustSizeToContent() {
        if (APMain == null || SPContent == null || rootVBox == null) return;

        Platform.runLater(() -> {
            try {
                APMain.applyCss();
                APMain.layout();

                Node contentNode = SPContent.getContent();
                double contentHeight = 0.0;

                if (contentNode != null) {
                    // applyCss está en Node; layout() solo en Parent -> casteamos si es necesario
                    contentNode.applyCss();
                    if (contentNode instanceof Parent) {
                        ((Parent) contentNode).layout();
                    }

                    // si es Region (VBox, etc.) usamos prefHeight(-1) para tamaño "natural"
                    if (contentNode instanceof Region) {
                        try {
                            contentHeight = ((Region) contentNode).prefHeight(-1);
                        } catch (Exception e) {
                            contentHeight = contentNode.getBoundsInLocal().getHeight();
                        }
                    } else {
                        // fallback a bounds
                        contentHeight = contentNode.getBoundsInLocal().getHeight();
                    }

                    if (contentHeight <= 0) {
                        contentHeight = contentNode.getBoundsInLocal().getHeight();
                    }
                }

                double scrollDesired = Math.min(MAX_SCROLL, Math.max(MIN_SCROLL, contentHeight));
                boolean needsScroll = contentHeight > MAX_SCROLL;
                SPContent.setVbarPolicy(needsScroll ? ScrollPane.ScrollBarPolicy.AS_NEEDED : ScrollPane.ScrollBarPolicy.NEVER);

                SPContent.setPrefViewportHeight(scrollDesired);
                SPContent.setMaxHeight(MAX_SCROLL);

                double iconH = 0;
                if (IMGIcon != null && IMGIcon.getImage() != null) {
                    // ImageView no siempre expone prefHeight de forma fiable: usamos bounds
                    iconH = IMGIcon.getBoundsInParent().getHeight();
                    if (iconH <= 0) iconH = IMGIcon.getBoundsInLocal().getHeight();
                }

                double buttonH = 0;
                if (BTNAccept != null) {
                    try {
                        buttonH = BTNAccept.prefHeight(-1);
                    } catch (Exception e) {
                        buttonH = BTNAccept.getBoundsInParent().getHeight();
                    }
                    if (buttonH <= 0) buttonH = BTNAccept.getBoundsInParent().getHeight();
                }

                Insets p = rootVBox.getPadding();
                double paddingTop = (p != null) ? p.getTop() : 0;
                double paddingBottom = (p != null) ? p.getBottom() : 0;
                double spacing = rootVBox.getSpacing();

                double totalDesired = iconH + scrollDesired + buttonH + paddingTop + paddingBottom + (spacing * 2);
                double finalHeight = Math.min(MAX_HEIGHT, Math.max(MIN_HEIGHT, totalDesired));
                APMain.setPrefHeight(finalHeight);

                if (APMain.getScene() != null) {
                    Stage stage = (Stage) APMain.getScene().getWindow();
                    if (stage != null) {
                        stage.sizeToScene();
                        stage.centerOnScreen();
                    }
                }
            } catch (Exception ignored) {
                // no rompemos la app por un cálculo de layout
            }
        });
    }

    private void changeColors(){

        //Botón primario
        principalButtonBackground = Colors.getColor("principal-button-background", isDarkMode);
        principalButtonBorder = Colors.getColor("principal-button-border", isDarkMode);
        principalButtonFontColor = Colors.getColor("principal-button-font-color", isDarkMode);
        principalButtonBackgroundHover = Colors.getColor("principal-button-background-hover", isDarkMode);
        principalButtonBorderHover = Colors.getColor("principal-button-border-hover", isDarkMode);
        principalButtonFontColorHover = Colors.getColor("principal-button-font-color-hover", isDarkMode);

    }

    @FXML
    void BTNAcceptOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage) BTNAccept.getScene().getWindow();
        stage.close();


    }

    @FXML
    void BTNAcceptOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNAccept,
                principalButtonBackground, principalButtonBackgroundHover,
                principalButtonBorder, principalButtonBorderHover,
                principalButtonFontColor, principalButtonFontColorHover

        );

    }

    @FXML
    void BTNAcceptOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNAccept,
                principalButtonBackgroundHover, principalButtonBackground,
                principalButtonBorderHover, principalButtonBorder,
                principalButtonFontColorHover, principalButtonFontColor

        );

    }

}
