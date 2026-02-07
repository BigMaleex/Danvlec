package controllers;

import controls.SerialTextField;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.Colors;
import utilities.FileConstants;

public class PopupRecoveryAccountController extends ConfigureInitializeStyles {

    private enum Mode {

        EmailMode, CodeMode

    }

    private enum Step {

        First, Second, Third

    }

    //Objetos
    private SerialTextField TXT24Chars = new SerialTextField(24);

    //Pseudo clase
    private PseudoClass methodButton = PseudoClass.getPseudoClass("Active");

    //Variables
    private boolean isDarkMode = false, passwordVisible = false, confirmPasswordVisible = false;
    private Step currentStep;
    private Mode currentMode;

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

    //PopupTitleBarButton
    private static String popupTitleBarCloseButtonBackground;
    private static String popupTitleBarCloseButtonBorder;
    private static String popupTitleBarCloseButtonFontColor;

    private static String popupTitleBarCloseButtonBackgroundHover;
    private static String popupTitleBarCloseButtonBorderHover;
    private static String popupTitleBarCloseButtonFontColorHover;

    //Botón oculto (Solo se usa en el stack Pane, no es necesaria la fuente)
    private static String hideButtonBackground;
    private static String hideButtonBorder;

    private static String hideButtonBackgroundHover;
    private static String hideButtonBorderHover;

    @FXML
    private AnchorPane APMain;

    @FXML
    private Button BTNClose;

    @FXML
    private Button BTNCodeMethod;

    @FXML
    private Button BTNEmailMethod;

    @FXML
    private Button BTNPrimary;

    @FXML
    private Button BTNSecondary;

    @FXML
    private HBox HBXCodeEmailMethod;

    @FXML
    private ImageView IMGButtonCodeMethod;

    @FXML
    private ImageView IMGButtonEmailMethod;

    @FXML
    private ImageView IMGButtonPrimary;

    @FXML
    private ImageView IMGButtonPrimaryHover;

    @FXML
    private ImageView IMGButtonSecondary;

    @FXML
    private ImageView IMGButtonSecondaryHover;

    @FXML
    private ImageView IMGChangePasswordHover;

    @FXML
    private ImageView IMGChangePasswordIcon;

    @FXML
    private ImageView IMGChangePassword;

    @FXML
    private ImageView IMGCodeDescription;

    @FXML
    private ImageView IMGConfirmChangePasswordHover;

    @FXML
    private ImageView IMGConfirmChangePasswordIcon;

    @FXML
    private ImageView IMGConfirmChangePassword;

    @FXML
    private ImageView IMGEmailMethodDescription;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private Label LBLButtonPrimary;

    @FXML
    private Label LBLButtonSecondary;

    @FXML
    private Label LBLCodeDescription;

    @FXML
    private Label LBLEmailMethodDescription;

    @FXML
    private PasswordField PSFChangePassword;

    @FXML
    private PasswordField PSFConfirmChangePassword;

    @FXML
    private StackPane SPChangePassword;

    @FXML
    private StackPane SPCode;

    @FXML
    private StackPane SPCodeNotWorkAdvice;

    @FXML
    private StackPane SPCodeOfTheCodeMethod;

    @FXML
    private StackPane SPChangePasswordButton;

    @FXML
    private StackPane SPConfirmChangePasswordButton;

    @FXML
    private StackPane SPEmail;

    @FXML
    private StackPane SPEmailFound;

    @FXML
    private StackPane SPFooterBar;

    @FXML
    private StackPane SPMethodSelector;

    @FXML
    private StackPane SPTitleBar;

    @FXML
    private TextFlow TFLEmailFound;

    @FXML
    private TextField TXTChangePassword;

    @FXML
    private TextField TXTCode1EmailMethod;

    @FXML
    private TextField TXTCode2EmailMethod;

    @FXML
    private TextField TXTCode3EmailMethod;

    @FXML
    private TextField TXTCode4EmailMethod;

    @FXML
    private TextField TXTCode5EmailMethod;

