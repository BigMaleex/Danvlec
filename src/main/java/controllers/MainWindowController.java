package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.Colors;
import utilities.Images;
import utilities.ScreenManager;

public class MainWindowController {

    //Objetos
    ScreenManager sm = ScreenManager.getInstance();

    //Variables
    private static boolean isDarkMode;

    //variables de color
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
    private Button BTNClose;

    @FXML
    private Button BTNCustomClock;

    @FXML
    private Button BTNExportExcel;

    @FXML
    private Button BTNMinimize;

    @FXML
    private Button BTNMotivations;

    @FXML
    private Button BTNNewEntry;

    @FXML
    private Button BTNRestartClock;

    @FXML
    private ImageView IMGAllEntries;

    @FXML
    private ImageView IMGCustomClock;

    @FXML
    private ImageView IMGCustomClockHover;

    @FXML
    private ImageView IMGExportExcel;

    @FXML
    private ImageView IMGExportExcelHover;

    @FXML
    private ImageView IMGMonthlyEntries;

    @FXML
    private ImageView IMGMotivations;

    @FXML
    private ImageView IMGMotivationsHover;

    @FXML
    private ImageView IMGNewEntry;

    @FXML
    private ImageView IMGNewEntryHover;

    @FXML
    private ImageView IMGPhrase;

    @FXML
    private ImageView IMGRestartClock;

    @FXML
    private ImageView IMGRestartClockHover;

    @FXML
    private ImageView IMGTheme;

    @FXML
    private ImageView IMGThemeHover;

    @FXML
    private ImageView IMGThemeInit;

    @FXML
    private ImageView IMGWeeklyEntries;

    @FXML
    private Label LBLAllEntriesCount;

    @FXML
    private Label LBLCustomClock;

    @FXML
    private Label LBLExportExcel;

    @FXML
    private Label LBLMonthlyEntriesCount;

    @FXML
    private Label LBLMotivations;

    @FXML
    private Label LBLNewEntry;

    @FXML
    private Label LBLRestartClock;

    @FXML
    private Label LBLTitleBar;

    @FXML
    private Label LBLWeeklyEntriesCount;

    @FXML
    private StackPane SPTheme;

    @FXML
    private TextFlow TFLGreeting;

    @FXML
    private TextFlow TFLMotivations;

    @FXML
    private TextFlow TFLPhrase;

    @FXML
    private TextFlow TFLTitleClock;

    @FXML
    public void initialize(){

        Images.clearImages();
        isDarkMode = UserPreferences.getUserThemeMode();


        changeTheme();

    }

    private void changeTheme(){

        StyleBuilder.setAnchorPaneClass(APMain);

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

    @FXML
    void APTitleBarOnMouseDragged(MouseEvent event) {

    }

    @FXML
    void APTitleBarOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void APTitleBarOnMouseExited(MouseEvent event) {

    }

    @FXML
    void APTitleBarOnMousePressed(MouseEvent event) {

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNCustomClockOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNCustomClockOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNCustomClockOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNExportExcelOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNExportExcelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNExportExcelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNMinimizeOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNMinimizeOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNMinimizeOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNMotivationsOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNMotivationsOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNMotivationsOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNNewEntryOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNNewEntryOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNNewEntryOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNRestartClockOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNRestartClockOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNRestartClockOnMouseExited(MouseEvent event) {

    }

    @FXML
    void IMGThemeOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void IMGThemeOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void IMGThemeOnMouseExited(MouseEvent event) {

    }

}
