package controllers;

import controls.DateMaskTextField;
import controls.SwitchButton;
import controls.TimeMaskTextField;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import logical.ValidateFormInputs;
import logical.ValidateOutputs;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.Colors;
import utilities.Images;
import utilities.Styles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class PopupSetClockController extends ConfigureInitializeStyles{

    //HashMaps
    private final Map<ToggleButton, PauseTransition> pendingOverrides = new HashMap<>();

    //Variables
    private static boolean isDarkMode, allConditionsMet = false, previousState =false;
    private static int previousMinute = LocalTime.now().getMinute()-1;

    //Botón primario
    private static String principalButtonBackground;
    private static String principalButtonBorder;
    private static String principalButtonFontColor;

    private static String principalButtonBackgroundHover;
    private static String principalButtonBorderHover;
    private static String principalButtonFontColorHover;

    //Popup Card
    private static String popupCardBackground;
    private static String popupCardBorder;

    private static String popupCardBackgroundHover;
    private static String popupCardBorderHover;

    //PopupTitleBarButton
    private static String popupTitleBarCloseButtonBackground;
    private static String popupTitleBarCloseButtonBorder;
    private static String popupTitleBarCloseButtonFontColor;

    private static String popupTitleBarCloseButtonBackgroundHover;
    private static String popupTitleBarCloseButtonBorderHover;
    private static String popupTitleBarCloseButtonFontColorHover;

    //PopupToggleButton
    private static String popupToggleButtonBackground;
    private static String popupToggleButtonBorder;
    private static String popupToggleButtonFontColor;

    private static String popupToggleButtonBackgroundHover;
    private static String popupToggleButtonBorderHover;
    private static String popupToggleButtonFontColorHover;

    private static String popupToggleButtonBackgroundActive;
    private static String popupToggleButtonBorderActive;
    private static String popupToggleButtonFontColorActive;

    //SwitchButton
    private static String switchButtonOff;
    private static String switchButtonON;
    private static String switchButtonThumb;

    //Botón desactivado
    private static String buttonBackgroundDisabled;
    private static String buttonBorderDisabled;
    private static String buttonFontColorDisabled;

    //Status toggleButtons
    String activeBG;
    String activeFC;

    String normalBG;
    String normalFC;

    @FXML
    private AnchorPane APMain;

    @FXML
    private Button BTNClose;

    @FXML
    private Button BTNStart;

    @FXML
    private ImageView IMGDate;

    @FXML
    private ImageView IMGDateHour;

    @FXML
    private ImageView IMGFocus1;

    @FXML
    private ImageView IMGFocus2;

    @FXML
    private ImageView IMGFocus3;

    @FXML
    private ImageView IMGFocus4;

    @FXML
    private ImageView IMGFocus5;

    @FXML
    private ImageView IMGHabits1;

    @FXML
    private ImageView IMGHabits2;

    @FXML
    private ImageView IMGHabits3;

    @FXML
    private ImageView IMGHabits4;

    @FXML
    private ImageView IMGHabits5;

    @FXML
    private ImageView IMGHour;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private ImageView IMGOther;

    @FXML
    private ImageView IMGPersonalGrowth1;

    @FXML
    private ImageView IMGPersonalGrowth2;

    @FXML
    private ImageView IMGPersonalGrowth3;

    @FXML
    private ImageView IMGPersonalGrowth4;

    @FXML
    private ImageView IMGPersonalGrowth5;

    @FXML
    private ImageView IMGRelations1;

    @FXML
    private ImageView IMGRelations2;

    @FXML
    private ImageView IMGRelations3;

    @FXML
    private ImageView IMGRelations4;

    @FXML
    private ImageView IMGRelations5;

    @FXML
    private ImageView IMGSubIcon;

    @FXML
    private ImageView IMGStart;

    @FXML
    private ImageView IMGStartHover;

    @FXML
    private ImageView IMGTech1;

    @FXML
    private ImageView IMGTech2;

    @FXML
    private ImageView IMGTech3;

    @FXML
    private ImageView IMGTech4;

    @FXML
    private Label LBLBuildDateAndHour;

    @FXML
    private Label LBLDateHour;

    @FXML
    private Label LBLFocus1;

    @FXML
    private Label LBLFocus2;

    @FXML
    private Label LBLFocus3;

    @FXML
    private Label LBLFocus4;

    @FXML
    private Label LBLFocus5;

    @FXML
    private Label LBLHabits1;

    @FXML
    private Label LBLHabits2;

    @FXML
    private Label LBLHabits3;

    @FXML
    private Label LBLHabits4;

    @FXML
    private Label LBLHabits5;

    @FXML
    private Label LBLMaxChars;

    @FXML
    private Label LBLMaxCharsCount;

    @FXML
    private Label LBLOther;

    @FXML
    private Label LBLPersonalGrowth1;

    @FXML
    private Label LBLPersonalGrowth2;

    @FXML
    private Label LBLPersonalGrowth3;

    @FXML
    private Label LBLPersonalGrowth4;

    @FXML
    private Label LBLPersonalGrowth5;

    @FXML
    private Label LBLRelations1;

    @FXML
    private Label LBLRelations2;

    @FXML
    private Label LBLRelations3;

    @FXML
    private Label LBLRelations4;

    @FXML
    private Label LBLRelations5;

    @FXML
    private Label LBLStart;

    @FXML
    private Label LBLTech1;

    @FXML
    private Label LBLTech2;

    @FXML
    private Label LBLTech3;

    @FXML
    private Label LBLTech4;

    @FXML
    private StackPane SPDate;

    @FXML
    private StackPane SPDateHourSelector;

    @FXML
    private StackPane SPOther;

    @FXML
    private ToggleButton TBTButtonFocus1;

    @FXML
    private ToggleButton TBTButtonFocus2;

    @FXML
    private ToggleButton TBTButtonFocus3;

    @FXML
    private ToggleButton TBTButtonFocus4;

    @FXML
    private ToggleButton TBTButtonFocus5;

    @FXML
    private ToggleButton TBTButtonHabits1;

    @FXML
    private ToggleButton TBTButtonHabits2;

    @FXML
    private ToggleButton TBTButtonHabits3;

    @FXML
    private ToggleButton TBTButtonHabits4;

    @FXML
    private ToggleButton TBTButtonHabits5;

    @FXML
    private ToggleButton TBTButtonOther;

    @FXML
    private ToggleButton TBTButtonPersonalGrowth1;

    @FXML
    private ToggleButton TBTButtonPersonalGrowth2;

    @FXML
    private ToggleButton TBTButtonPersonalGrowth3;

    @FXML
    private ToggleButton TBTButtonPersonalGrowth4;

    @FXML
    private ToggleButton TBTButtonPersonalGrowth5;

    @FXML
    private ToggleButton TBTButtonRelations1;

    @FXML
    private ToggleButton TBTButtonRelations2;

    @FXML
    private ToggleButton TBTButtonRelations3;

    @FXML
    private ToggleButton TBTButtonRelations4;

    @FXML
    private ToggleButton TBTButtonRelations5;

    @FXML
    private ToggleButton TBTButtonTech1;

    @FXML
    private ToggleButton TBTButtonTech2;

    @FXML
    private ToggleButton TBTButtonTech3;

    @FXML
    private ToggleButton TBTButtonTech4;

    @FXML
    private TextField TXTDescription;

    @FXML
    private ToggleGroup group;

    @FXML
    private HBox HBODateHour;

    @FXML
    private VBox VBXDateSelector;

    @FXML
    private VBox VBXHourSelector;

    ToggleButton [] toggleButtons;
    ImageView [] imageViews;
    Label [] labels;

    SwitchButton switchButton = new SwitchButton();
    TimeMaskTextField TXTHour = new TimeMaskTextField();
    DateMaskTextField TXTDate = new DateMaskTextField();
    Timeline buildLabel;

    @FXML
    void initialize(){

        buildDateAndHour();

        Images.clearImages();

        isDarkMode = UserPreferences.getUserThemeMode();

        removeSelection(TBTButtonFocus1, TBTButtonFocus2, TBTButtonFocus3, TBTButtonFocus4, TBTButtonFocus5, TBTButtonHabits1, TBTButtonHabits2, TBTButtonHabits3, TBTButtonHabits4, TBTButtonHabits5, TBTButtonOther, TBTButtonPersonalGrowth1, TBTButtonPersonalGrowth2, TBTButtonPersonalGrowth3, TBTButtonPersonalGrowth4, TBTButtonPersonalGrowth5, TBTButtonRelations1, TBTButtonRelations2, TBTButtonRelations3, TBTButtonRelations4, TBTButtonRelations5, TBTButtonTech1, TBTButtonTech2, TBTButtonTech3, TBTButtonTech4);

        toggleButtons = new ToggleButton[]{TBTButtonFocus1, TBTButtonFocus2, TBTButtonFocus3, TBTButtonFocus4, TBTButtonFocus5, TBTButtonHabits1, TBTButtonHabits2, TBTButtonHabits3, TBTButtonHabits4, TBTButtonHabits5, TBTButtonOther, TBTButtonPersonalGrowth1, TBTButtonPersonalGrowth2, TBTButtonPersonalGrowth3, TBTButtonPersonalGrowth4, TBTButtonPersonalGrowth5, TBTButtonRelations1, TBTButtonRelations2, TBTButtonRelations3, TBTButtonRelations4, TBTButtonRelations5, TBTButtonTech1, TBTButtonTech2, TBTButtonTech3, TBTButtonTech4};

        labels = new Label [] {LBLFocus1, LBLFocus2, LBLFocus3, LBLFocus4, LBLFocus5, LBLHabits1, LBLHabits2, LBLHabits3, LBLHabits4, LBLHabits5, LBLOther, LBLPersonalGrowth1, LBLPersonalGrowth2, LBLPersonalGrowth3, LBLPersonalGrowth4, LBLPersonalGrowth5, LBLRelations1, LBLRelations2, LBLRelations3, LBLRelations4, LBLRelations5, LBLTech1, LBLTech2, LBLTech3, LBLTech4};

        imageViews = new ImageView [] {IMGFocus1, IMGFocus2, IMGFocus3, IMGFocus4, IMGFocus5, IMGHabits1, IMGHabits2, IMGHabits3, IMGHabits4, IMGHabits5, IMGOther, IMGPersonalGrowth1, IMGPersonalGrowth2, IMGPersonalGrowth3, IMGPersonalGrowth4, IMGPersonalGrowth5, IMGRelations1, IMGRelations2, IMGRelations3, IMGRelations4, IMGRelations5, IMGTech1, IMGTech2, IMGTech3, IMGTech4};

        StyleBuilder.clearControls(TXTDescription);

        TXTDescription.textProperty().addListener((obs, oldVal, newVal) ->{countChars();validateFields();});

        IMGStartHover.setOpacity(0);

        SPDateHourSelector.setVisible(false);
        SPDateHourSelector.setManaged(false);

        SPOther.setVisible(false);
        SPOther.setManaged(false);


        if(!VBXDateSelector.getChildren().contains(TXTDate)){

            VBXDateSelector.getChildren().add(TXTDate);

        }

        if(!VBXHourSelector.getChildren().contains(TXTHour)){

            VBXHourSelector.getChildren().add(TXTHour);

        }
        
        switchButton.selectedProperty().addListener((obs, oldVal, newVal) ->{switchButton();validateFields();});

        if(!HBODateHour.getChildren().contains(switchButton)){

            HBODateHour.getChildren().add(switchButton);

        }

        switchButton.setSelected(true);

        TXTDate.textProperty().addListener((obs, oldVal, newVal) ->{

            buildDateAndHour();

            validateFields();

        });

        TXTHour.textProperty().addListener((obs, oldVal, newVal) ->{

            buildDateAndHour();

            validateFields();

        });

        for(ToggleButton button : toggleButtons){

            button.selectedProperty().addListener((obs, oldVal, newVal) ->{activeToggleButton(); validateFields();});

        }

        validateFields();

        changeTheme();

    }

    private void changeTheme(){

        changeColors();

        StyleBuilder.setAnchorPaneClass(APMain);

        switchButton.setOffColor(switchButtonOff);
        switchButton.setOnColor(switchButtonON);
        switchButton.setThumbColor(switchButtonThumb);

        ConfigureNodes.configureNodesForPopupSetClockController(BTNClose, BTNStart, IMGDate, IMGDateHour, IMGFocus1, IMGFocus2, IMGFocus3, IMGFocus4, IMGFocus5, IMGHabits1, IMGHabits2, IMGHabits3, IMGHabits4, IMGHabits5, IMGHour, IMGIcon, IMGOther, IMGPersonalGrowth1, IMGPersonalGrowth2, IMGPersonalGrowth3, IMGPersonalGrowth4, IMGPersonalGrowth5, IMGRelations1, IMGRelations2, IMGRelations3, IMGRelations4, IMGRelations5, IMGSubIcon, IMGStart, IMGStartHover, IMGTech1, IMGTech2, IMGTech3, IMGTech4, LBLFocus1, LBLFocus2, LBLFocus3, LBLFocus4, LBLFocus5, LBLHabits1, LBLHabits2, LBLHabits3, LBLHabits4, LBLHabits5, LBLOther, LBLPersonalGrowth1, LBLPersonalGrowth2, LBLPersonalGrowth3, LBLPersonalGrowth4, LBLPersonalGrowth5, LBLRelations1, LBLRelations2, LBLRelations3, LBLRelations4, LBLRelations5, LBLStart, LBLTech1, LBLTech2, LBLTech3, LBLTech4, SPDate, SPDateHourSelector, SPOther, TBTButtonFocus1, TBTButtonFocus2, TBTButtonFocus3, TBTButtonFocus4, TBTButtonFocus5, TBTButtonHabits1, TBTButtonHabits2, TBTButtonHabits3, TBTButtonHabits4, TBTButtonHabits5, TBTButtonOther, TBTButtonPersonalGrowth1, TBTButtonPersonalGrowth2, TBTButtonPersonalGrowth3, TBTButtonPersonalGrowth4, TBTButtonPersonalGrowth5, TBTButtonRelations1, TBTButtonRelations2, TBTButtonRelations3, TBTButtonRelations4, TBTButtonRelations5, TBTButtonTech1, TBTButtonTech2, TBTButtonTech3, TBTButtonTech4, isDarkMode, allConditionsMet);

        activeToggleButton();

        initializeAnimation();

    }

    private void changeColors(){

        //Botón primario
        principalButtonBackground = Colors.getColor("principal-button-background", isDarkMode);
        principalButtonBorder = Colors.getColor("principal-button-border", isDarkMode);
        principalButtonFontColor = Colors.getColor("principal-button-font-color", isDarkMode);

        principalButtonBackgroundHover = Colors.getColor("principal-button-background-hover", isDarkMode);
        principalButtonBorderHover = Colors.getColor("principal-button-border-hover", isDarkMode);
        principalButtonFontColorHover = Colors.getColor("principal-button-font-color-hover", isDarkMode);

        //Popup Card
        popupCardBackground = Colors.getColor("popup-card-background", isDarkMode);
        popupCardBorder = Colors.getColor("popup-card-border", isDarkMode);

        popupCardBackgroundHover = Colors.getColor("popup-card-background-hover", isDarkMode);
        popupCardBorderHover = Colors.getColor("popup-card-border-hover", isDarkMode);

        //Popup Title Bar Button
        popupTitleBarCloseButtonBackground = Colors.getColor("popup-title-bar-close-button-background", isDarkMode);
        popupTitleBarCloseButtonBorder = Colors.getColor("popup-title-bar-close-button-border", isDarkMode);
        popupTitleBarCloseButtonFontColor = Colors.getColor("popup-title-bar-close-button-font-color", isDarkMode);

        popupTitleBarCloseButtonBackgroundHover = Colors.getColor("popup-title-bar-close-button-background-hover", isDarkMode);
        popupTitleBarCloseButtonBorderHover = Colors.getColor("popup-title-bar-close-button-border-hover", isDarkMode);
        popupTitleBarCloseButtonFontColorHover = Colors.getColor("popup-title-bar-close-button-font-color-hover", isDarkMode);

        //PopupToggleButton
        popupToggleButtonBackground = Colors.getColor("popup-toggle-button-background", isDarkMode);
        popupToggleButtonBorder = Colors.getColor("popup-toggle-button-border", isDarkMode);
        popupToggleButtonFontColor = Colors.getColor("popup-toggle-button-font-color", isDarkMode);

        popupToggleButtonBackgroundHover = Colors.getColor("popup-toggle-button-background-hover", isDarkMode);
        popupToggleButtonBorderHover = Colors.getColor("popup-toggle-button-border-hover", isDarkMode);
        popupToggleButtonFontColorHover = Colors.getColor("popup-toggle-button-font-color-hover", isDarkMode);

        popupToggleButtonBackgroundActive = Colors.getColor("popup-toggle-button-background-active", isDarkMode);
        popupToggleButtonBorderActive = Colors.getColor("popup-toggle-button-border-active", isDarkMode);
        popupToggleButtonFontColorActive = Colors.getColor("popup-toggle-button-font-color-active", isDarkMode);

        //SwitchButton
        switchButtonOff = Colors.getColor("switch-button-off", isDarkMode);
        switchButtonON = Colors.getColor("switch-button-on", isDarkMode);
        switchButtonThumb = Colors.getColor("switch-button-thumb", isDarkMode);

        //ToggleButtons
        activeBG = buildStylesForContents(popupToggleButtonBackgroundActive, popupToggleButtonBorderActive, Styles.px1, Styles.px10);
        activeFC = buildStylesForLabels(popupToggleButtonFontColorActive, Styles.px12);
        normalBG = buildStylesForContents(popupToggleButtonBackground, popupToggleButtonBorder, Styles.px1, Styles.px10);
        normalFC = buildStylesForLabels(popupToggleButtonFontColor, Styles.px12);

        //Botón desactivado
        buttonBackgroundDisabled = Colors.getColor("button-background-disabled", isDarkMode);
        buttonBorderDisabled = Colors.getColor("button-border-disabled", isDarkMode);
        buttonFontColorDisabled = Colors.getColor("button-font-color-disabled", isDarkMode);

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        stopAnimation();

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
    void BTNStartOnMouseClicked(MouseEvent event) {

        //Validar información
        ValidateFormInputs.validateInputsFromSetClock(TBTButtonOther.isSelected() ? TXTDescription.getText() : getSelectedObjective(), switchButton.isSelected() ? LocalDate.now() : TXTDate.getLocalDate(), switchButton.isSelected() ? LocalTime.now() : TXTHour.getLocalTime());

    }

    @FXML
    void BTNStartOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackground, principalButtonBackgroundHover,
                principalButtonBorder, principalButtonBorderHover,
                principalButtonFontColor, principalButtonFontColorHover,
                BTNStart, IMGStart, IMGStartHover, LBLStart

        );

    }

    @FXML
    void BTNStartOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackgroundHover, principalButtonBackground,
                principalButtonBorderHover, principalButtonBorder,
                principalButtonFontColorHover, principalButtonFontColor,
                BTNStart, IMGStartHover, IMGStart, LBLStart

        );

    }

    @FXML
    void SPDateHourSelectorOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPDateHourSelector,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

    }

    @FXML
    void SPDateHourSelectorOnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPDateHourSelector,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover, popupCardBorder


        );

    }

    @FXML
    void SPDateOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPDate,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover

        );

    }

    @FXML
    void SPDateOnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPDate,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover

        );

    }

    @FXML
    void SPOtherOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPOther,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover

        );

    }

    @FXML
    void SPOtherOnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPOther,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

    }

    @FXML
    void TBTButtonFocus1OnMouseEntered(MouseEvent event) {

        if(!TBTButtonFocus1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonFocus1, LBLFocus1
            );

        }

    }

    @FXML
    void TBTButtonFocus1OnMouseExited(MouseEvent event) {

        if(!TBTButtonFocus1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonFocus1, LBLFocus1
            );

        }

    }

    @FXML
    void TBTButtonFocus2OnMouseEntered(MouseEvent event) {

        if(!TBTButtonFocus2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonFocus2, LBLFocus2
            );

        }

    }

    @FXML
    void TBTButtonFocus2OnMouseExited(MouseEvent event) {

        if(!TBTButtonFocus2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonFocus2, LBLFocus2
            );

        }

    }

    @FXML
    void TBTButtonFocus3OnMouseEntered(MouseEvent event) {

        if(!TBTButtonFocus3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonFocus3, LBLFocus3
            );

        }

    }

    @FXML
    void TBTButtonFocus3OnMouseExited(MouseEvent event) {

        if(!TBTButtonFocus3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonFocus3, LBLFocus3
            );

        }

    }

    @FXML
    void TBTButtonFocus4OnMouseEntered(MouseEvent event) {

        if(!TBTButtonFocus4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonFocus4, LBLFocus4
            );

        }

    }

    @FXML
    void TBTButtonFocus4OnMouseExited(MouseEvent event) {

        if(!TBTButtonFocus4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonFocus4, LBLFocus4
            );

        }

    }

    @FXML
    void TBTButtonFocus5OnMouseEntered(MouseEvent event) {

        if(!TBTButtonFocus5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonFocus5, LBLFocus5
            );

        }

    }

    @FXML
    void TBTButtonFocus5OnMouseExited(MouseEvent event) {

        if(!TBTButtonFocus5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonFocus5, LBLFocus5
            );

        }

    }

    @FXML
    void TBTButtonHabits1OnMouseEntered(MouseEvent event) {

        if(!TBTButtonHabits1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonHabits1, LBLHabits1
            );

        }

    }

    @FXML
    void TBTButtonHabits1OnMouseExited(MouseEvent event) {

        if(!TBTButtonHabits1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonHabits1, LBLHabits1
            );

        }

    }

    @FXML
    void TBTButtonHabits2OnMouseEntered(MouseEvent event) {

        if(!TBTButtonHabits2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonHabits2, LBLHabits2
            );

        }

    }

    @FXML
    void TBTButtonHabits2OnMouseExited(MouseEvent event) {

        if(!TBTButtonHabits2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonHabits2, LBLHabits2
            );

        }

    }

    @FXML
    void TBTButtonHabits3OnMouseEntered(MouseEvent event) {

        if(!TBTButtonHabits3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonHabits3, LBLHabits3
            );

        }

    }

    @FXML
    void TBTButtonHabits3OnMouseExited(MouseEvent event) {

        if(!TBTButtonHabits3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonHabits3, LBLHabits3
            );

        }

    }


    @FXML
    void TBTButtonHabits4OnMouseEntered(MouseEvent event) {

        if(!TBTButtonHabits4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonHabits4, LBLHabits4
            );

        }

    }

    @FXML
    void TBTButtonHabits4OnMouseExited(MouseEvent event) {

        if(!TBTButtonHabits4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonHabits4, LBLHabits4
            );

        }

    }

    @FXML
    void TBTButtonHabits5OnMouseEntered(MouseEvent event) {

        if(!TBTButtonHabits5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonHabits5, LBLHabits5
            );

        }

    }

    @FXML
    void TBTButtonHabits5OnMouseExited(MouseEvent event) {

        if(!TBTButtonHabits5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonHabits5, LBLHabits5
            );

        }

    }

    @FXML
    void TBTButtonOtherOnMouseEntered(MouseEvent event) {

        if(!TBTButtonOther.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonOther, LBLOther
            );

        }

    }

    @FXML
    void TBTButtonOtherOnMouseExited(MouseEvent event) {

        if(!TBTButtonOther.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonOther, LBLOther
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth1OnMouseEntered(MouseEvent event) {

        if(!TBTButtonPersonalGrowth1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonPersonalGrowth1, LBLPersonalGrowth1
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth1OnMouseExited(MouseEvent event) {

        if(!TBTButtonPersonalGrowth1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonPersonalGrowth1, LBLPersonalGrowth1
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth2OnMouseEntered(MouseEvent event) {

        if(!TBTButtonPersonalGrowth2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonPersonalGrowth2, LBLPersonalGrowth2
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth2OnMouseExited(MouseEvent event) {

        if(!TBTButtonPersonalGrowth2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonPersonalGrowth2, LBLPersonalGrowth2
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth3OnMouseEntered(MouseEvent event) {

        if(!TBTButtonPersonalGrowth3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonPersonalGrowth3, LBLPersonalGrowth3
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth3OnMouseExited(MouseEvent event) {

        if(!TBTButtonPersonalGrowth3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonPersonalGrowth3, LBLPersonalGrowth3
            );

        }

    }


    @FXML
    void TBTButtonPersonalGrowth4OnMouseEntered(MouseEvent event) {

        if(!TBTButtonPersonalGrowth4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonPersonalGrowth4, LBLPersonalGrowth4
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth4OnMouseExited(MouseEvent event) {

        if(!TBTButtonPersonalGrowth4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonPersonalGrowth4, LBLPersonalGrowth4
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth5OnMouseEntered(MouseEvent event) {

        if(!TBTButtonPersonalGrowth5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonPersonalGrowth5, LBLPersonalGrowth5
            );

        }

    }

    @FXML
    void TBTButtonPersonalGrowth5OnMouseExited(MouseEvent event) {

        if(!TBTButtonPersonalGrowth5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonPersonalGrowth5, LBLPersonalGrowth5
            );

        }

    }

    @FXML
    void TBTButtonRelations1OnMouseEntered(MouseEvent event) {

        if(!TBTButtonRelations1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonRelations1, LBLRelations1
            );

        }

    }

    @FXML
    void TBTButtonRelations1OnMouseExited(MouseEvent event) {

        if(!TBTButtonRelations1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonRelations1, LBLRelations1
            );

        }

    }

    @FXML
    void TBTButtonRelations2OnMouseEntered(MouseEvent event) {

        if(!TBTButtonRelations2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonRelations2, LBLRelations2
            );

        }

    }

    @FXML
    void TBTButtonRelations2OnMouseExited(MouseEvent event) {

        if(!TBTButtonRelations2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonRelations2, LBLRelations2
            );

        }

    }

    @FXML
    void TBTButtonRelations3OnMouseEntered(MouseEvent event) {

        if(!TBTButtonRelations3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonRelations3, LBLRelations3
            );

        }

    }

    @FXML
    void TBTButtonRelations3OnMouseExited(MouseEvent event) {

        if(!TBTButtonRelations3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonRelations3, LBLRelations3
            );

        }

    }

    @FXML
    void TBTButtonRelations4OnMouseEntered(MouseEvent event) {

        if(!TBTButtonRelations4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonRelations4, LBLRelations4
            );

        }

    }

    @FXML
    void TBTButtonRelations4OnMouseExited(MouseEvent event) {

        if(!TBTButtonRelations4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonRelations4, LBLRelations4
            );

        }

    }

    @FXML
    void TBTButtonRelations5OnMouseEntered(MouseEvent event) {

        if(!TBTButtonRelations5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonRelations5, LBLRelations5
            );

        }

    }

    @FXML
    void TBTButtonRelations5OnMouseExited(MouseEvent event) {

        if(!TBTButtonRelations5.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonRelations5, LBLRelations5
            );

        }

    }

    @FXML
    void TBTButtonTech1OnMouseEntered(MouseEvent event) {

        if(!TBTButtonTech1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonTech1, LBLTech1
            );

        }

    }

    @FXML
    void TBTButtonTech1OnMouseExited(MouseEvent event) {

        if(!TBTButtonTech1.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonTech1, LBLTech1
            );

        }

    }

    @FXML
    void TBTButtonTech2OnMouseEntered(MouseEvent event) {

        if(!TBTButtonTech2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonTech2, LBLTech2
            );

        }

    }

    @FXML
    void TBTButtonTech2OnMouseExited(MouseEvent event) {

        if(!TBTButtonTech2.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonTech2, LBLTech2
            );

        }

    }

    @FXML
    void TBTButtonTech3OnMouseEntered(MouseEvent event) {

        if(!TBTButtonTech3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonTech3, LBLTech3
            );

        }

    }

    @FXML
    void TBTButtonTech3OnMouseExited(MouseEvent event) {

        if(!TBTButtonTech3.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonTech3, LBLTech3
            );

        }

    }

    @FXML
    void TBTButtonTech4OnMouseEntered(MouseEvent event) {

        if(!TBTButtonTech4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackground, popupToggleButtonBackgroundHover,
                    popupToggleButtonBorder, popupToggleButtonBorderHover,
                    popupToggleButtonFontColor, popupToggleButtonFontColorHover,
                    TBTButtonTech4, LBLTech4
            );

        }

    }

    @FXML
    void TBTButtonTech4OnMouseExited(MouseEvent event) {

        if(!TBTButtonTech4.isSelected()){

            StyleBuilder.animateButtonColorsWithLabel(

                    popupToggleButtonBackgroundHover, popupToggleButtonBackground,
                    popupToggleButtonBorderHover, popupToggleButtonBorder,
                    popupToggleButtonFontColorHover, popupToggleButtonFontColor,
                    TBTButtonTech4, LBLTech4
            );

        }

    }

    private void activeToggleButton() {
        for (int i = 0; i < toggleButtons.length; i++) {
            ToggleButton btn = toggleButtons[i];
            if (btn == null) continue;

            boolean selected = btn.isSelected();


            imageViews[i].setVisible(selected);


            PauseTransition prev = pendingOverrides.remove(btn);
            if (prev != null) {
                prev.stop();
            }


            if (selected) {
                btn.setStyle(activeBG);
                labels[i].setStyle(activeFC);
            } else {
                btn.setStyle(normalBG);
                labels[i].setStyle(normalFC);
            }
            int pos = i;
            PauseTransition override = new PauseTransition(Duration.millis(60));
            override.setOnFinished(e -> {

                if (btn.isSelected()) {
                    btn.setStyle(activeBG);
                    labels[pos].setStyle(activeFC);
                } else {
                    btn.setStyle(normalBG);
                    labels[pos].setStyle(normalFC);
                }
                pendingOverrides.remove(btn);
            });
            pendingOverrides.put(btn, override);
            override.play();
        }

        if (TBTButtonOther != null) {
            if (TBTButtonOther.isSelected()) {
                showRegion(SPOther);
            } else {
                hideRegion(SPOther);
            }
        }
    }

    private void countChars() {
        int length = TXTDescription.getText().length();
        LBLMaxCharsCount.setText(length + "/60");

        if (length > 60) {

            if (!LBLMaxCharsCount.getStyleClass().contains("err")) {
                LBLMaxCharsCount.getStyleClass().add("err");
                LBLMaxChars.getStyleClass().add("err");
                TXTDescription.getStyleClass().add("err");


                LBLMaxCharsCount.getStyleClass().remove("LBLMaxChars");
                LBLMaxChars.getStyleClass().remove("LBLMaxChars");
            }

        } else {

            LBLMaxCharsCount.getStyleClass().remove("err");
            LBLMaxChars.getStyleClass().remove("err");
            TXTDescription.getStyleClass().remove("err");

            if (!LBLMaxCharsCount.getStyleClass().contains("LBLMaxChars")) {
                LBLMaxCharsCount.getStyleClass().add("LBLMaxChars");
                LBLMaxChars.getStyleClass().add("LBLMaxChars");
            }
        }
    }

    private void removeSelection(ToggleButton... toggleButtons) {

        for(ToggleButton toggleButton : toggleButtons) {

            if(toggleButton != null){

                toggleButton.setSelected(false);

            }

        }

    }

    private void switchButton(){

        if(switchButton.isSelected()){

            //Ocultar el stackPane
            hideRegion(SPDateHourSelector);

        }else{

            showRegion(SPDateHourSelector);

        }

    }

    public static void showRegion(Region pane) {
        pane.setManaged(true);
        pane.setVisible(true);
        pane.setOpacity(0);

        FadeTransition fade = new FadeTransition(Duration.millis(300), pane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }


    public static void hideRegion(Region pane) {
        FadeTransition fade = new FadeTransition(Duration.millis(300), pane);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setOnFinished(event -> {
            pane.setVisible(false);
            pane.setManaged(false);
        });
        fade.play();
    }

    private void buildDateAndHour (){

        if(TXTDate.getLocalDate() != null && TXTHour.getLocalTime() != null){

            //La fecha es completa
            LBLBuildDateAndHour.setText("La fecha ingresada es el " + ValidateOutputs.buildDateAndHour(TXTDate.getLocalDate(), TXTHour.getLocalTime(), false, false));

        }else{

            LBLBuildDateAndHour.setText("Aún no hay información suficiente como para construir una fecha");

        }

    }

    private void validateFields(){

        allConditionsMet = (group.getSelectedToggle() != null && switchButton.isSelected() || TXTDate.getLocalDate() != null && TXTHour.getLocalTime() != null);

        if(allConditionsMet != previousState){

            if(allConditionsMet){

                applyStylesToButtonsWithLabel(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase[] {BTNStart}, new Label [] {LBLStart});
                IMGStart.setOpacity(1);
                BTNStart.setOpacity(1);

            }else{

                applyStylesToButtonsWithLabel(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNStart}, new Label [] {LBLStart});
                IMGStart.setOpacity(0);
                BTNStart.setOpacity(0.66);

            }

            previousState = allConditionsMet;

        }

    }

    public void startAnimation(){

        buildLabel.play();

    }

    private void initializeAnimation(){

        buildLabel = new Timeline(new KeyFrame(Duration.seconds(1), event ->{buildLabel();}));
        buildLabel.setCycleCount(Timeline.INDEFINITE);
        buildLabel.play();

    }

    private void buildLabel(){

        int minute = LocalTime.now().getMinute();

        if(minute != previousMinute){

            LBLDateHour.setText(ValidateOutputs.buildDateAndHour(LocalDate.now(), LocalTime.now(), false, true));

            previousMinute = minute;

        }

    }

    private void stopAnimation(){

        buildLabel.stop();

    }

    private String getSelectedObjective(){

        for(int i = 0; i < toggleButtons.length ; i++){

            if(toggleButtons[i].isSelected()){

                return labels[i].getText();

            }

        }

        return null;

    }

}
