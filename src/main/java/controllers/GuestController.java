package controllers;

import controls.DateMaskTextField;
import files.Preferences;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logical.ValidateFormInputs;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserData;
import user.UserPreferences;
import utilities.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.function.UnaryOperator;

public class GuestController extends ConfigureInitializeStyles {

    //Clases
    ScreenManager sm = ScreenManager.getInstance();

    //Variables
    private int xOffset, yOffset;
    private boolean isDarkMode, allConditionsMet;
    UserData.Sex sex;

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

    //Barra de título
    //Sin focus
    private static String titleBarBackgroundWithoutFocus;
    private static String titleBarBorderWithoutFocus;
    private static String titleBarFontColorWithoutFocus;

    //Con focus
    private static String titleBarBackgroundWithFocus;
    private static String titleBarBorderWithFocus;
    private static String titleBarFontColorWithFocus;

    //Botón principal de la barra de título
    //Sin focus
    private static String titleBarButtonBackgroundWithoutFocus;
    private static String titleBarButtonBorderWithoutFocus;
    private static String titleBarButtonFontColorWithoutFocus;

    //Con focus
    private static String titleBarButtonBackgroundWithFocus;
    private static String titleBarButtonBorderWithFocus;
    private static String titleBarButtonFontColorWithFocus;

    //Con hover
    private static String titleBarButtonBackgroundWithFocusHover;
    private static String titleBarButtonBorderWithFocusHover;
    private static String titleBarButtonFontColorWithFocusHover;

    //Botón para cerrar de la barra de título
    //Sin focus
    private static String titleBarCloseButtonBackgroundWithoutFocus;
    private static String titleBarCloseButtonBorderWithoutFocus;
    private static String titleBarCloseButtonFontColorWithoutFocus;

    //Con focus
    private static String titleBarCloseButtonBackgroundWithFocus;
    private static String titleBarCloseButtonBorderWithFocus;
    private static String titleBarCloseButtonFontColorWithFocus;

    //Con hover
    private static String titleBarCloseButtonBackgroundWithFocusHover;
    private static String titleBarCloseButtonBorderWithFocusHover;
    private static String titleBarCloseButtonFontColorWithFocusHover;

    @FXML
    private AnchorPane APMain;

    @FXML
    private AnchorPane APTitleBar;

    @FXML
    private Button BTNBack;

    @FXML
    private Button BTNClose;

    @FXML
    private Button BTNGuest;

    @FXML
    private Button BTNMinimize;

    @FXML
    private ComboBox<String> CBXSex;

    @FXML
    private ImageView IMGBirthday;

    @FXML
    private ImageView IMGExplanation;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private ImageView IMGLastname;

    @FXML
    private ImageView IMGName;

    @FXML
    private ImageView IMGNickname;

    @FXML
    private ImageView IMGTheme;

    @FXML
    private ImageView IMGSex;

    @FXML
    private ImageView IMGThemeHover;

    @FXML
    private ImageView IMGThemeInit;

    @FXML
    private Label LBLLastnameErr;

    @FXML
    private Label LBLNameErr;

    @FXML
    private Label LBLNickname;

    @FXML
    private Label LBLNicknameErr;

    @FXML
    private Label LBLTitleBar;

    @FXML
    private StackPane SPTheme;

    @FXML
    private ToggleButton TBTToggle;

    @FXML
    private TextField TXTHide;

    @FXML
    private TextField TXTLastname;

    @FXML
    private TextField TXTName;

    @FXML
    private TextField TXTNickname;

    @FXML
    private VBox VBXDate;

    private DateMaskTextField TXTBirthday = new DateMaskTextField();
    private Label LBL = new Label();

