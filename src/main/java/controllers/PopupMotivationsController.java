package controllers;

import com.sun.tools.javac.Main;
import connections.Users;
import files.UserDataFile;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.StyleBuilder;
import user.UserData;
import user.UserPreferences;
import utilities.Colors;
import utilities.FileConstants;
import utilities.ScreenManager;
import utilities.Styles;

public class PopupMotivationsController extends ConfigureInitializeStyles {

    //Objetos
    ScreenManager sm = ScreenManager.getInstance();

    //PseudoClases
    private static final PseudoClass LBLErr = PseudoClass.getPseudoClass("Error");

    //Variables
    private boolean isDarkMode, allConditionsMet, pastAllConditionsMet, maxCharsState, pastMaxCharsState;

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

    //Botón desactivado
    private static String buttonBackgroundDisabled;
    private static String buttonBorderDisabled;
    private static String buttonFontColorDisabled;

    @FXML
    private AnchorPane APMain;

    @FXML
    private Button BTNAccept;

    @FXML
    private Button BTNClose;

    @FXML
    private ImageView IMGButtonAccept;

    @FXML
    private ImageView IMGButtonAcceptHover;

    @FXML
    private ImageView IMGButtonClose;

    @FXML
    private ImageView IMGButtonCloseHover;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private Label LBLButtonAccept;

    @FXML
    private Label LBLButtonClose;

    @FXML
    private Label LBLHeader;

    @FXML
    private Label LBLMaxChars;

    @FXML
    private Label LBLMaxCharsCount;

    @FXML
    private Label LBLSubHeader;

    @FXML
    private TextArea TXTMotivation;

    @FXML
    private void initialize (){

        isDarkMode = UserPreferences.getUserThemeMode();

        LBLButtonClose.setText("Regresar");
        LBLButtonAccept.setText(UserData.getMotivation() == null ? "Guardar" : "Actualizar");

        setImages(UserData.getMotivation() == null ? FileConstants.plusIconDm : FileConstants.pencilIconDm, UserData.getMotivation() == null? FileConstants.plusIconLm : FileConstants.pencilIconLm, isDarkMode, IMGIcon);

        LBLHeader.setText(UserData.getMotivation() == null ? "Añade tus motivaciones" : "Edita tus motivaciones");

        LBLSubHeader.setText(UserData.getMotivation() == null ? "Añade tus motivaciones para que puedas recordar por que tratas todos los días de mejorar" : "Edita tus motivaciones para que puedas recordar por que tratas todos los días de mejorar");

        TXTMotivation.setPromptText(UserData.getMotivation() == null? "Añade aquí una motivación para continuar con tu proceso" : "Modifica aquí tu motivación para continuar con tu proceso");

        StyleBuilder.clearControls(TXTMotivation);

        removeTheOpacityFromTheImageViews(IMGButtonAcceptHover, IMGButtonCloseHover);

        allConditionsMet = false;
        pastAllConditionsMet = true;

        maxCharsState = false;
        pastMaxCharsState = true;

        TXTMotivation.textProperty().addListener((obs, oldVal, newVal) -> {

            validateField();
            validateLength();

        });

        validateField();

        changeTheme();

    }

