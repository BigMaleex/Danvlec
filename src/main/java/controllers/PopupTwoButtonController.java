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
import logical.PopupTwoButtonInputs;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.Colors;
import utilities.Options;
import utilities.PathManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopupTwoButtonController {

    //Variables
    private boolean isDarkMode;
    private static Options.options option;

    //Array
    private static ArrayList<String> data = new ArrayList<>();

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

    //Botón secundario
    private static String secondaryButtonBackground;
    private static String secondaryButtonBorder;
    private static String secondaryButtonFontColor;
    private static String secondaryButtonBackgroundHover;
    private static String secondaryButtonBorderHover;
    private static String secondaryButtonFontColorHover;

    @FXML
    private AnchorPane APMain;

    @FXML
    private Button BTNAccept;

    @FXML
    private Button BTNCancel;

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

        ConfigureNodes.configureNodesForPopupTwoButtonController(BTNAccept, BTNCancel, isDarkMode);

        changeColors();

    }

    private void changeColors(){

        //Botón primario
        principalButtonBackground = Colors.getColor("principal-button-background", isDarkMode);
        principalButtonBorder = Colors.getColor("principal-button-border", isDarkMode);
        principalButtonFontColor = Colors.getColor("principal-button-font-color", isDarkMode);
        principalButtonBackgroundHover = Colors.getColor("principal-button-background-hover", isDarkMode);
        principalButtonBorderHover = Colors.getColor("principal-button-border-hover", isDarkMode);
        principalButtonFontColorHover = Colors.getColor("principal-button-font-color-hover", isDarkMode);

        //Botón secundario
        secondaryButtonBackground = Colors.getColor("secondary-button-background", isDarkMode);
        secondaryButtonBorder = Colors.getColor("secondary-button-border", isDarkMode);
        secondaryButtonFontColor = Colors.getColor("secondary-button-font-color", isDarkMode);
        secondaryButtonBackgroundHover = Colors.getColor("secondary-button-background-hover", isDarkMode);
        secondaryButtonBorderHover = Colors.getColor("secondary-button-border-hover", isDarkMode);
        secondaryButtonFontColorHover = Colors.getColor("secondary-button-font-color-hover", isDarkMode);


    }

    public boolean getMode() {
        return isDarkMode;
    }

    public void setOption (Options.options newOption) {

        option = newOption;

    }

    public void setData(String [] newData){

        data.clear();
        data.addAll(Arrays.asList(newData));

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

    public void setTextButton(String textCancelButton, String textAcceptButton) {
        if (BTNAccept != null) BTNAccept.setText(textAcceptButton == null ? "" : textAcceptButton);
        if (BTNCancel != null) BTNCancel.setText(textCancelButton == null ? "" : textCancelButton);
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

    @FXML
    void BTNAcceptOnMouseClicked(MouseEvent event) {

        switch(option){

            case askTheUserIfTheyWantToSaveTheirInformation ->{

                PopupTwoButtonInputs.askTheUserIfTheyWantToSaveTheirInformation(true);

            }

            case allUserInformationIsCorrectUploadToTheBD ->{

                PopupTwoButtonInputs.allUserInformationIsCorrectUploadToTheBD(data);

            }

            case allUserInformationIsCorrectFromGuestGenerateFile -> {

                PopupTwoButtonInputs.allUserInformationIsCorrectFromGuestGenerateFile(data);

            }

            case allClockInformationIsCorrectWithAccount -> {



            }

            case allClockInformationIsCorrectWithoutAccount -> {

                

            }

            default ->{
                System.out.println("La opción " + option + " aún no ha sido configurada");
            }

        }

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

    @FXML
    void BTNCancelOnMouseClicked(MouseEvent event) {

        switch(option){

            case askTheUserIfTheyWantToSaveTheirInformation ->{

                PopupTwoButtonInputs.askTheUserIfTheyWantToSaveTheirInformation(false);

            }

            default ->{
                System.out.println("La opción " + option + " aún no ha sido configurada");
            }

        }

        Stage stage = (Stage) BTNAccept.getScene().getWindow();
        stage.close();

    }

    @FXML
    void BTNCancelOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNCancel,
                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover

        );

    }

    @FXML
    void BTNCancelOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNCancel,
                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder,
                secondaryButtonFontColorHover, secondaryButtonFontColor

        );

    }

}
