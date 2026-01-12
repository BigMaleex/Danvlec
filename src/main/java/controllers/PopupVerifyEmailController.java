package controllers;

import connections.SendEmail;
import connections.Users;
import jakarta.mail.MessagingException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import logical.ValidateOutputs;
import messagebuilder.MessageBuilder;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserData;
import user.UserPreferences;
import utilities.Colors;
import utilities.FileConstants;
import utilities.Styles;

import java.io.IOException;
import java.util.Map;

public class PopupVerifyEmailController extends ConfigureInitializeStyles {

    //Variables
    private boolean isDarkMode;
    private long daysThatHavePassed;
    private boolean allConditionsMet;
    private boolean theUserCanForwardTheEmail;
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

    //Botón oculto
    private static String hideButtonBackground;
    private static String hideButtonBorder;
    private static String hideButtonFontColor;

    private static String hideButtonBackgroundHover;
    private static String hideButtonBorderHover;
    private static String hideButtonFontColorHover;

    //Botón desactivado
    private static String buttonBackgroundDisabled;
    private static String buttonBorderDisabled;
    private static String buttonFontColorDisabled;

    //Toast notification
    private static String toastNotificationFontColor;

    @FXML
    private HBox HBToast;

    @FXML
    private AnchorPane APMain;

    @FXML
    private AnchorPane APResendEmail;

    @FXML
    private Button BTNClose;

    @FXML
    private Button BTNVerifyEmail;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private ImageView IMGResendEmail;

    @FXML
    private ImageView IMGResendEmailHover;

    @FXML
    private ImageView IMGTimeRemaining;

    @FXML
    private Label LBLResendEmail;

    @FXML
    private Label LBLTimeRemainingDays;

    @FXML
    private Label LBLTimeRemainingTitle;

    @FXML
    private ScrollPane SPMain;

    @FXML
    private StackPane SPTimeRemaining;

    @FXML
    private StackPane SPToast;

    @FXML
    private TextFlow TFLShowMessageAndEmail;

    @FXML
    private TextFlow TFLTimeRemainingContent;

    @FXML
    private TextFlow TFLToast;

    @FXML
    private TextField TXT1;

    @FXML
    private TextField TXT10;

    @FXML
    private TextField TXT2;

    @FXML
    private TextField TXT3;

    @FXML
    private TextField TXT4;

    @FXML
    private TextField TXT5;

    @FXML
    private TextField TXT6;

    @FXML
    private TextField TXT7;

    @FXML
    private TextField TXT8;

    @FXML
    private TextField TXT9;

    @FXML
    private VBox VBTimeRemaining;

    @FXML
    public void initialize(){

        isDarkMode = UserPreferences.getUserThemeMode();

        configureCodeFields();

        theUserCanForwardTheEmail = true;

        TFLToast.setLineSpacing(0);
        TFLToast.setPrefWidth(Region.USE_COMPUTED_SIZE);
        TFLToast.setMaxWidth(Double.MAX_VALUE);


        TFLToast.setTextAlignment(TextAlignment.CENTER);

        StyleBuilder.clearControls(TXT1, TXT2, TXT3, TXT4, TXT5,TXT6,TXT7,TXT8,TXT9,TXT10);

        IMGResendEmailHover.setOpacity(0.0);

        HBToast.setMouseTransparent(true);

        buildLabelAndGetDaysThatHavePassed();

        javafx.beans.value.ChangeListener<String> validationListener = (obs, oldVal, newVal) ->{validateFields();};

        TXT1.textProperty().addListener(validationListener);
        TXT2.textProperty().addListener(validationListener);
        TXT3.textProperty().addListener(validationListener);
        TXT4.textProperty().addListener(validationListener);
        TXT5.textProperty().addListener(validationListener);
        TXT6.textProperty().addListener(validationListener);
        TXT7.textProperty().addListener(validationListener);
        TXT8.textProperty().addListener(validationListener);
        TXT9.textProperty().addListener(validationListener);
        TXT10.textProperty().addListener(validationListener);

        SPToast.setOpacity(0.0);

        changeTheme();
/*
        code = ValidateOutputs.generateCode10Chars();
        sendEmail();
*/
    }