    private void changeTheme(){

        changeColors();

        StyleBuilder.setAnchorPaneClass(APMain);

        applyStylesToButtonsWithLabel(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase[] {BTNClose}, new Label [] {LBLButtonClose});

        setImages(FileConstants.arrowLeftSecondaryDm, FileConstants.arrowLeftSecondaryLm, isDarkMode, IMGButtonClose);
        setImages(FileConstants.arrowLeftSecondaryHoverDm, FileConstants.arrowLeftSecondaryHoverLm, isDarkMode, IMGButtonCloseHover);

        setImages(FileConstants.arrowRightPrimaryDm, FileConstants.arrowRightPrimaryLm, isDarkMode, IMGButtonAccept);
        setImages(FileConstants.arrowRightPrimaryHoverDm, FileConstants.arrowRightPrimaryLm, isDarkMode, IMGButtonAcceptHover);

        if(allConditionsMet){

            applyStylesToButtonsWithLabel(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNAccept}, new Label [] {LBLButtonAccept});
            BTNAccept.setOpacity(1);
            IMGButtonAccept.setOpacity(1);

        }else{

            applyStylesToButtonsWithLabel(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNAccept}, new Label [] {LBLButtonAccept});
            BTNAccept.setOpacity(0.66);
            IMGButtonAccept.setOpacity(0);

        }



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

        //Botón desactivado
        buttonBackgroundDisabled = Colors.getColor("button-background-disabled", isDarkMode);
        buttonBorderDisabled = Colors.getColor("button-border-disabled", isDarkMode);
        buttonFontColorDisabled = Colors.getColor("button-font-color-disabled", isDarkMode);

    }

    @FXML
    void BTNAcceptOnMouseClicked(MouseEvent event) {

        if(allConditionsMet){

            UserData.setMotivation(StyleBuilder.clearStringFormat(TXTMotivation.getText()));

            if(UserData.haveAnyAccount()){

                Users users = new Users();

                users.setMotivation();

            }else{

                UserDataFile file = new UserDataFile();

                file.createFile(true);

            }

            MainWindowController controller = (MainWindowController) sm.getController(FileConstants.MainWindow);

            controller.updateMotivation();

            BTNCloseOnMouseClicked(event);

        }

    }

    @FXML
    void BTNAcceptOnMouseEntered(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    principalButtonBackground, principalButtonBackgroundHover,
                    principalButtonBorder, principalButtonBorderHover,
                    principalButtonFontColor, principalButtonFontColorHover,
                    BTNAccept, IMGButtonAccept, IMGButtonAcceptHover, LBLButtonAccept

            );

        }

    }

    @FXML
    void BTNAcceptOnMouseExited(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    principalButtonBackgroundHover, principalButtonBackground,
                    principalButtonBorderHover, principalButtonBorder,
                    principalButtonFontColorHover, principalButtonFontColor,
                    BTNAccept, IMGButtonAcceptHover, IMGButtonAccept, LBLButtonAccept

            );

        }

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage)BTNClose.getScene().getWindow();

        stage.close();

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover,
                BTNClose, IMGButtonClose, IMGButtonCloseHover, LBLButtonClose

        );

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    secondaryButtonBackgroundHover, secondaryButtonBackground,
                    secondaryButtonBorderHover, secondaryButtonBorder,
                    secondaryButtonFontColorHover, secondaryButtonFontColor,
                    BTNClose, IMGButtonCloseHover, IMGButtonClose, LBLButtonClose

        );

    }

    private void validateLength(){

        int len = TXTMotivation.getText().length();

        maxCharsState = len > 4000;

        LBLMaxCharsCount.setText(len + "/4000");

        if(maxCharsState != pastMaxCharsState){

            TXTMotivation.pseudoClassStateChanged(LBLErr, maxCharsState);
            LBLMaxChars.pseudoClassStateChanged(LBLErr, maxCharsState);
            LBLMaxCharsCount.pseudoClassStateChanged(LBLErr, maxCharsState);

            pastMaxCharsState = maxCharsState;

        }

    }

    private void validateField(){

        allConditionsMet = (!TXTMotivation.getText().isBlank()) && (TXTMotivation.getText().length() <= 4000);

        if(allConditionsMet != pastAllConditionsMet){

            if(allConditionsMet){

                applyStylesToButtonsWithLabel(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNAccept}, new Label [] {LBLButtonAccept});
                BTNAccept.setOpacity(1);
                IMGButtonAccept.setOpacity(1);

            }else{

                applyStylesToButtonsWithLabel(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNAccept}, new Label [] {LBLButtonAccept});
                BTNAccept.setOpacity(0.66);
                IMGButtonAccept.setOpacity(0);

            }

            pastAllConditionsMet = allConditionsMet;

        }

    }

}
