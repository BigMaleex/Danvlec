package controllers;

import controls.SerialTextField;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;

public class PopupRecoveryAccountController {

    //Enum del paso
    public enum Selection {

        EmailMode, CodeMode

    }

    public enum Step {

        First, Second, Third

    }

    //Variables
    private boolean isDarkMode, passwordVisible = false, confirmPasswordVisible = false;
    private Selection selection;
    private Step currentStep;


    @FXML
    private AnchorPane APMain;

    @FXML
    private Button BTNClose;

    @FXML
    private Button BTNPrimary;

    @FXML
    private Button BTNSecondary;

    @FXML
    private HBox HBXEmailCode;

    @FXML
    private ImageView IMGAspectEmail;

    @FXML
    private ImageView IMGButtonPrimary;

    @FXML
    private ImageView IMGButtonPrimaryHover;

    @FXML
    private ImageView IMGButtonSecondary;

    @FXML
    private ImageView IMGButtonSecondaryHover;

    @FXML
    private ImageView IMGChangePassword;

    @FXML
    private ImageView IMGChangePasswordConfirm;

    @FXML
    private ImageView IMGCodeButton;

    @FXML
    private ImageView IMGConfirmPassword;

    @FXML
    private ImageView IMGConfirmPasswordHover;

    @FXML
    private ImageView IMGEmailButton;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private ImageView IMGPassword;

    @FXML
    private ImageView IMGPasswordHover;

    @FXML
    private ImageView IMGCodeAspect;

    @FXML
    private Label LBLButtonPrimary;

    @FXML
    private Label LBLButtonSecondary;

    @FXML
    private Label LBLCodeDescription;

    @FXML
    private Label LBLDescriptionEmail;

    @FXML
    private StackPane SPChangePassword;

    @FXML
    private StackPane SPCode;

    @FXML
    private StackPane SPCodeButton;

    @FXML
    private StackPane SPEmail;

    @FXML
    private StackPane SPEmailButton;

    @FXML
    private StackPane SPEmailFind;

    @FXML
    private StackPane SPFooterBar;
    
    @FXML
    private StackPane SPModeSelector;

    @FXML
    private StackPane SPTitleBar;

    @FXML
    private TextFlow TFLEmailFounded;

    @FXML
    private TextField TXTCodeSectionEmail;

    @FXML
    private TextField TXTEmail;

    @FXML
    private TextField TXTEmailCode1;

    @FXML
    private TextField TXTEmailCode2;

    @FXML
    private TextField TXTEmailCode3;

    @FXML
    private TextField TXTEmailCode4;

    @FXML
    private TextField TXTEmailCode5;

    @FXML
    private TextField TXTEmailCode6;

    @FXML
    private VBox VBXCodeSelector;

    @FXML
    private VBox VBXMain;

    private SerialTextField TXT24Chars = new SerialTextField(24);
    private final PseudoClass selectionButtonActive = PseudoClass.getPseudoClass("active");

    @FXML
    public void initialize(){

        TXT24Chars.setPromptText("Escribe el código de seguridad de tu cuenta aquí");

        SPCode.managedProperty().bind(SPCode.visibleProperty());
        SPEmail.managedProperty().bind(SPEmail.visibleProperty());
        SPChangePassword.managedProperty().bind(SPChangePassword.visibleProperty());
        TXT24Chars.managedProperty().bind(TXT24Chars.visibleProperty());

        currentStep = Step.First;
        selection = Selection.EmailMode;

        if(!VBXCodeSelector.getChildren().contains(TXT24Chars)) {

            VBXCodeSelector.getChildren().add(TXT24Chars);

        }

        isDarkMode = UserPreferences.getUserThemeMode();

        changeSelection();

        selectStepAndInitialize();

        changeTheme();

    }

    private void changeTheme(){

        StyleBuilder.setAnchorPaneClass(APMain);

        ConfigureNodes.configureNodesForPopupRecoveryAccount(BTNClose, BTNPrimary, BTNSecondary, IMGChangePassword, IMGChangePasswordConfirm, IMGCodeButton, IMGConfirmPassword, IMGConfirmPasswordHover, IMGEmailButton, IMGIcon, IMGPassword, IMGPasswordHover, LBLButtonPrimary, LBLButtonSecondary, isDarkMode, passwordVisible, confirmPasswordVisible, selection);

        changeColor();

    }

    private void changeColor(){



    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage) BTNClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {



    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {



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
    void IMGConfirmPasswordOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void IMGConfirmPasswordOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void IMGConfirmPasswordOnMouseExited(MouseEvent event) {

    }

    @FXML
    void IMGPasswordOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void IMGPasswordOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void IMGPasswordOnMouseExited(MouseEvent event) {

    }

    @FXML
    void SPCodeButtonOnMouseClicked(MouseEvent event) {

        selection = Selection.CodeMode;
        changeSelection();

    }

    @FXML
    void SPEmailButtonOnMouseClicked(MouseEvent event) {

        selection = Selection.EmailMode;
        changeSelection();

    }

    private void changeSelection(){

        if(selection == Selection.EmailMode){

            SPEmailButton.pseudoClassStateChanged(selectionButtonActive, true);
            SPCodeButton.pseudoClassStateChanged(selectionButtonActive, false);

            SPCode.setVisible(false);
            SPCode.setManaged(false);
            SPEmail.setVisible(true);
            SPEmail.setManaged(true);

        }else{

            SPEmailButton.pseudoClassStateChanged(selectionButtonActive, false);
            SPCodeButton.pseudoClassStateChanged(selectionButtonActive, true);

            SPCode.setVisible(true);
            SPCode.setManaged(true);
            SPEmail.setVisible(false);
            SPEmail.setManaged(false);

        }

    }

    private void selectStepAndInitialize(){

        switch(selection){

            case EmailMode->{



            }
            case CodeMode ->{



            }

        }

    }

}
