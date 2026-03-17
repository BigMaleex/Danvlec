package controllers;

import connections.Clock;
import connections.CloudEntriesManager;
import connections.Entry;
import files.ClockFile;
import files.EntriesManager;
import files.ExcelExporter;
import files.Preferences;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import logical.CalculateTimeElapsed;
import logical.ValidateOutputs;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.DrawClocks;
import stylebuilder.StyleBuilder;
import user.UserClock;
import user.UserData;
import user.UserPreferences;
import utilities.*;

import java.time.LocalDateTime;

public class MainWindowController extends ConfigureInitializeStyles {

    //Objetos
    ScreenManager sm = ScreenManager.getInstance();
    Timeline timeline;

    //Variables
    private static boolean isDarkMode, haveAnyMotivation;
    private int xOffset, yOffset;
    private static LocalDateTime dateOfClock;
    private static PartOfDay currentPartOfDay = PartOfDay.DEFAULT;
    private static String phrase;

    //Relojes
    private DrawClocks yearClock;
    private DrawClocks monthClock;
    private DrawClocks dayClock;
    private DrawClocks hourClock;
    private DrawClocks minuteClock;
    private DrawClocks secondClock;

    private DrawClocks [] clocks;

    public enum PartOfDay {

        MORNING, AFTERNOON, NIGHT, DEFAULT

    }

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

    //Fuente
    private static String titleFontColor;
    private static String contentFontColor;

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
    private HBox HBXYearsAndMonthsAndDays;

    @FXML
    private HBox HBXHoursAndMinutesAndSeconds;

    public void loadData(){

        dateOfClock = UserClock.getDate();
        haveAnyMotivation = UserData.getMotivation() != null && !UserData.getMotivation().isBlank();

        setTFLTextWithOneColor(UserClock.getTitleClock() == null || UserClock.getTitleClock().isBlank() ? "Añade un título para que tengas un mejor control del progreso de tu proceso" : UserClock.getTitleClock(), Styles.px16, titleFontColor, TFLTitleClock);

        setTFLTextWithOneColor(haveAnyMotivation ? UserData.getMotivation() : "Añade una motivación para que puedas tener una ancla para seguir avanzando", Styles.px16, contentFontColor, TFLMotivations);

        DrawClocks.updateColor(

                clocks,
                //Colores de la barra
                new String [] {

                        UserPreferences.getYearClockColor(false),
                        UserPreferences.getMonthClockColor(false),
                        UserPreferences.getDayClockColor(false),
                        UserPreferences.getHourClockColor(false),
                        UserPreferences.getMinuteClockColor(false),
                        UserPreferences.getSecondClockColor(false)

                },

                //Colores de fondo
                new String [] {

                        UserPreferences.getBackgroundYearClockColor(false),
                        UserPreferences.getBackgroundMonthClockColor(false),
                        UserPreferences.getBackgroundDayClockColor(false),
                        UserPreferences.getBackgroundHourClockColor(false),
                        UserPreferences.getBackgroundMinuteClockColor(false),
                        UserPreferences.getBackgroundSecondClockColor(false)

                }

        );

    }