    @FXML
    public void initialize(){

        IMGSex.setImage(Images.getImage(FileConstants.genderAmbiguousIcon));

        LBL.setStyle("-fx-background-color: transparent");

        TXTBirthday.clear();

        if(!VBXDate.getChildren().contains(TXTBirthday)){

            VBXDate.getChildren().add(TXTBirthday);

        }

        if(!VBXDate.getChildren().contains(LBL)){

            VBXDate.getChildren().add(LBL);

        }

        LBLTitleBar.setText(Titles.Guest);
        StyleBuilder.clearControls(TXTLastname, TXTNickname, TXTName, CBXSex);

        StyleBuilder.normalizeLabels(LBLLastnameErr, LBLNameErr, LBLNicknameErr);

        sex = null;

        TXTHide.setVisible(true);
        TXTHide.setManaged(true);
        IMGThemeHover.setOpacity(0.0);
        IMGTheme.setOpacity(0.0);
        TBTToggle.setText("No");
        TBTToggle.setSelected(false);
        CBXSex.getItems().clear();
        CBXSex.getItems().addAll("Hombre", "Mujer");
        CBXSex.setPromptText("Escoge tu sexo");
        CBXSex.setValue(null);

        TXTName.textProperty().addListener((obs, oldV, newV) -> validateForm());
        TXTLastname.textProperty().addListener((obs, oldV, newV) -> validateForm());
        TXTNickname.textProperty().addListener((obs, oldV, newV) -> validateForm());

        CBXSex.setButtonCell(new javafx.scene.control.ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(CBXSex.getPromptText());
                } else {
                    setText(item);
                }
            }
        });

        javafx.beans.value.ChangeListener<Object> comboListener = (obs, oldVal, newVal) -> validateForm();

        isDarkMode = UserPreferences.getUserThemeMode();
        TXTNickname.setVisible(false);
        TXTNickname.setManaged(false);

        CBXSex.valueProperty().addListener(comboListener);

        CBXSex.setOnAction(e -> {
            String selected = CBXSex.getSelectionModel().getSelectedItem();
            if (selected != null) {
                sex = selected.equalsIgnoreCase("hombre") ? UserData.Sex.MAN : UserData.Sex.WOMAN;
            }
            assignGenderAttribute();
        });

        assignGenderAttribute();
        changeTheme();
        validateForm();

    }

    private void changeTheme(){

        changeColors();

        ConfigureNodes.configureNodesForGuestController(APTitleBar, BTNBack, BTNClose,BTNGuest,BTNMinimize,IMGBirthday,IMGExplanation,IMGIcon,IMGLastname,IMGName,IMGNickname, IMGTheme, IMGThemeHover,IMGThemeInit,LBLTitleBar,SPTheme,TBTToggle,isDarkMode,allConditionsMet);

        StyleBuilder.setAnchorPaneClass(APMain);

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

        //Barra de título
        //Sin focus
        titleBarBackgroundWithoutFocus = Colors.getColor("title-bar-background-without-focus", isDarkMode);
        titleBarBorderWithoutFocus = Colors.getColor("title-bar-border-without-focus", isDarkMode);
        titleBarFontColorWithoutFocus = Colors.getColor("title-bar-font-color-whithout-focus", isDarkMode);

        //Con focus
        titleBarBackgroundWithFocus = Colors.getColor("title-bar-background-with-focus", isDarkMode);
        titleBarBorderWithFocus = Colors.getColor("title-bar-border-with-focus", isDarkMode);
        titleBarFontColorWithFocus = Colors.getColor("title-bar-font-color-whith-focus", isDarkMode);

        //Botón principal de la barra de título
        //Sin focus
        titleBarButtonBackgroundWithoutFocus = Colors.getColor("title-bar-button-background-without-focus", isDarkMode);
        titleBarButtonBorderWithoutFocus = Colors.getColor("title-bar-button-border-without-focus", isDarkMode);
        titleBarButtonFontColorWithoutFocus = Colors.getColor("title-bar-button-font-color-without-focus", isDarkMode);

        //Con focus
        titleBarButtonBackgroundWithFocus = Colors.getColor("title-bar-button-background-with-focus", isDarkMode);
        titleBarButtonBorderWithFocus = Colors.getColor("title-bar-button-border-with-focus", isDarkMode);
        titleBarButtonFontColorWithFocus = Colors.getColor("title-bar-button-font-color-with-focus", isDarkMode);

        //Con hover
        titleBarButtonBackgroundWithFocusHover = Colors.getColor("title-bar-button-background-with-focus-hover", isDarkMode);
        titleBarButtonBorderWithFocusHover = Colors.getColor("title-bar-button-border-with-focus-hover", isDarkMode);
        titleBarButtonFontColorWithFocusHover = Colors.getColor("title-bar-button-font-color-with-focus-hover", isDarkMode);

        //Botón para cerrar de la barra de título
        //Sin focus
        titleBarCloseButtonBackgroundWithoutFocus = Colors.getColor("title-bar-close-button-background-without-focus", isDarkMode);
        titleBarCloseButtonBorderWithoutFocus = Colors.getColor("title-bar-close-button-border-without-focus", isDarkMode);
        titleBarCloseButtonFontColorWithoutFocus = Colors.getColor("title-bar-close-button-font-color-without-focus", isDarkMode);

        //Con focus
        titleBarCloseButtonBackgroundWithFocus = Colors.getColor("title-bar-close-button-background-with-focus", isDarkMode);
        titleBarCloseButtonBorderWithFocus = Colors.getColor("title-bar-close-button-border-with-focus", isDarkMode);
        titleBarCloseButtonFontColorWithFocus = Colors.getColor("title-bar-close-button-font-color-with-focus", isDarkMode);

        //Con hover
        titleBarCloseButtonBackgroundWithFocusHover = Colors.getColor("title-bar-close-button-background-with-focus-hover", isDarkMode);
        titleBarCloseButtonBorderWithFocusHover = Colors.getColor("title-bar-close-button-border-with-focus-hover", isDarkMode);
        titleBarCloseButtonFontColorWithFocusHover = Colors.getColor("title-bar-close-button-font-color-with-focus-hover", isDarkMode);

    }

    private void showOrHideLabel(TextField field, Label label, boolean status) {
        if (status) {
            field.getStyleClass().removeAll("txterr", "err");
            label.getStyleClass().remove("err");
            label.getStyleClass().add("norm");
        } else {
            label.getStyleClass().add("err");
            label.getStyleClass().remove("norm");
            field.getStyleClass().addAll("err", "txterr");
        }
    }

    private void assignGenderAttribute() {
        LBLNickname.setText(sex == null ? "¿Hay alguna manera en especial por la que te gustaría ser llamad@?" : (sex == UserData.Sex.MAN ? "¿Hay alguna manera en especial por la que te gustaría ser llamado?" : "¿Hay alguna manera en especial por la que te gustaría ser llamada?"));
        TXTNickname.setPromptText(sex == null ? "Escribe como te gustaría ser llamad@ aquí" : (sex == UserData.Sex.MAN ? "Escribe como te gustaría ser llamado aquí" : "Escribe como te gustaría ser llamada aquí"));
    }

    @FXML
    void APTitleBarOnMouseDragged(MouseEvent event) {

        Stage stage = (Stage) APTitleBar.getScene().getWindow();

        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);

    }

    @FXML
    void APTitleBarOnMouseEntered(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGThemeInit, IMGTheme);

        StyleBuilder.animateAnchorPaneBackground(

                APTitleBar,
                titleBarBackgroundWithoutFocus, titleBarBackgroundWithFocus,
                titleBarBorderWithoutFocus, titleBarBorderWithFocus

        );

        StyleBuilder.animateLabelTextColor(

                LBLTitleBar,
                titleBarFontColorWithoutFocus, titleBarFontColorWithFocus

        );

        StyleBuilder.animateStackPaneBackground(

                SPTheme,
                titleBarButtonBackgroundWithoutFocus, titleBarButtonBackgroundWithFocus,
                titleBarButtonBorderWithoutFocus, titleBarButtonBorderWithFocus

        );

        StyleBuilder.animateButtonColors(

                BTNMinimize,
                titleBarButtonBackgroundWithoutFocus, titleBarButtonBackgroundWithFocus,
                titleBarButtonBorderWithoutFocus, titleBarButtonBorderWithFocus,
                titleBarButtonFontColorWithoutFocus, titleBarButtonFontColorWithFocus

        );

        StyleBuilder.animateButtonColors(

                BTNClose,
                titleBarCloseButtonBackgroundWithoutFocus, titleBarCloseButtonBackgroundWithFocus,
                titleBarCloseButtonBorderWithoutFocus, titleBarCloseButtonBorderWithFocus,
                titleBarCloseButtonFontColorWithoutFocus, titleBarCloseButtonFontColorWithFocus

        );

    }

    @FXML
    void APTitleBarOnMouseExited(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGTheme,IMGThemeInit);

        StyleBuilder.animateAnchorPaneBackground(

                APTitleBar,
                titleBarBackgroundWithFocus, titleBarBackgroundWithoutFocus,
                titleBarBorderWithFocus, titleBarBorderWithoutFocus

        );

        StyleBuilder.animateLabelTextColor(

                LBLTitleBar,
                titleBarFontColorWithFocus,titleBarFontColorWithoutFocus

        );

        StyleBuilder.animateStackPaneBackground(

                SPTheme,
                titleBarButtonBackgroundWithFocus, titleBarButtonBackgroundWithoutFocus,
                titleBarButtonBorderWithFocus,titleBarButtonBorderWithoutFocus

        );

        StyleBuilder.animateButtonColors(

                BTNMinimize,
                titleBarButtonBackgroundWithFocus, titleBarButtonBackgroundWithoutFocus,
                titleBarButtonBorderWithFocus, titleBarButtonBorderWithoutFocus,
                titleBarButtonFontColorWithFocus, titleBarButtonFontColorWithoutFocus

        );

        StyleBuilder.animateButtonColors(

                BTNClose,
                titleBarCloseButtonBackgroundWithFocus, titleBarCloseButtonBackgroundWithoutFocus,
                titleBarCloseButtonBorderWithFocus, titleBarCloseButtonBorderWithoutFocus,
                titleBarCloseButtonFontColorWithFocus, titleBarCloseButtonFontColorWithoutFocus

        );

    }

    @FXML
    void APTitleBarOnMousePressed(MouseEvent event) {

        xOffset = (int) event.getSceneX();
        yOffset = (int) event.getSceneY();

    }

    @FXML
    void BTNBackOnMouseClicked(MouseEvent event) {

        AccountMenuController controller = (AccountMenuController) sm.getController(FileConstants.AccountMenu);
        controller.initialize();
        sm.setScreenAtPosition(FileConstants.AccountMenu, Titles.AccountMenu);

    }

    @FXML
    void BTNBackOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNBack,
                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover

        );

    }

    @FXML
    void BTNBackOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNBack,
                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder,
                secondaryButtonFontColorHover, secondaryButtonFontColor

                );

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        Platform.exit();
        System.exit(0);

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNClose,
                titleBarCloseButtonBackgroundWithFocus, titleBarCloseButtonBackgroundWithFocusHover,
                titleBarCloseButtonBorderWithFocus, titleBarCloseButtonBorderWithFocusHover,
                titleBarCloseButtonFontColorWithFocus, titleBarCloseButtonFontColorWithFocusHover

        );

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

        if(APTitleBar.isHover()){

            StyleBuilder.animateButtonColors(

                    BTNClose,
                    titleBarCloseButtonBackgroundWithFocusHover, titleBarCloseButtonBackgroundWithFocus,
                    titleBarCloseButtonBorderWithFocusHover, titleBarCloseButtonBorderWithFocus,
                    titleBarCloseButtonFontColorWithFocusHover, titleBarCloseButtonFontColorWithFocus

            );

        }

    }

    @FXML
    void BTNGuestOnMouseClicked(MouseEvent event) {

        if (allConditionsMet) {

            // Registrar usuario
            ValidateFormInputs.validateInputsFromGuest(TXTName.getText(), TXTLastname.getText(), TBTToggle.isSelected() ? TXTNickname.getText() : null, sex, TXTBirthday.getLocalDate());

        }

    }

    @FXML
    void BTNGuestOnMouseEntered(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColors(

                    BTNGuest,
                    principalButtonBackground, principalButtonBackgroundHover,
                    principalButtonBorder, principalButtonBorderHover,
                    principalButtonFontColor, principalButtonFontColorHover

            );

        }

    }

    @FXML
    void BTNGuestOnMouseExited(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColors(

                    BTNGuest,
                    principalButtonBackgroundHover, principalButtonBackground,
                    principalButtonBorderHover, principalButtonBorder,
                    principalButtonFontColorHover,principalButtonFontColor

                    );

        }

    }

    @FXML
    void BTNMinimizeOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage)BTNMinimize.getScene().getWindow();
        stage.setIconified(true);

    }

    @FXML
    void BTNMinimizeOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNMinimize,
                titleBarButtonBackgroundWithFocus, titleBarButtonBackgroundWithFocusHover,
                titleBarButtonBorderWithFocus, titleBarButtonBorderWithFocusHover,
                titleBarButtonFontColorWithFocus, titleBarButtonFontColorWithFocusHover

        );

    }

    @FXML
    void BTNMinimizeOnMouseExited(MouseEvent event) {

        if(APTitleBar.isHover()){

            StyleBuilder.animateButtonColors(

                    BTNMinimize,
                    titleBarButtonBackgroundWithFocusHover, titleBarButtonBackgroundWithFocus,
                    titleBarButtonBorderWithFocusHover, titleBarButtonBorderWithFocus,
                    titleBarButtonFontColorWithFocusHover, titleBarButtonFontColorWithFocus

            );

        }

    }

    @FXML
    void IMGThemeOnMouseClicked(MouseEvent event) {

        isDarkMode = !isDarkMode;

        Preferences preferences = new Preferences();
        preferences.toggleTheme();

        changeTheme();

        applyStylesToTitleBar(titleBarBackgroundWithFocus, titleBarBorderWithFocus, APTitleBar);

        applyStylesToButtons(

                titleBarButtonBackgroundWithFocus,
                titleBarButtonBorderWithFocus,
                titleBarButtonFontColorWithFocus,
                Styles.px12,
                Styles.px1,
                Styles.px10,
                BTNClose, BTNMinimize

        );

        applyStylesToLabels(titleBarFontColorWithFocus, Styles.px12, LBLTitleBar);

        applyStylesToContents(

                titleBarButtonBackgroundWithFocusHover,
                titleBarButtonBorderWithFocusHover,
                Styles.px1,
                Styles.px10,
                SPTheme

        );

    }

    @FXML
    void IMGThemeOnMouseEntered(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGTheme, IMGThemeHover);

        StyleBuilder.animateStackPaneBackground(

                SPTheme,
                titleBarButtonBackgroundWithFocus, titleBarButtonBackgroundWithFocusHover,
                titleBarButtonBorderWithFocus, titleBarButtonBorderWithFocus

        );

    }

    @FXML
    void IMGThemeOnMouseExited(MouseEvent event) {

        StyleBuilder.fadeAndChangeImage(IMGThemeHover,IMGTheme);

        StyleBuilder.animateStackPaneBackground(

                SPTheme,
                titleBarButtonBackgroundWithFocusHover, titleBarButtonBackgroundWithFocus,
                titleBarButtonBorderWithFocus,titleBarButtonBorderWithFocus

        );

    }

    @FXML
    void TBTToggleOnMouseClicked(MouseEvent event) {

        if (TBTToggle.isSelected()) {
            TBTToggle.setText("Si");
            TXTNickname.setVisible(true);
            TXTNickname.setManaged(true);
            TXTHide.setVisible(false);
            TXTHide.setManaged(false);
        } else {
            TBTToggle.setText("No");
            TXTNickname.setVisible(false);
            TXTNickname.setManaged(false);
            TXTHide.setVisible(true);
            TXTHide.setManaged(true);
        }
        validateForm();

    }

    @FXML
    void TBTToggleOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                TBTToggle,
                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover

        );

    }

    @FXML
    void TBTToggleOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                TBTToggle,
                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder,
                secondaryButtonFontColorHover, secondaryButtonFontColor

        );

    }

    private void validateForm() {
        boolean isNameValid = !TXTName.getText().trim().isBlank();
        boolean isLastnameValid = !TXTLastname.getText().trim().isBlank();
        boolean isSexSelected = CBXSex.getValue() != null;
        boolean isNicknameValidOrNotRequired = !TBTToggle.isSelected() || (TBTToggle.isSelected() && !TXTNickname.getText().trim().isBlank());


        boolean birthdayIsValid = TXTBirthday.getLocalDate() != null;

        allConditionsMet = isNameValid && isLastnameValid && isSexSelected && isNicknameValidOrNotRequired && birthdayIsValid;

        BTNGuest.setDisable(!allConditionsMet);

        if(allConditionsMet){

            applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNGuest);
            BTNGuest.setOpacity(1.0);

        }else{

            applyStylesToButtons(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, BTNGuest);
            BTNGuest.setOpacity(0.66);

        }
    }

}