    private void changeTheme(){

        changeColors();
        StyleBuilder.setAnchorPaneClass(APMain);

        TFLShowMessageAndEmail.getChildren().clear();
        TFLShowMessageAndEmail.getChildren().addAll(MessageBuilder.buildMessagesAboutEmailFromPopupVerifyEmail(isDarkMode));

        TFLTimeRemainingContent.getChildren().clear();
        TFLTimeRemainingContent.getChildren().addAll(MessageBuilder.buildMessagesAboutTimeRemainingFromPopupVerifyEmail(daysThatHavePassed, isDarkMode));

        ConfigureNodes.configureNodesForPopupVerifyEmailController(APResendEmail, BTNClose, BTNVerifyEmail, IMGIcon, IMGResendEmail, IMGResendEmailHover, IMGTimeRemaining, LBLResendEmail, LBLTimeRemainingDays, LBLTimeRemainingTitle, SPTimeRemaining, SPToast, isDarkMode, allConditionsMet, theUserCanForwardTheEmail, daysThatHavePassed);

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

        //Botón oculto
        hideButtonBackground = Colors.getColor("hide-button-background", isDarkMode);
        hideButtonBorder = Colors.getColor("hide-button-border", isDarkMode);
        hideButtonFontColor = Colors.getColor("hide-button-font-color", isDarkMode);

        hideButtonBackgroundHover = Colors.getColor("hide-button-background-hover", isDarkMode);
        hideButtonBorderHover = Colors.getColor("hide-button-border-hover", isDarkMode);
        hideButtonFontColorHover  = Colors.getColor("hide-button-font-color-hover", isDarkMode);

        //Toast Notifications
        toastNotificationFontColor = Colors.getColor("toast-notification-font-color", isDarkMode);

    }

    private void buildLabelAndGetDaysThatHavePassed(){

        Users users = new Users();

        daysThatHavePassed = users.getDaysThatHavePassed();

        String titleMessage = null;

        if(daysThatHavePassed >= 0 && daysThatHavePassed < 6){

            titleMessage = "Verificación pendiente";

        }
        else if(daysThatHavePassed >=6 &&  daysThatHavePassed < 10){

            titleMessage = "Verificación requerida pronto";

        }else if(daysThatHavePassed >= 10 && daysThatHavePassed < 15){

            titleMessage = "Verificación requerida urgentemente";

        }else if(daysThatHavePassed == 15){

            titleMessage = "URGENTE: CUENTA EN RIESGO";

        }

        LBLTimeRemainingTitle.setText(titleMessage);
        LBLTimeRemainingDays.setText(15 - daysThatHavePassed <= 0 ? "Último día" : ((15 - daysThatHavePassed) + ((15 - daysThatHavePassed) == 1 ? " día" : " días")));

    }

    @FXML
    void APResendEmailOnMouseClicked(MouseEvent event) {

        if(theUserCanForwardTheEmail){

            theUserForwardedTheEmail();

        }

    }

    @FXML
    void APResendEmailOnMouseEntered(MouseEvent event) {

        if(theUserCanForwardTheEmail){

            StyleBuilder.animateAnchorPaneBackground(

                    APResendEmail,
                    secondaryButtonBackground, secondaryButtonBackgroundHover,
                    secondaryButtonBorder, secondaryButtonBorderHover

            );

            StyleBuilder.animateLabelTextColor(

                    LBLResendEmail,
                    secondaryButtonFontColor, secondaryButtonFontColorHover

            );

            StyleBuilder.fadeAndChangeImage(IMGResendEmail, IMGResendEmailHover);

        }

    }

