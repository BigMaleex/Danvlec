package controllers;

import connections.SecurityCodes;
import connections.SendEmail;
import connections.Users;
import controls.SerialTextField;
import jakarta.mail.MessagingException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import logical.ValidateFormInputs;
import logical.ValidateOutputs;
import messagebuilder.Complements;
import messagebuilder.MessageBuilder;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserData;
import user.UserPreferences;
import utilities.Colors;
import utilities.EnvironmentVariables;
import utilities.FileConstants;
import utilities.Styles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private boolean isDarkMode = false, passwordVisible = false, confirmPasswordVisible = false, allConditionsMet = false, theUserCanForwardTheEmail=true;
    private Step currentStep;
    private Mode currentMode;
    private static String code;

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

    //Label Email
    private static String emailFoundContent;
    private static String emailFoundHeader;

    //Toast notification
    private static String toastNotificationFontColor;

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
    private TextField TXTEmailOfTheCodeMethod;

    @FXML
    private HBox HBXToast;

    @FXML
    private StackPane SPToast;

    @FXML
    private TextFlow TFLToast;

    @FXML
    void initialize(){

        isDarkMode = UserPreferences.getUserThemeMode();

        if(!SPCodeOfTheCodeMethod.getChildren().contains(TXT24Chars)){

            SPCodeOfTheCodeMethod.getChildren().add(TXT24Chars);
            TXT24Chars.setPromptText("Escribe tu código de seguridad aquí");

        }

        HBXToast.setMouseTransparent(true);

        //Ligar Managed con visibility
        SPCode.managedProperty().bind(SPCode.visibleProperty());
        SPEmail.managedProperty().bind(SPEmail.visibleProperty());
        SPMethodSelector.managedProperty().bind(SPMethodSelector.visibleProperty());
        SPChangePassword.managedProperty().bind(SPChangePassword.visibleProperty());
        TXT24Chars.managedProperty().bind(TXT24Chars.visibleProperty());
        BTNSecondary.managedProperty().bind(BTNSecondary.visibleProperty());
        SPEmailFound.managedProperty().bind(SPEmailFound.visibleProperty());
        HBXCodeEmailMethod.managedProperty().bind(HBXCodeEmailMethod.visibleProperty());
        TXTEmailOfTheEmailMethod.managedProperty().bind(TXTEmailOfTheEmailMethod.visibleProperty());
        SPCodeNotWorkAdvice.managedProperty().bind(SPCodeNotWorkAdvice.visibleProperty());
        TXTEmailOfTheCodeMethod.managedProperty().bind(TXTEmailOfTheCodeMethod.visibleProperty());

        //Agregar listeners
        javafx.beans.value.ChangeListener<String> validatorListener = (obs, oldVal, newVal) -> {validateConditions();};
        TextInputControl [] listenerNodes = {TXTChangePassword, TXT24Chars, TXTConfirmChangePassword, TXTEmailOfTheEmailMethod, TXTEmailOfTheCodeMethod, PSFChangePassword, PSFConfirmChangePassword};

        for(TextInputControl node : listenerNodes){

            node.textProperty().addListener(validatorListener);

        }

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

        configureCodeFields();

        validateConditions();

        changeStylesToSecondaryButton();

        code = ValidateOutputs.generateCodeWithDynamicSize(6);


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

        //Email found
        emailFoundContent = Colors.getColor("email-found-content", isDarkMode);
        emailFoundHeader = Colors.getColor("email-found-header", isDarkMode);

        //Toast Notifications
        toastNotificationFontColor = Colors.getColor("toast-notification-font-color", isDarkMode);

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

            validateConditions();

        }

    }

    @FXML
    void BTNEmailMethodOnMouseClicked(MouseEvent event) {

        if(currentMode != Mode.EmailMode){

            currentMode = Mode.EmailMode;

            changeSelection();

            validateConditions();

        }

    }

    @FXML
    void BTNPrimaryOnMouseClicked(MouseEvent event) {

        if(allConditionsMet) {

            switch(currentStep) {

                case First ->{

                    if(ValidateFormInputs.validateInputsFromPopupRecoveryAccount(1, currentMode == Mode.EmailMode, new String [] {currentMode == Mode.EmailMode ? StyleBuilder.clearStringFormat(TXTEmailOfTheEmailMethod.getText()) : StyleBuilder.clearStringFormat(TXTEmailOfTheCodeMethod.getText())})){

                        //El correo electrónico si existe
                        currentStep = Step.Second;
                        changeStep();

                    }else{

                        //El correo electrónico no existe
                        MessageBuilder.showErrorMessageFromPopupRecoveryAccountFirstStep();

                    }

                }

                case Second -> {

                    if(ValidateFormInputs.validateInputsFromPopupRecoveryAccount(2, currentMode == Mode.EmailMode, currentMode == Mode.EmailMode ? new String [] {(TXTCode1EmailMethod.getText() + TXTCode2EmailMethod.getText() + TXTCode3EmailMethod.getText() + TXTCode4EmailMethod.getText() + TXTCode5EmailMethod.getText() + TXTCode6EmailMethod.getText()), code} : new String [] {TXT24Chars.getText()} )){

                        //El código es igual
                        currentStep = Step.Third;
                        changeStep();

                    }else{

                        MessageBuilder.showErrorMessageFromPopupRecoveryAccountSecondStep(currentMode == Mode.EmailMode);

                    }

                }

                case Third -> {

                    if(ValidateFormInputs.validateInputsFromPopupRecoveryAccount(3, currentMode == Mode.EmailMode, new String[] {passwordVisible ? TXTChangePassword.getText() : PSFChangePassword.getText(), confirmPasswordVisible ? TXTConfirmChangePassword.getText() : PSFConfirmChangePassword.getText(), TXT24Chars.getText()})){

                        //Las contraseñas coinciden

                        UserData.logout();

                        MessageBuilder.showConfirmMessageFromPopupRecoveryAccountThirdStep();

                        BTNCloseOnMouseClicked(event);

                    }else{

                        MessageBuilder.showErrorMessageFromPopupRecoveryAccountThirdStep();

                    }

                }

            }

        }

    }

    @FXML
    void BTNPrimaryOnMouseEntered(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    principalButtonBackground, principalButtonBackgroundHover,
                    principalButtonBorder, principalButtonBorderHover,
                    principalButtonFontColor, principalButtonFontColorHover,
                    BTNPrimary,
                    IMGButtonPrimary, IMGButtonPrimaryHover,
                    LBLButtonPrimary

            );

        }

    }

    @FXML
    void BTNPrimaryOnMouseExited(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    principalButtonBackgroundHover, principalButtonBackground,
                    principalButtonBorderHover, principalButtonBorder,
                    principalButtonFontColorHover, principalButtonFontColor,
                    BTNPrimary,
                    IMGButtonPrimaryHover, IMGButtonPrimary,
                    LBLButtonPrimary

            );

        }

    }

    @FXML
    void BTNSecondaryOnMouseClicked(MouseEvent event) {

        if(theUserCanForwardTheEmail){

            theUserForwardedTheEmail();

        }

    }

    @FXML
    void BTNSecondaryOnMouseEntered(MouseEvent event) {

        if(theUserCanForwardTheEmail){

             StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    secondaryButtonBackground, secondaryButtonBackgroundHover,
                    secondaryButtonBorder, secondaryButtonBorderHover,
                    secondaryButtonFontColor, secondaryButtonFontColorHover,
                    BTNSecondary,
                    IMGButtonSecondary, IMGButtonSecondaryHover,
                    LBLButtonSecondary

            );

        }

    }

    @FXML
    void BTNSecondaryOnMouseExited(MouseEvent event) {

        if(theUserCanForwardTheEmail){

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    secondaryButtonBackgroundHover, secondaryButtonBackground,
                    secondaryButtonBorderHover, secondaryButtonBorder,
                    secondaryButtonFontColorHover, secondaryButtonFontColor,
                    BTNSecondary,
                    IMGButtonSecondaryHover, IMGButtonSecondary,
                    LBLButtonSecondary

            );

        }

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

            SPEmail.setVisible(true);
            SPCode.setVisible(false);
            SPChangePassword.setVisible(false);

        }else{

            BTNEmailMethod.pseudoClassStateChanged(methodButton, false);
            BTNCodeMethod.pseudoClassStateChanged(methodButton, true);

            SPEmail.setVisible(false);
            SPCode.setVisible(true);
            SPChangePassword.setVisible(false);

        }

        changeStep();
        validateConditions();

    }

    private void changeStep(){

        validateConditions();

        BTNSecondary.setVisible(false);

        switch(currentStep){

            case First ->{

                switch(currentMode){

                    case EmailMode ->{

                        SPEmailFound.setVisible(false);
                        HBXCodeEmailMethod.setVisible(false);

                        StyleBuilder.clearControls(TXTEmailOfTheEmailMethod);

                        LBLButtonPrimary.setText("Verificar correo electrónico");
                        LBLEmailMethodDescription.setText("Correo electrónico");
                        setImages(FileConstants.atIconDm, FileConstants.atIconLm, isDarkMode, IMGEmailMethodDescription);
                        setImages(FileConstants.envelopeAtPrimaryDm, FileConstants.envelopeAtPrimaryLm, isDarkMode, IMGButtonPrimary);
                        setImages(FileConstants.envelopeAtPrimaryHoverDm, FileConstants.envelopeAtPrimaryHoverLm, isDarkMode, IMGButtonPrimaryHover);
                        TXTEmailOfTheEmailMethod.setVisible(true);

                    }

                    case CodeMode ->{

                        TXT24Chars.setVisible(false);
                        SPCodeNotWorkAdvice.setVisible(false);
                        LBLButtonPrimary.setText("Verificar correo electrónico");
                        setImages(FileConstants.atIconDm, FileConstants.atIconLm, isDarkMode, IMGCodeDescription);
                        setImages(FileConstants.envelopeAtPrimaryDm, FileConstants.envelopeAtPrimaryLm, isDarkMode, IMGButtonPrimary);
                        setImages(FileConstants.envelopeAtPrimaryHoverDm, FileConstants.envelopeAtPrimaryHoverLm, isDarkMode, IMGButtonPrimaryHover);

                        TXTEmailOfTheCodeMethod.setVisible(true);

                        StyleBuilder.clearControls(TXTEmailOfTheCodeMethod);

                        LBLCodeDescription.setText("Correo electrónico");

                    }

                }

            }

            case Second -> {

                Users users = new Users();

                users.getNameAndNickname();

                switch(currentMode){

                    case EmailMode -> {

                        TXTEmailOfTheEmailMethod.setVisible(false);
                        BTNSecondary.setVisible(true);
                        HBXCodeEmailMethod.setVisible(true);

                        StyleBuilder.clearControls(TXTCode1EmailMethod, TXTCode2EmailMethod, TXTCode3EmailMethod, TXTCode4EmailMethod, TXTCode5EmailMethod, TXTCode6EmailMethod);

                        setImages(FileConstants.shieldIconDm, FileConstants.shieldIconLm, isDarkMode, IMGEmailMethodDescription);
                        setImages(FileConstants.shieldPrimaryDm, FileConstants.shieldPrimaryLm, isDarkMode, IMGButtonPrimary);
                        setImages(FileConstants.shieldPrimaryHoverDm, FileConstants.shieldPrimaryHoverLm, isDarkMode, IMGButtonPrimaryHover);

                        LBLEmailMethodDescription.setText("Código de seguridad");

                        LBLButtonPrimary.setText("Verificar código");

                        buildTFL();

                        SPEmailFound.setVisible(true);

                        sendEmail();
                    }

                    case CodeMode -> {

                        StyleBuilder.clearControls(TXT24Chars);


                        TXT24Chars.setVisible(true);
                        SPCodeNotWorkAdvice.setVisible(true);
                        LBLButtonPrimary.setText("Verificar código de seguridad");
                        setImages(FileConstants.shieldIconDm, FileConstants.shieldIconLm, isDarkMode, IMGCodeDescription);
                        setImages(FileConstants.shieldPrimaryDm, FileConstants.shieldPrimaryLm, isDarkMode, IMGButtonPrimary);
                        setImages(FileConstants.shieldPrimaryHoverDm, FileConstants.shieldPrimaryHoverLm, isDarkMode, IMGButtonPrimaryHover);

                        TXTEmailOfTheCodeMethod.setVisible(false);

                        LBLCodeDescription.setText("Código de seguridad");

                    }

                }

            }

            case Third -> {

                SPCode.setVisible(false);
                SPEmail.setVisible(false);
                SPChangePassword.setVisible(true);

                LBLButtonPrimary.setText("Cambiar contraseña");

                setImages(FileConstants.keyPrimaryDm, FileConstants.keyPrimaryLm, isDarkMode, IMGButtonPrimary);
                setImages(FileConstants.keyPrimaryHoverDm, FileConstants.keyPrimaryHoverLm, isDarkMode, IMGButtonPrimaryHover);

            }

        }

    }

    private void validateConditions(){

        switch(currentStep){

            case First ->{

                switch(currentMode){

                    case EmailMode -> {

                        allConditionsMet = !TXTEmailOfTheEmailMethod.getText().isBlank();

                    }

                    case CodeMode ->{

                        allConditionsMet = !TXTEmailOfTheCodeMethod.getText().isBlank();

                    }

                }

            }

            case Second -> {

                switch(currentMode){

                    case EmailMode -> {

                        allConditionsMet = !TXTCode1EmailMethod.getText().isBlank() && !TXTCode2EmailMethod.getText().isBlank() && !TXTCode3EmailMethod.getText().isBlank() && !TXTCode4EmailMethod.getText().isBlank() && !TXTCode5EmailMethod.getText().isBlank() && !TXTCode6EmailMethod.getText().isBlank();

                    }

                    case CodeMode -> {

                        allConditionsMet = !TXT24Chars.getText().isBlank();

                    }

                }

            }

            case Third -> {

                allConditionsMet = (passwordVisible ? !TXTChangePassword.getText().isBlank() : !PSFChangePassword.getText().isBlank()) && (confirmPasswordVisible ? !TXTConfirmChangePassword.getText().isBlank() : !PSFConfirmChangePassword.getText().isBlank());

            }

        }

        if(allConditionsMet){

            applyStylesToButtonsWithLabel(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase[] {BTNPrimary}, new Label [] {LBLButtonPrimary});
            BTNPrimary.setOpacity(1.0);
            LBLButtonPrimary.setOpacity(1.0);
            IMGButtonPrimary.setOpacity(1.0);

        }else{

            applyStylesToButtonsWithLabel(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, new ButtonBase[] {BTNPrimary}, new Label [] {LBLButtonPrimary});
            BTNPrimary.setOpacity(0.66);
            LBLButtonPrimary.setOpacity(0.66);
            IMGButtonPrimary.setOpacity(0.0);

        }

    }

    private void buildTFL(){

        List<Text> texts = new ArrayList<>();

        texts.add(Complements.addStringFromTextList("Hemos enviado un correo con el código de verificación a la dirección ", Styles.px12, emailFoundContent));
        texts.add(Complements.addStringFromTextList(UserData.getEmail(), Styles.px12, emailFoundHeader));

        TFLEmailFound.getChildren().clear();
        TFLEmailFound.getChildren().addAll(texts);

    }

    private void theUserForwardedTheEmail() {

        theUserCanForwardTheEmail = false;

        BTNSecondary.setDisable(true);

        changeStylesToSecondaryButton();

        final int[] secondsRemaining = {60};

        code = ValidateOutputs.generateCodeWithDynamicSize(6);
        sendEmail();

        LBLButtonSecondary.setText("Puedes reenviar un nuevo código dentro de " + secondsRemaining[0] + "s");


        Timeline timeline = new Timeline();


        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), e -> {
            secondsRemaining[0]--;

            if (secondsRemaining[0] > 0) {
                LBLButtonSecondary.setText("Puedes reenviar un nuevo código dentro de " + secondsRemaining[0] + "s");
            } else {
                theUserCanForwardTheEmail = true;

                 changeStylesToSecondaryButton();

                BTNSecondary.setDisable(false);

                timeline.stop();
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(secondsRemaining[0]);
        timeline.play();

    }

     private void configureCodeFields() {
        TextField[] codeFields = new TextField[]{TXTCode1EmailMethod, TXTCode2EmailMethod, TXTCode3EmailMethod, TXTCode4EmailMethod, TXTCode5EmailMethod, TXTCode6EmailMethod};


        final boolean[] isUpdating = new boolean[] { false };

        for (int i = 0; i < codeFields.length; i++) {
            final int index = i;
            TextField tf = codeFields[i];


            tf.setFocusTraversable(true);


            tf.textProperty().addListener((obs, oldVal, newVal) -> {
                if (isUpdating[0]) return;
                if (newVal == null) return;


                String trimmed = newVal.replaceAll("\\s", "");


                if (trimmed.length() > 1) {
                    isUpdating[0] = true;
                    try {
                        handlePasteToFields(trimmed, index, codeFields);
                    } finally {
                        isUpdating[0] = false;
                    }

                    validateConditions();
                    return;
                }


                if (trimmed.length() == 1) {
                    isUpdating[0] = true;
                    try {

                        tf.setText(trimmed.substring(0, 1));

                        if (index + 1 < codeFields.length) {
                            final TextField next = codeFields[index + 1];
                            Platform.runLater(() -> {
                                next.requestFocus();
                                next.positionCaret(next.getText().length());
                            });
                        } else {

                            Platform.runLater(() -> tf.positionCaret(1));
                        }
                    } finally {
                        isUpdating[0] = false;
                    }
                } else if (trimmed.isEmpty()) {

                }

                validateConditions();
            });


            tf.setOnKeyPressed(keyEvent -> {
                switch (keyEvent.getCode()) {
                    case BACK_SPACE -> {

                        if (tf.getText().isEmpty() && index - 1 >= 0) {
                            TextField prev = codeFields[index - 1];
                            isUpdating[0] = true;
                            try {
                                prev.clear();
                            } finally {
                                isUpdating[0] = false;
                            }
                            prev.requestFocus();
                            Platform.runLater(() -> prev.positionCaret(prev.getText().length()));
                            keyEvent.consume();
                            validateConditions();
                        } else {

                        }
                    }
                    case LEFT -> {
                        if (index - 1 >= 0) {
                            TextField prev = codeFields[index - 1];
                            prev.requestFocus();
                            prev.positionCaret(prev.getText().length());
                            keyEvent.consume();
                        }
                    }
                    case RIGHT -> {
                        if (index + 1 < codeFields.length) {
                            TextField next = codeFields[index + 1];
                            next.requestFocus();
                            next.positionCaret(next.getText().length());
                            keyEvent.consume();
                        }
                    }
                    default -> { }
                }
            });


            tf.addEventFilter(javafx.scene.input.KeyEvent.KEY_TYPED, e -> {
                if (e.getCharacter().equals(" ")) {
                    e.consume();
                }
            });
        }
    }

    private void handlePasteToFields(String s, int startIndex, TextField[] codeFields) {
        if (s == null || s.isEmpty()) return;

        String text = s.replaceAll("\\s", "");


        if (text.length() >= codeFields.length) {

            text = text.substring(0, codeFields.length);
            for (int k = 0; k < codeFields.length; k++) {
                codeFields[k].setText(String.valueOf(text.charAt(k)));
            }

            int nextIndex = Math.min(codeFields.length - 1, text.length() - 1);
            final TextField toFocus = codeFields[nextIndex];
            Platform.runLater(() -> {
                toFocus.requestFocus();
                toFocus.positionCaret(toFocus.getText().length());
            });
        } else {

            int writeIndex = startIndex;
            for (int j = 0; j < text.length() && writeIndex < codeFields.length; j++, writeIndex++) {
                codeFields[writeIndex].setText(String.valueOf(text.charAt(j)));
            }

            int focusIndex = Math.min(writeIndex, codeFields.length - 1);
            final TextField toFocus = codeFields[focusIndex];
            Platform.runLater(() -> {
                toFocus.requestFocus();
                toFocus.positionCaret(toFocus.getText().length());
            });
        }
    }

    private void sendEmail(){

        System.out.println("code = " + code);
        System.out.println("nickname = " + UserData.getNickname());
        System.out.println("firstname = " + ValidateOutputs.getUserFirstName());
        System.out.println("email = " + UserData.getEmail());

        try {

            Map<String, String> placeholders = Map.of(
                    "title", "Verifica tu identidad",
                    "header", "¿Perdiste el acceso a tu cuenta?",
                    "code",code,
                    "user", UserData.getNickname() == null ? ValidateOutputs.getUserFirstName() : UserData.getNickname(),
                    "message", "Recientemente has solicitado la recuperación del acceso a tu cuenta, necesitamos que verifiques que eres tú. Ingresa este código en tu aplicación móvil o de escritorio.\nEn caso de que no hayas sido tú, puedes hacer caso omiso a este correo."
            );

            String gmailUser = "";
            String appPassword = "";

            try{

                appPassword = ValidateOutputs.decrypt(System.getenv(EnvironmentVariables.aGC56SeknSka5AGVWtvbmR5A2BcYX7zaCtJgnjYKo5EDkjiK49SfufjxpNd88V9c));
                gmailUser = ValidateOutputs.decrypt(System.getenv(EnvironmentVariables.d5XbHGPL9tbcf8L3sUuSUAxHhqKkJeTfqaTrSQ8bTFWSXmBSNyT9DmTmWVupbvsN));

            }catch(Exception e){

                e.printStackTrace();

            }

            SendEmail mailer = new SendEmail(gmailUser, appPassword);

            mailer.sendTemplateEmail(
                    UserData.getEmail(),
                    "CÓDIGO DE VERIFICACIÓN | DANVLEC",
                    FileConstants.verificateEmailTemplate,
                    placeholders
            );

            MessageBuilder.addToastNotification(TFLToast, "¡Código enviado con éxito a " + ValidateOutputs.getEmailHide() + "!", toastNotificationFontColor);


        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            MessageBuilder.addToastNotification(TFLToast, "¡Tuvimos un problema al reenviar tu correo!", toastNotificationFontColor);

        }

        StyleBuilder.showAndHideToastNotification(SPToast, false);

    }

    private void changeStylesToSecondaryButton(){

        setImages(FileConstants.sendSecondaryDm, FileConstants.sendSecondaryLm, isDarkMode, IMGButtonSecondary);
        setImages(FileConstants.sendSecondaryHoverDm, FileConstants.sendSecondaryHoverLm, isDarkMode, IMGButtonSecondaryHover);

        if(theUserCanForwardTheEmail){

            IMGButtonSecondary.setOpacity(1);
            IMGButtonSecondaryHover.setOpacity(0);

            BTNSecondary.setOpacity(1);

            applyStylesToButtonsWithLabel(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNSecondary}, new Label [] {LBLButtonSecondary});

            LBLButtonSecondary.setText("Reenviar código");

        }else{

            IMGButtonSecondary.setOpacity(0);
            IMGButtonSecondaryHover.setOpacity(1);

            BTNSecondary.setOpacity(0.66);

            applyStylesToButtonsWithLabel(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNSecondary}, new Label [] {LBLButtonSecondary});

        }

    }

}