    public void initializeAnimation(){

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

            updateClocks();

            if(!ValidateOutputs.isTheSamePartOfDayIfNotBuildGreetingTextLabel(currentPartOfDay, TFLGreeting)) currentPartOfDay = ValidateOutputs.getOrSetCurrentPartOfDay();

        }));

        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();

    }

    public void stopAnimation(){

        timeline.stop();

    }

    private void updateClocks (){

        DrawClocks.updateAll(CalculateTimeElapsed.timeElapsed(dateOfClock), clocks);

    }

    @FXML
    public void initialize(){

        phrase = Phrases.getPhrase();

        LBLTitleBar.setText(Titles.MainWindow);

        if(UserData.haveAnyAccount()){

            Entry entry = new Entry();
            LBLAllEntriesCount.setText(entry.getAllEntriesCount() +"");
            LBLMonthlyEntriesCount.setText(entry.getMonthEntriesCount()+"");
            LBLWeeklyEntriesCount.setText(entry.getWeekEntriesCount() +"");

        }else{

            EntriesManager  manager = new EntriesManager();

            LBLAllEntriesCount.setText(manager.getTotalCount() +"");
            LBLMonthlyEntriesCount.setText(manager.getMonthCount()+"");
            LBLWeeklyEntriesCount.setText(manager.getWeekCount()+"");

        }

        Images.clearImages();

        isDarkMode = UserPreferences.getUserThemeMode();
        dateOfClock = UserClock.getDate();
        haveAnyMotivation = UserData.getMotivation() != null && !UserData.getMotivation().isBlank();

        removeTheOpacityFromTheImageViews(IMGCustomClockHover, IMGExportExcelHover, IMGMotivationsHover, IMGRestartClockHover, IMGNewEntryHover, IMGThemeHover, IMGTheme);

        LBLMotivations.setText(haveAnyMotivation ? "Modifica tu motivación para mejorar" : "Añade tu motivación para mejorar");

        yearClock = new DrawClocks(DrawClocks.ClockUnitType.YEAR,UserPreferences.getYearClockColor(false), UserPreferences.getBackgroundYearClockColor(false), 200);
        monthClock = new DrawClocks(DrawClocks.ClockUnitType.MONTH,UserPreferences.getMonthClockColor(false), UserPreferences.getBackgroundMonthClockColor(false), 200);
        dayClock = new DrawClocks(DrawClocks.ClockUnitType.DAY,UserPreferences.getDayClockColor(false), UserPreferences.getBackgroundDayClockColor(false), 200);
        hourClock = new DrawClocks(DrawClocks.ClockUnitType.HOUR,UserPreferences.getHourClockColor(false), UserPreferences.getBackgroundHourClockColor(false), 200);
        minuteClock = new DrawClocks(DrawClocks.ClockUnitType.MINUTE,UserPreferences.getMinuteClockColor(false), UserPreferences.getBackgroundMinuteClockColor(false), 200);
        secondClock = new DrawClocks(DrawClocks.ClockUnitType.SECOND,UserPreferences.getSecondClockColor(false), UserPreferences.getBackgroundSecondClockColor(false), 200);

        clocks = new DrawClocks[] {yearClock, monthClock, dayClock, hourClock, minuteClock, secondClock};

        //Añadirlos al HBox

        HBXYearsAndMonthsAndDays.getChildren().clear();
        HBXHoursAndMinutesAndSeconds.getChildren().clear();

        for(int i = 0; i<6; i++){

            if(i < 3){

                //HBox superior
                if(!HBXYearsAndMonthsAndDays.getChildren().contains(clocks[i])){

                    HBXYearsAndMonthsAndDays.getChildren().add(clocks[i]);

                }

            }else{

                //HBox inferior
                if(!HBXHoursAndMinutesAndSeconds.getChildren().contains(clocks[i])){

                    HBXHoursAndMinutesAndSeconds.getChildren().add(clocks[i]);

                }

            }

        }

        changeTheme();

        setTFLTextWithOneColor(UserClock.getTitleClock() == null || UserClock.getTitleClock().isBlank() ? "Añade un título para que tengas un mejor control del progreso de tu proceso" : UserClock.getTitleClock(), Styles.px16, titleFontColor, TFLTitleClock);

        setTFLTextWithOneColor(haveAnyMotivation ? UserData.getMotivation() : "Añade una motivación para que puedas tener una ancla para seguir avanzando", Styles.px16, contentFontColor, TFLMotivations);

        setTFLTextWithOneColor(phrase,Styles.px16, titleFontColor,TFLPhrase);

    }

    private void changeTheme(){

        StyleBuilder.setAnchorPaneClass(APMain);

        changeColors();

        ConfigureNodes.configureNodesForMainWindowController(APTitleBar,BTNClose,BTNCustomClock,BTNExportExcel,BTNMinimize, BTNMotivations, BTNNewEntry, BTNRestartClock, IMGAllEntries, IMGCustomClock,IMGCustomClockHover, IMGExportExcel, IMGExportExcelHover, IMGMonthlyEntries,IMGMotivations,IMGMotivationsHover,IMGNewEntry,IMGNewEntryHover,IMGPhrase,IMGRestartClock,IMGRestartClockHover,IMGTheme,IMGThemeHover,IMGThemeInit, IMGWeeklyEntries,LBLCustomClock,LBLExportExcel,LBLMotivations,LBLNewEntry,LBLRestartClock, LBLTitleBar,SPTheme,isDarkMode, haveAnyMotivation);


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

        //Color de los títulos
        titleFontColor = Colors.getColor("title-font-color", isDarkMode);

        //Color del contenido
        contentFontColor = Colors.getColor("content-font-color", isDarkMode);

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
    void BTNCustomClockOnMouseClicked(MouseEvent event) {

        sm.openDynamicPopup(

                FileConstants.PopupCustomClockFXML,
                "Personaliza tu reloj",
                controller -> {}

        );

    }

    @FXML
    void BTNCustomClockOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackground, principalButtonBackgroundHover,
                principalButtonBorder, principalButtonBorderHover,
                principalButtonFontColor, principalButtonFontColorHover,
                BTNCustomClock,
                IMGCustomClock, IMGCustomClockHover,
                LBLCustomClock

        );

    }

    @FXML
    void BTNCustomClockOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackgroundHover, principalButtonBackground,
                principalButtonBorderHover, principalButtonBorder,
                principalButtonFontColorHover, principalButtonFontColor,
                BTNCustomClock,
                IMGCustomClockHover, IMGCustomClock,
                LBLCustomClock

        );

    }

    @FXML
    void BTNExportExcelOnMouseClicked(MouseEvent event) {

        try {

            ExcelExporter exporter = new ExcelExporter();

            if(UserData.haveAnyAccount()){

                CloudEntriesManager mgr = new CloudEntriesManager();

                exporter.exportFromCloud(mgr.getAllEntries());

            }else{

                EntriesManager mgr = new EntriesManager();
                exporter.exportFromLocal(mgr.getAllEntries());

            }

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    @FXML
    void BTNExportExcelOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover,
                BTNExportExcel,
                IMGExportExcel, IMGExportExcelHover,
                LBLExportExcel

        );

    }

    @FXML
    void BTNExportExcelOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder,
                secondaryButtonFontColorHover, secondaryButtonFontColor,
                BTNExportExcel,
                IMGExportExcelHover, IMGExportExcel,
                LBLExportExcel

        );

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
    void BTNMotivationsOnMouseClicked(MouseEvent event) {

        sm.openDynamicPopup(

                FileConstants.PopupMotivationsFXML,
                "Motivaciones",
                controller -> {}

        );

    }

    @FXML
    void BTNMotivationsOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackground, principalButtonBackgroundHover,
                principalButtonBorder, principalButtonBorderHover,
                principalButtonFontColor, principalButtonFontColorHover,
                BTNMotivations,
                IMGMotivations, IMGMotivationsHover,
                LBLMotivations

        );

    }

    @FXML
    void BTNMotivationsOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackgroundHover, principalButtonBackground,
                principalButtonBorderHover, principalButtonBorder,
                principalButtonFontColorHover, principalButtonFontColor,
                BTNMotivations,
                IMGMotivationsHover, IMGMotivations,
                LBLMotivations

        );

    }

    @FXML
    void BTNNewEntryOnMouseClicked(MouseEvent event) {

        stopAnimation();
        NewEntryController controller = (NewEntryController) sm.getController(FileConstants.NewEntry);
        controller.initialize();

        sm.setScreenAtPosition(FileConstants.NewEntry, Titles.NewEntry);

    }

    @FXML
    void BTNNewEntryOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackground, principalButtonBackgroundHover,
                principalButtonBorder, principalButtonBorderHover,
                principalButtonFontColor, principalButtonFontColorHover,
                BTNNewEntry,
                IMGNewEntry, IMGNewEntryHover,
                LBLNewEntry

        );

    }

    @FXML
    void BTNNewEntryOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                principalButtonBackgroundHover, principalButtonBackground,
                principalButtonBorderHover, principalButtonBorder,
                principalButtonFontColorHover, principalButtonFontColor,
                BTNNewEntry,
                IMGNewEntryHover, IMGNewEntry,
                LBLNewEntry

        );

    }

    @FXML
    void BTNRestartClockOnMouseClicked(MouseEvent event) {

        stopAnimation();

        dateOfClock = LocalDateTime.now();

        UserClock.setDate(dateOfClock);

        if(UserData.haveAnyAccount()){

            Clock clock = new Clock();
            clock.resetClock();

        }else{

            ClockFile file = new ClockFile();

            file.createOrUpdateFile();

        }

        initializeAnimation();

    }

    @FXML
    void BTNRestartClockOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover,
                BTNRestartClock,
                IMGRestartClock, IMGRestartClockHover,
                LBLRestartClock

        );

    }

    @FXML
    void BTNRestartClockOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabel(

                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder,
                secondaryButtonFontColorHover, secondaryButtonFontColor,
                BTNRestartClock,
                IMGRestartClockHover, IMGRestartClock,
                LBLRestartClock

        );

    }

    @FXML
    void IMGThemeOnMouseClicked(MouseEvent event) {

        stopAnimation();

        isDarkMode = !isDarkMode;

        Preferences preferences = new Preferences();
        preferences.toggleTheme();

        changeTheme();

        setTFLTextWithOneColor(UserClock.getTitleClock() == null || UserClock.getTitleClock().isBlank() ? "Añade un título para que tengas un mejor control del progreso de tu proceso" : UserClock.getTitleClock(), Styles.px16, titleFontColor, TFLTitleClock);

        setTFLTextWithOneColor(haveAnyMotivation ? UserData.getMotivation() : "Añade una motivación para que puedas tener una ancla para seguir avanzando", Styles.px16, contentFontColor, TFLMotivations);

        setTFLTextWithOneColor(phrase,Styles.px16, titleFontColor,TFLPhrase);

        currentPartOfDay = PartOfDay.DEFAULT;

        ValidateOutputs.isTheSamePartOfDayIfNotBuildGreetingTextLabel(currentPartOfDay, TFLGreeting);

        DrawClocks.updateColor(

                clocks,
                //Colores de la barra
                new String [] {

                        UserPreferences.getYearClockColor(false),
                        UserPreferences.getMonthClockColor(false),
                        UserPreferences.getDayClockColor(false),
                        UserPreferences.getHourClockColor(false),
                        UserPreferences.getMinuteClockColor(false),
                        UserPreferences.getSecondClockColor(false)

                },

                //Colores de fondo
                new String [] {

                        UserPreferences.getBackgroundYearClockColor(false),
                        UserPreferences.getBackgroundMonthClockColor(false),
                        UserPreferences.getBackgroundDayClockColor(false),
                        UserPreferences.getBackgroundHourClockColor(false),
                        UserPreferences.getBackgroundMinuteClockColor(false),
                        UserPreferences.getBackgroundSecondClockColor(false)

                }

        );

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

        initializeAnimation();

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

    private void setTFLTextWithOneColor(String input, String size, String color, TextFlow TFL) {

        TFL.getChildren().clear();

        Text text = new Text(input);
        text.setStyle(Styles.fontFamily + Styles.fontSize + size + Styles.end);
        text.setFill(Color.web(color));

        text.wrappingWidthProperty().bind(TFL.widthProperty().subtract(5));

        TFL.getChildren().add(text);

        TFL.setMaxHeight(Region.USE_PREF_SIZE);

    }

    public void updateMotivation(){

        haveAnyMotivation = UserData.getMotivation() != null && !UserData.getMotivation().isBlank();

        LBLMotivations.setText(haveAnyMotivation ? "Modifica tu motivación para mejorar" : "Añade tu motivación para mejorar");

        changeTheme();

        setTFLTextWithOneColor(haveAnyMotivation ? UserData.getMotivation() : "Añade una motivación para que puedas tener una ancla para seguir avanzando", Styles.px16, contentFontColor, TFLMotivations);

    }

    public void updateClockColors(){

        stopAnimation();

        DrawClocks.updateColor(

                clocks,
                //Colores de la barra
                new String [] {

                        UserPreferences.getYearClockColor(false),
                        UserPreferences.getMonthClockColor(false),
                        UserPreferences.getDayClockColor(false),
                        UserPreferences.getHourClockColor(false),
                        UserPreferences.getMinuteClockColor(false),
                        UserPreferences.getSecondClockColor(false)

                },

                //Colores de fondo
                new String [] {

                        UserPreferences.getBackgroundYearClockColor(false),
                        UserPreferences.getBackgroundMonthClockColor(false),
                        UserPreferences.getBackgroundDayClockColor(false),
                        UserPreferences.getBackgroundHourClockColor(false),
                        UserPreferences.getBackgroundMinuteClockColor(false),
                        UserPreferences.getBackgroundSecondClockColor(false)

                }

        );

        initializeAnimation();

    }

}