    @FXML
    void APResendEmailOnMouseExited(MouseEvent event) {

        if(theUserCanForwardTheEmail){

            StyleBuilder.animateAnchorPaneBackground(

                    APResendEmail,
                    secondaryButtonBackgroundHover, secondaryButtonBackground,
                    secondaryButtonBorderHover, secondaryButtonBorder

                    );

            StyleBuilder.animateLabelTextColor(

                    LBLResendEmail,
                    secondaryButtonFontColorHover, secondaryButtonFontColor

                    );

            StyleBuilder.fadeAndChangeImage(IMGResendEmailHover, IMGResendEmail);

        }

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage)BTNClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNClose,
                hideButtonBackground, hideButtonBackgroundHover,
                hideButtonBorder, hideButtonBorderHover,
                hideButtonFontColor, hideButtonFontColorHover

        );

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNClose,
                hideButtonBackgroundHover, hideButtonBackground,
                hideButtonBorderHover, hideButtonBorder,
                hideButtonFontColorHover, hideButtonFontColor

                );

    }

    @FXML
    void BTNVerifyEmailOnMouseClicked(MouseEvent event) {

        if(allConditionsMet){

            String userCode = TXT1.getText().trim() + TXT2.getText().trim()  + TXT3.getText().trim()  + TXT4.getText().trim()  + TXT5.getText().trim()  + TXT6.getText().trim()  + TXT7.getText().trim() + TXT8.getText().trim()  + TXT9.getText().trim()  + TXT10.getText().trim();

            boolean isTheRightCode = userCode.equalsIgnoreCase(code);

            if(isTheRightCode){

                Users users = new Users();

                if(users.toggleEmailStatus()){

                    //Se pudo actualizar
                    MessageBuilder.showConfirmMessageUpdateFromPopupVerifyEmail();

                }else{

                    //No se pudo actualizar
                    MessageBuilder.showErrorMessageUpdateFromPopupVerifyEmail();

                }

                Stage stage = (Stage)BTNClose.getScene().getWindow();
                stage.close();

            }else{

                MessageBuilder.showErrorMessageFromPopupVerifyEmail();

            }

        }

    }

    @FXML
    void BTNVerifyEmailOnMouseEntered(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColors(

                    BTNVerifyEmail,
                    principalButtonBackground, principalButtonBackgroundHover,
                    principalButtonBorder, principalButtonBorderHover,
                    principalButtonFontColor, principalButtonFontColorHover

            );

        }

    }

    @FXML
    void BTNVerifyEmailOnMouseExited(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColors(

                    BTNVerifyEmail,
                    principalButtonBackgroundHover, principalButtonBackground,
                    principalButtonBorderHover, principalButtonBorder,
                    principalButtonFontColorHover,principalButtonFontColor

            );

        }

    }

    private void theUserForwardedTheEmail() {

        theUserCanForwardTheEmail = false;

        IMGResendEmail.setVisible(false);
        IMGResendEmailHover.setVisible(false);

        APResendEmail.setDisable(true);

        ConfigureNodes.configureNodesForPopupVerifyEmailController(APResendEmail, BTNClose, BTNVerifyEmail, IMGIcon, IMGResendEmail, IMGResendEmailHover, IMGTimeRemaining, LBLResendEmail, LBLTimeRemainingDays, LBLTimeRemainingTitle, SPTimeRemaining, SPToast, isDarkMode, allConditionsMet, theUserCanForwardTheEmail, daysThatHavePassed);

        final int[] secondsRemaining = {60};

        code = ValidateOutputs.generateCode10Chars();
        sendEmail();

        LBLResendEmail.setText("Puedes reenviar un nuevo código dentro de " + secondsRemaining[0] + "s");


        Timeline timeline = new Timeline();


        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), e -> {
            secondsRemaining[0]--;

            if (secondsRemaining[0] > 0) {
                LBLResendEmail.setText("Puedes reenviar un nuevo código dentro de " + secondsRemaining[0] + "s");
            } else {
                theUserCanForwardTheEmail = true;

                IMGResendEmail.setVisible(true);
                IMGResendEmailHover.setVisible(true);
                IMGResendEmailHover.setOpacity(0.0);
                IMGResendEmail.setOpacity(1);

                LBLResendEmail.setText("Reenviar código");

                ConfigureNodes.configureNodesForPopupVerifyEmailController(APResendEmail, BTNClose, BTNVerifyEmail, IMGIcon, IMGResendEmail, IMGResendEmailHover, IMGTimeRemaining, LBLResendEmail, LBLTimeRemainingDays, LBLTimeRemainingTitle, SPTimeRemaining, SPToast, isDarkMode, allConditionsMet, theUserCanForwardTheEmail, daysThatHavePassed);

                APResendEmail.setDisable(false);

                timeline.stop();
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(secondsRemaining[0]);
        timeline.play();

    }

    private void validateFields(){

        allConditionsMet = !TXT1.getText().isBlank() && !TXT2.getText().isBlank() && !TXT3.getText().isBlank() && !TXT4.getText().isBlank() && !TXT5.getText().isBlank() && !TXT6.getText().isBlank() && !TXT7.getText().isBlank() && !TXT8.getText().isBlank() && !TXT9.getText().isBlank() && !TXT10.getText().isBlank();

        if(allConditionsMet){

            applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNVerifyEmail);
            BTNVerifyEmail.setOpacity(1.0);

        }else{

            applyStylesToButtons(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, BTNVerifyEmail);
            BTNVerifyEmail.setOpacity(0.66);

        }

    }

    private void configureCodeFields() {
        TextField[] codeFields = new TextField[]{ TXT1, TXT2, TXT3, TXT4, TXT5, TXT6, TXT7, TXT8, TXT9, TXT10 };


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

                    validateFields();
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

                validateFields();
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
                            validateFields();
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

        try {

            Map<String, String> placeholders = Map.of(
                    "title", "Verifica tu correo electrónico",
                    "header", "¡Verifica tu correo electrónico!",
                    "code",code,
                    "user", UserData.getNickname() == null ? ValidateOutputs.getUserFirstName() : UserData.getNickname(),
                    "message", "Recientemente has creado una cuenta en Danvlec, necesitamos que verifiques que eres tú. Ingresa este código en tu aplicación móvil o de escritorio.\nEn caso de que no hayas creado una cuenta con nosotros, puedes hacer caso omiso a este correo."
            );

            String gmailUser = System.getenv("DanvlecEmail");
            String appPassword = System.getenv("DanvlecEmailPassword");

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

}