    @FXML
    private TextField TXTCode6EmailMethod;

    @FXML
    private TextField TXTConfirmChangePassword;

    @FXML
    private TextField TXTEmailOfTheEmailMethod;

    @FXML
    void initialize(){

        isDarkMode = UserPreferences.getUserThemeMode();

        //Ligar Managed con visibility
        SPCode.managedProperty().bind(SPCode.visibleProperty());
        SPEmail.managedProperty().bind(SPEmail.visibleProperty());
        SPMethodSelector.managedProperty().bind(SPMethodSelector.visibleProperty());
        SPChangePassword.managedProperty().bind(SPChangePassword.visibleProperty());
        TXT24Chars.managedProperty().bind(TXT24Chars.visibleProperty());
        BTNSecondary.managedProperty().bind(BTNSecondary.visibleProperty());

        //Ocultar elementos
        TXTConfirmChangePassword.setVisible(false);
        TXTConfirmChangePassword.setManaged(false);

        TXTChangePassword.setVisible(false);
        TXTChangePassword.setManaged(false);

        IMGConfirmChangePasswordHover.setOpacity(0);
        IMGChangePasswordHover.setOpacity(0);
        IMGButtonPrimaryHover.setOpacity(0);
        IMGButtonSecondaryHover.setOpacity(0);

        //Inicializar paso y modo
        currentMode = Mode.EmailMode;

        changeSelection();

        changeTheme();

    }

    private void changeTheme(){

        StyleBuilder.setAnchorPaneClass(APMain);

        changeColors();

        ConfigureNodes.configureNodesForPopupRecoveryAccount(BTNClose, IMGButtonCodeMethod, IMGButtonEmailMethod, IMGChangePasswordHover, IMGChangePasswordIcon, IMGChangePassword, IMGConfirmChangePasswordHover, IMGConfirmChangePasswordIcon, IMGConfirmChangePassword, IMGIcon, isDarkMode, passwordVisible, confirmPasswordVisible);

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

        //Popup Title Bar Button
        popupTitleBarCloseButtonBackground = Colors.getColor("popup-title-bar-close-button-background", isDarkMode);
        popupTitleBarCloseButtonBorder = Colors.getColor("popup-title-bar-close-button-border", isDarkMode);
        popupTitleBarCloseButtonFontColor = Colors.getColor("popup-title-bar-close-button-font-color", isDarkMode);

        popupTitleBarCloseButtonBackgroundHover = Colors.getColor("popup-title-bar-close-button-background-hover", isDarkMode);
        popupTitleBarCloseButtonBorderHover = Colors.getColor("popup-title-bar-close-button-border-hover", isDarkMode);
        popupTitleBarCloseButtonFontColorHover = Colors.getColor("popup-title-bar-close-button-font-color-hover", isDarkMode);

        //Botón oculto
        hideButtonBackground = Colors.getColor("hide-button-background", isDarkMode);
        hideButtonBorder = Colors.getColor("hide-button-border", isDarkMode);

        hideButtonBackgroundHover = Colors.getColor("hide-button-background-hover", isDarkMode);
        hideButtonBorderHover = Colors.getColor("hide-button-border-hover", isDarkMode);

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage) BTNClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {

                StyleBuilder.animateButtonColors(

                BTNClose,
                popupTitleBarCloseButtonBackground, popupTitleBarCloseButtonBackgroundHover,
                popupTitleBarCloseButtonBorder, popupTitleBarCloseButtonBorderHover,
                popupTitleBarCloseButtonFontColor, popupTitleBarCloseButtonFontColorHover

        );

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

                StyleBuilder.animateButtonColors(

                BTNClose,
                popupTitleBarCloseButtonBackgroundHover, popupTitleBarCloseButtonBackground,
                popupTitleBarCloseButtonBorderHover, popupTitleBarCloseButtonBorder,
                popupTitleBarCloseButtonFontColorHover, popupTitleBarCloseButtonFontColor

        );

    }

