package controllers;

import connections.Clock;
import files.Preferences;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.StyleBuilder;
import user.UserData;
import user.UserPreferences;
import utilities.FileConstants;
import utilities.ScreenManager;
import utilities.Styles;

public class PopupCustomClockController extends ConfigureInitializeStyles {

    //Objetos
    ScreenManager sm = ScreenManager.getInstance();

    //Variables
    private boolean isDarkMode;

    //Variables de color;
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
    private Button BTNClose;

    @FXML
    private ToggleGroup Colors;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private ToggleButton BTNBlue;

    @FXML
    private ToggleButton BTNGreen;

    @FXML
    private ToggleButton BTNOrange;

    @FXML
    private ToggleButton BTNPink;

    @FXML
    private ToggleButton BTNPurple;

    @FXML
    private ToggleButton BTNYellow;

    private ToggleButton [] buttons;

    private String [] colors = {"#3B82F6", "#10B981", "#F97316", "#8B5CF6", "#EC4899", "#D97706"};

    @FXML
    private void initialize(){

        isDarkMode = UserPreferences.getUserThemeMode();

        buttons = new ToggleButton [] {BTNBlue, BTNGreen, BTNOrange, BTNPurple, BTNPink, BTNYellow};

        for(ToggleButton button : buttons){

            button.selectedProperty().addListener((obs, oldVal, newVal) -> {

                selectColor();

            });

        }

        changeTheme();

    }

    private void changeTheme(){

        changeColors();

        StyleBuilder.setAnchorPaneClass(APMain);

        setImages(FileConstants.paletteIconDm, FileConstants.paletteIconLm, isDarkMode, IMGIcon);

        applyStylesToButtons(secondaryButtonBackground,secondaryButtonBorder,secondaryButtonFontColor, Styles.px12, Styles.px1,Styles.px10, BTNClose);

    }

    private void selectColor(){

        for(int i = 0; i < buttons.length ; i++){

            if(buttons[i].isSelected()){

                UserPreferences.setYearClockColor(colors[i]);
                UserPreferences.setBackgroundYearClockColor(colors[i]+"33");
                UserPreferences.setMonthClockColor(colors[i]);
                UserPreferences.setBackgroundMonthClockColor(colors[i]+"33");
                UserPreferences.setDayClockColor(colors[i]);
                UserPreferences.setBackgroundDayClockColor(colors[i]+"33");
                UserPreferences.setHourClockColor(colors[i]);
                UserPreferences.setBackgroundHourClockColor(colors[i]+"33");
                UserPreferences.setMinuteClockColor(colors[i]);
                UserPreferences.setBackgroundMinuteClockColor(colors[i]+"33");
                UserPreferences.setSecondClockColor(colors[i]);
                UserPreferences.setBackgroundSecondClockColor(colors[i]+"33");

                if(UserData.haveAnyAccount()){

                    String [] fields = {"YearClockColor", "MonthClockColor", "DayClockColor", "HourClockColor", "MinuteClockColor", "SecondClockColor"};

                    Clock clock = new Clock();

                   for(int j = 0; j<6; j++){

                        clock.updateColors(fields[j], colors[i]);

                   }

                }

                Preferences file = new Preferences();

                file.updateClockColors();

                break;

            }

        }

        MainWindowController controller = (MainWindowController) sm.getController(FileConstants.MainWindow);

        controller.updateClockColors();

        Stage stage = (Stage)BTNClose.getScene().getWindow();
        stage.close();

    }

    private void changeColors(){

        //Botón secundario
        secondaryButtonBackground = utilities.Colors.getColor("secondary-button-background", isDarkMode);
        secondaryButtonBorder = utilities.Colors.getColor("secondary-button-border", isDarkMode);
        secondaryButtonFontColor = utilities.Colors.getColor("secondary-button-font-color", isDarkMode);

        secondaryButtonBackgroundHover = utilities.Colors.getColor("secondary-button-background-hover", isDarkMode);
        secondaryButtonBorderHover = utilities.Colors.getColor("secondary-button-border-hover", isDarkMode);
        secondaryButtonFontColorHover = utilities.Colors.getColor("secondary-button-font-color-hover", isDarkMode);

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
                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover

        );

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                    BTNClose,
                    secondaryButtonBackgroundHover, secondaryButtonBackground,
                    secondaryButtonBorderHover, secondaryButtonBorder,
                    secondaryButtonFontColorHover, secondaryButtonFontColor

        );

    }

}