    @FXML
    void BTNCodeMethodOnMouseClicked(MouseEvent event) {

        if(currentMode != Mode.CodeMode){

            currentMode = Mode.CodeMode;

            changeSelection();

        }

    }

    @FXML
    void BTNEmailMethodOnMouseClicked(MouseEvent event) {

        if(currentMode != Mode.EmailMode){

            currentMode = Mode.EmailMode;

            changeSelection();

        }

    }

    @FXML
    void BTNPrimaryOnMouseClicked(MouseEvent event) {



    }

    @FXML
    void BTNPrimaryOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNPrimaryOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNSecondaryOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNSecondaryOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNSecondaryOnMouseExited(MouseEvent event) {

    }

    @FXML
    void SPChangePasswordOnMouseClicked(MouseEvent event) {

        passwordVisible = !passwordVisible;
        StyleBuilder.togglePasswordAndVisibility(

                PSFChangePassword, TXTChangePassword,
                IMGChangePassword, IMGChangePasswordHover,
                FileConstants.eyeThirdDm, FileConstants.eyeThirdHoverDm,
                FileConstants.eyeThirdLm, FileConstants.eyeThirdHoverLm,
                FileConstants.eyeSlashThirdDm, FileConstants.eyeSlashThirdHoverDm,
                FileConstants.eyeSlashThirdLm, FileConstants.eyeSlashThirdHoverLm,
                passwordVisible, isDarkMode

        );

    }

    @FXML
    void SPChangePasswordOnMouseEntered(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGChangePassword, IMGChangePasswordHover);

        StyleBuilder.animateStackPaneBackground(

                SPChangePasswordButton,
                hideButtonBackground, hideButtonBackgroundHover,
                hideButtonBorder, hideButtonBorderHover

        );

    }

    @FXML
    void SPChangePasswordOnMouseExited(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGChangePasswordHover, IMGChangePassword);

        StyleBuilder.animateStackPaneBackground(

                SPChangePasswordButton,
                hideButtonBackgroundHover, hideButtonBackground,
                hideButtonBorderHover, hideButtonBorder

        );

    }

    @FXML
    void SPConfirmChangePasswordOnMouseClicked(MouseEvent event) {

                confirmPasswordVisible = !confirmPasswordVisible;
                StyleBuilder.togglePasswordAndVisibility(

                PSFConfirmChangePassword, TXTConfirmChangePassword,
                IMGConfirmChangePassword, IMGConfirmChangePasswordHover,
                FileConstants.eyeThirdDm, FileConstants.eyeThirdHoverDm,
                FileConstants.eyeThirdLm, FileConstants.eyeThirdHoverLm,
                FileConstants.eyeSlashThirdDm, FileConstants.eyeSlashThirdHoverDm,
                FileConstants.eyeSlashThirdLm, FileConstants.eyeSlashThirdHoverLm,
                confirmPasswordVisible, isDarkMode

        );

    }

    @FXML
    void SPConfirmChangePasswordOnMouseEntered(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGConfirmChangePassword, IMGConfirmChangePasswordHover);

        StyleBuilder.animateStackPaneBackground(

                SPConfirmChangePasswordButton,
                hideButtonBackground, hideButtonBackgroundHover,
                hideButtonBorder, hideButtonBorderHover

        );

    }

    @FXML
    void SPConfirmChangePasswordOnMouseExited(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGConfirmChangePasswordHover, IMGConfirmChangePassword);

        StyleBuilder.animateStackPaneBackground(

                SPConfirmChangePasswordButton,
                hideButtonBackgroundHover, hideButtonBackground,
                hideButtonBorderHover, hideButtonBorder

        );

    }

    private void changeSelection(){

        currentStep = Step.First;

        if(currentMode == Mode.EmailMode){

            BTNEmailMethod.pseudoClassStateChanged(methodButton, true);
            BTNCodeMethod.pseudoClassStateChanged(methodButton, false);

        }else{

            BTNEmailMethod.pseudoClassStateChanged(methodButton, false);
            BTNCodeMethod.pseudoClassStateChanged(methodButton, true);

        }

    }

}
