package controllers;

import com.sun.tools.javac.Main;
import controls.EmotionToggleButton;
import controls.EmotionalNodes;
import controls.EmotionalScoreAdvice;
import controls.ScoreEmotionSlider;
import files.Preferences;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import logical.ValidateFormInputs;
import messagebuilder.Complements;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.*;

import java.util.ArrayList;

public class NewEntryController extends ConfigureInitializeStyles {

    public enum Step {

        First, Second, Third, Fourth

    }

    //Objetos
    ScreenManager sm = ScreenManager.getInstance();

    //variables
    private static Step currentStep;
    private static boolean isDarkMode, allConditionsMet = false, pastAllConditionsMet = true, TXTContextWhatHappeningPastState = false, TXTContextWhatDidYouFeelPastState = false, TXTSummaryAdditionalNotesPastState = false;

    private int xOffset, yOffset;
    private static boolean [] emotionsSelected = new boolean [112];

    //PseudoClases
    private static final PseudoClass LBLErr = PseudoClass.getPseudoClass("Error");
    private static final PseudoClass active = PseudoClass.getPseudoClass("Active");
    private static final PseudoClass past = PseudoClass.getPseudoClass("Past");

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

    //Botón desactivado
    private static String buttonBackgroundDisabled;
    private static String buttonBorderDisabled;
    private static String buttonFontColorDisabled;

    //Botón de emociones
    private static String backgroundEmotionalToggleButton;
    private static String borderEmotionalToggleButton;
    private static String fontColorEmotionalToggleButton;
    private static String backgroundHoverEmotionalToggleButton;
    private static String borderHoverEmotionalToggleButton;
    private static String fontColorHoverEmotionalToggleButton;

    @FXML
    private AnchorPane APMain;

    @FXML
    private AnchorPane APTitleBar;

    @FXML
    private Button BTNClose;

    @FXML
    private Button BTNMinimize;

    @FXML
    private Button BTNNext;

    @FXML
    private Button BTNPrevious;

    @FXML
    private GridPane GPNEmotionsAnger;

    @FXML
    private GridPane GPNEmotionsDisgust;

    @FXML
    private GridPane GPNEmotionsFear;

    @FXML
    private GridPane GPNEmotionsHappy;

    @FXML
    private GridPane GPNEmotionsSad;

    @FXML
    private GridPane GPNEmotionsSurprised;

    @FXML
    private ImageView IMGButtonNext;

    @FXML
    private ImageView IMGButtonNextHover;

    @FXML
    private ImageView IMGButtonPrevious;

    @FXML
    private ImageView IMGButtonPreviousHover;

    @FXML
    private ImageView IMGContextIconSelectStackPane;

    @FXML
    private ImageView IMGContextWhatDidYouFeel;

    @FXML
    private ImageView IMGContextWhatWasHappening;

    @FXML
    private ImageView IMGEmotionScoreIconSelectStackPane;

    @FXML
    private ImageView IMGEmotionsIconSelectStackPane;

    @FXML
    private ImageView IMGSummaryAdditionalNotes;

    @FXML
    private ImageView IMGSummaryContext;

    @FXML
    private ImageView IMGSummaryEmotions;

    @FXML
    private ImageView IMGSummaryFeel;

    @FXML
    private ImageView IMGSummaryGeneralState;

    @FXML
    private ImageView IMGSummaryIconSelectStackPane;

    @FXML
    private ImageView IMGTheme;

    @FXML
    private ImageView IMGThemeHover;

    @FXML
    private ImageView IMGThemeInit;

    @FXML
    private Label LBLButtonPrevious;

    @FXML
    private Label LBLContextCountMaxCharsWhatDidYouFeel;

    @FXML
    private Label LBLContextCountMaxCharsWhatWasHappening;

    @FXML
    private Label LBLContextStep;

    @FXML
    private Label LBLContextWhatDidYouFeel;

    @FXML
    private Label LBLContextWhatWasHappening;

    @FXML
    private Label LBLEmotionsStep;

    @FXML
    private Label LBLGeneralStateCount;

    @FXML
    private Label LBLNext;

    @FXML
    private Label LBLScoreEmotionsStep;

    @FXML
    private Label LBLSummaryAdditionalNotes;

    @FXML
    private Label LBLSummaryCountMaxCharsAdditionalNotes;

    @FXML
    private Label LBLSummaryEmotions;

    @FXML
    private Label LBLSummaryGeneralState;

    @FXML
    private Label LBLSummaryStep;

    @FXML
    private Label LBLTitleBar;

    @FXML
    private Slider SLDGeneralState;

    @FXML
    private StackPane SPContext;

    @FXML
    private StackPane SPContextStep;

    @FXML
    private StackPane SPEmotions;

    @FXML
    private StackPane SPEmotionsStep;

    @FXML
    private Separator SPRFirstStep;

    @FXML
    private Separator SPRSecondStep;

    @FXML
    private Separator SPRThirdStep;

    @FXML
    private StackPane SPScoreEmotions;

    @FXML
    private StackPane SPScoreEmotionsAnger;

    @FXML
    private StackPane SPScoreEmotionsDisgust;

    @FXML
    private StackPane SPScoreEmotionsFear;

    @FXML
    private StackPane SPScoreEmotionsHappy;

    @FXML
    private StackPane SPScoreEmotionsSad;

    @FXML
    private StackPane SPScoreEmotionsStep;

    @FXML
    private StackPane SPScoreEmotionsSurprised;

    @FXML
    private StackPane SPSummary;

    @FXML
    private StackPane SPSummaryStep;

    @FXML
    private StackPane SPTheme;

    @FXML
    private TextFlow TFLSummaryContext;

    @FXML
    private TextFlow TFLSummaryFeel;

    @FXML
    private TextArea TXTContextWhatDidYouFeel;

    @FXML
    private TextArea TXTContextWhatHappening;

    @FXML
    private TextArea TXTSummaryAdditionalNotes;

    @FXML
    private VBox VBXGeneralState;

    @FXML
    private VBox VBXScoreEmotionsAnger;

    @FXML
    private VBox VBXScoreEmotionsDisgust;

    @FXML
    private VBox VBXScoreEmotionsFear;

    @FXML
    private VBox VBXScoreEmotionsHappy;

    @FXML
    private VBox VBXScoreEmotionsSad;

    @FXML
    private VBox VBXScoreEmotionsSurprised;

    @FXML
    private VBox VBXSummaryEmotions;

    private EmotionToggleButton[] toggleButtons;

    private ArrayList<ScoreEmotionSlider> emotionSliders = new ArrayList<>();

    @FXML
    public void initialize () {

        removeTheOpacityFromTheImageViews(IMGButtonNextHover, IMGButtonPreviousHover, IMGThemeHover, IMGTheme);

        LBLGeneralStateCount.textProperty().bind(

                Bindings.createStringBinding(

                        () -> (int) SLDGeneralState.getValue() + "/10",
                        SLDGeneralState.valueProperty()

                )

        );

        allConditionsMet = false;

        pastAllConditionsMet = true;

        LBLTitleBar.setText(Titles.NewEntry);

        isDarkMode = UserPreferences.getUserThemeMode();

        currentStep = Step.First;

        EmotionalNodes buttons = new EmotionalNodes();

        toggleButtons = buttons.getEmotionNodes();

        GPNEmotionsFear.getChildren().clear();
        GPNEmotionsHappy.getChildren().clear();
        GPNEmotionsAnger.getChildren().clear();
        GPNEmotionsDisgust.getChildren().clear();
        GPNEmotionsSurprised.getChildren().clear();
        GPNEmotionsSad.getChildren().clear();

        GPNEmotionsFear.setHgap(10);
        GPNEmotionsFear.setVgap(10);
        GPNEmotionsFear.setPadding(new Insets(10));

        GPNEmotionsHappy.setHgap(10);
        GPNEmotionsHappy.setVgap(10);
        GPNEmotionsHappy.setPadding(new Insets(10));

        GPNEmotionsAnger.setHgap(10);
        GPNEmotionsAnger.setVgap(10);
        GPNEmotionsAnger.setPadding(new Insets(10));

        GPNEmotionsDisgust.setHgap(10);
        GPNEmotionsDisgust.setVgap(10);
        GPNEmotionsDisgust.setPadding(new Insets(10));

        GPNEmotionsSurprised.setHgap(10);
        GPNEmotionsSurprised.setVgap(10);
        GPNEmotionsSurprised.setPadding(new Insets(10));

        GPNEmotionsSad.setHgap(10);
        GPNEmotionsSad.setVgap(10);
        GPNEmotionsSad.setPadding(new Insets(10));

        int [] maxPosArray = buttons.getEmotionMaxPos();

        for(boolean emotion : emotionsSelected){

            emotion = false;

        }

        int [] maxHPos = {0,0,0,0,0,0};
        int [] maxVPos = {0,0,0,0,0,0};

        for(int i =0; i < toggleButtons.length; i++) {

            if(i < maxPosArray[0]){

                if(!GPNEmotionsHappy.getChildren().contains(toggleButtons[i])){

                    GPNEmotionsHappy.add(toggleButtons[i], maxHPos[0], maxVPos[0]);

                    maxHPos[0]++;

                    if(maxHPos[0] == 3){

                        maxHPos[0] = 0;
                        maxVPos[0]++;

                    }

                }

            }

            else if(i < maxPosArray[1]){

                if(!GPNEmotionsSurprised.getChildren().contains(toggleButtons[i])){

                    GPNEmotionsSurprised.add(toggleButtons[i], maxHPos[1], maxVPos[1]);

                    maxHPos[1]++;

                    if(maxHPos[1] == 3){

                        maxHPos[1] = 0;
                        maxVPos[1]++;

                    }

                }

            }
            else if(i < maxPosArray[2]){

                if(!GPNEmotionsFear.getChildren().contains(toggleButtons[i])){

                    GPNEmotionsFear.add(toggleButtons[i], maxHPos[2], maxVPos[2]);

                    maxHPos[2]++;

                    if(maxHPos[2] == 3){

                        maxHPos[2] = 0;
                        maxVPos[2]++;

                    }

                }

            }
            else if(i < maxPosArray[3]){

                if(!GPNEmotionsAnger.getChildren().contains(toggleButtons[i])){

                    GPNEmotionsAnger.add(toggleButtons[i], maxHPos[3], maxVPos[3]);

                    maxHPos[3]++;

                    if(maxHPos[3] == 3){

                        maxHPos[3] = 0;
                        maxVPos[3]++;

                    }

                }

            }
            else if(i < maxPosArray[4]){

                if(!GPNEmotionsDisgust.getChildren().contains(toggleButtons[i])){

                    GPNEmotionsDisgust.add(toggleButtons[i], maxHPos[4], maxVPos[4]);

                    maxHPos[4]++;

                    if(maxHPos[4] == 3){

                        maxHPos[4] = 0;
                        maxVPos[4]++;

                    }

                }

            }
            else if(i < maxPosArray[5]){

                if(!GPNEmotionsSad.getChildren().contains(toggleButtons[i])){

                    GPNEmotionsSad.add(toggleButtons[i], maxHPos[5], maxVPos[5]);

                    maxHPos[5]++;

                    if(maxHPos[5] == 3){

                        maxHPos[5] = 0;
                        maxVPos[5]++;

                    }

                }

            }

        }

        for(ToggleButton button : toggleButtons){

           button.setOnMouseEntered( e-> {

                if(!button.isSelected()){

                    StyleBuilder.animateButtonColors(

                       button,
                       backgroundEmotionalToggleButton, backgroundHoverEmotionalToggleButton,
                       borderEmotionalToggleButton, borderHoverEmotionalToggleButton,
                       fontColorEmotionalToggleButton, fontColorHoverEmotionalToggleButton

                    );

                }

           });

           button.setOnMouseExited( l-> {

                       if (!button.isSelected()) {

                           StyleBuilder.animateButtonColors(

                                   button,
                                   backgroundHoverEmotionalToggleButton, backgroundEmotionalToggleButton,
                                   borderHoverEmotionalToggleButton, borderEmotionalToggleButton,
                                   fontColorHoverEmotionalToggleButton, fontColorEmotionalToggleButton

                           );

                       }

            }

           );

        }

        linkVisiblePropertyWithManagedProperty(SPContext, SPEmotions, SPScoreEmotions, SPSummary, SPScoreEmotionsHappy, SPScoreEmotionsSurprised, SPScoreEmotionsFear, SPScoreEmotionsAnger, SPScoreEmotionsDisgust, SPScoreEmotionsSad);

        StyleBuilder.clearControls(TXTContextWhatDidYouFeel, TXTContextWhatHappening, TXTSummaryAdditionalNotes);

        TXTContextWhatDidYouFeel.textProperty().addListener((obs, oldVal, newVal) ->{

            TXTContextWhatDidYouFeelPastState = isValidLength(LBLContextWhatDidYouFeel, LBLContextCountMaxCharsWhatDidYouFeel, TXTContextWhatDidYouFeel, TXTContextWhatDidYouFeelPastState);

            validateFields();

        });

        TXTContextWhatHappening.textProperty().addListener((obs, oldVal, newVal) ->{

            TXTContextWhatHappeningPastState = isValidLength(LBLContextWhatWasHappening, LBLContextCountMaxCharsWhatWasHappening, TXTContextWhatHappening, TXTContextWhatHappeningPastState);

            validateFields();

        });

        TXTSummaryAdditionalNotes.textProperty().addListener((obs, oldVal, newVal) ->{

            TXTSummaryAdditionalNotesPastState = isValidLength(LBLSummaryAdditionalNotes, LBLSummaryCountMaxCharsAdditionalNotes, TXTSummaryAdditionalNotes, TXTSummaryAdditionalNotesPastState);

            validateFields();

        });

        changeTheme();

        for(ToggleButton button : toggleButtons){

            button.selectedProperty().addListener((obs, oldVal, newVal) ->{

                validateFields();

            });

        }

    }

    private void changeTheme(){

        changeColors();

        StyleBuilder.setAnchorPaneClass(APMain);

        changeStep();

        ConfigureNodes.configureNodesForNewEntryController(APTitleBar, BTNClose, BTNMinimize,BTNNext, BTNPrevious, IMGButtonNext, IMGButtonNextHover, IMGButtonPrevious, IMGButtonPreviousHover,IMGContextWhatDidYouFeel, IMGContextWhatWasHappening, IMGSummaryAdditionalNotes, IMGTheme, IMGThemeHover,IMGThemeInit,LBLButtonPrevious,LBLNext,LBLTitleBar,SPTheme, toggleButtons, IMGSummaryContext, IMGSummaryFeel, IMGSummaryEmotions, IMGSummaryGeneralState, isDarkMode, allConditionsMet);

    }

    private void changeColors(){

        //Botón desactivado
        buttonBackgroundDisabled = Colors.getColor("button-background-disabled", isDarkMode);
        buttonBorderDisabled = Colors.getColor("button-border-disabled", isDarkMode);
        buttonFontColorDisabled = Colors.getColor("button-font-color-disabled", isDarkMode);

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

        //Botón de emociones
        backgroundEmotionalToggleButton = Colors.getColor("background-emotional-toggle-button", isDarkMode);
        borderEmotionalToggleButton = Colors.getColor("border-emotional-toggle-button", isDarkMode);
        fontColorEmotionalToggleButton = Colors.getColor("font-color-emotional-toggle-button", isDarkMode);
        backgroundHoverEmotionalToggleButton = Colors.getColor("background-hover-emotional-toggle-button", isDarkMode);
        borderHoverEmotionalToggleButton = Colors.getColor("border-hover-emotional-toggle-button", isDarkMode);
        fontColorHoverEmotionalToggleButton = Colors.getColor("font-color-hover-emotional-toggle-button", isDarkMode);


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
    void BTNNextOnMouseClicked(MouseEvent event) {

        if(allConditionsMet){

            switch(currentStep){

                case First -> {

                    currentStep = Step.Second;
                    changeStep();

                }

                case Second -> {

                    currentStep = Step.Third;
                    changeStep();

                }

                case Third -> {

                    currentStep = Step.Fourth;
                    changeStep();

                }

                case Fourth -> {

                    System.out.println("Se entró al cuatro proceso");

                    if(ValidateFormInputs.validateInputsFromNewEntryController(TXTContextWhatHappening.getText(), TXTContextWhatDidYouFeel.getText(), TXTSummaryAdditionalNotes.getText(), toggleButtons, emotionSliders.toArray(new ScoreEmotionSlider[emotionSliders.size()]), (int) SLDGeneralState.getValue())){

                        MainWindowController controller = (MainWindowController) sm.getController(FileConstants.MainWindow);
                        controller.initializeAnimation();
                        controller.initialize();

                        sm.setScreenAtPosition(FileConstants.MainWindow, Titles.MainWindow);

                    }

                }

                default -> {

                    System.out.println("La opción " + currentStep +  "aún no ha sido configurada");

                }

        }

        }

    }

    @FXML
    void BTNNextOnMouseEntered(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    principalButtonBackground, principalButtonBackgroundHover,
                    principalButtonBorder, principalButtonBorderHover,
                    principalButtonFontColor, principalButtonFontColorHover,
                    BTNNext, IMGButtonNext, IMGButtonNextHover, LBLNext

            );

        }

    }

    @FXML
    void BTNNextOnMouseExited(MouseEvent event) {

        if(allConditionsMet){

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    principalButtonBackgroundHover, principalButtonBackground,
                    principalButtonBorderHover, principalButtonBorder,
                    principalButtonFontColorHover, principalButtonFontColor,
                    BTNNext, IMGButtonNextHover, IMGButtonNext, LBLNext

            );

        }

    }

    @FXML
    void BTNPreviousOnMouseClicked(MouseEvent event) {

        switch(currentStep){

            case First -> {

                MainWindowController controller = (MainWindowController) sm.getController(FileConstants.MainWindow);
                controller.initialize();
                controller.initializeAnimation();

                sm.setScreenAtPosition(FileConstants.MainWindow, Titles.MainWindow);

            }

            case Second -> {

                currentStep = Step.First;
                changeStep();

            }

            case Third -> {

                currentStep = Step.Second;
                changeStep();

            }

            case Fourth -> {

                currentStep = Step.Third;
                changeStep();

            }

            default -> {

                System.out.println("La opción " + currentStep +  "aún no ha sido configurada");

            }

        }

    }

    @FXML
    void BTNPreviousOnMouseEntered(MouseEvent event) {

           StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    secondaryButtonBackground, secondaryButtonBackgroundHover,
                    secondaryButtonBorder, secondaryButtonBorderHover,
                    secondaryButtonFontColor, secondaryButtonFontColorHover,
                    BTNPrevious, IMGButtonPrevious, IMGButtonPreviousHover, LBLButtonPrevious

           );

    }

    @FXML
    void BTNPreviousOnMouseExited(MouseEvent event) {

            StyleBuilder.animateButtonColorsWithImagesAndLabel(

                    secondaryButtonBackgroundHover, secondaryButtonBackground,
                    secondaryButtonBorderHover, secondaryButtonBorder,
                    secondaryButtonFontColorHover, secondaryButtonFontColor,
                    BTNPrevious, IMGButtonPreviousHover, IMGButtonPrevious, LBLButtonPrevious

            );

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

        for(ToggleButton button : toggleButtons){

            if(button.isSelected()){

                applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, button);

            }

        }

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

    private void changeStep(){

        switch(currentStep){

            case First ->{

                SPContext.setVisible(currentStep == Step.First);
                SPEmotions.setVisible(currentStep == Step.Second);
                SPScoreEmotions.setVisible(currentStep == Step.Third);
                SPSummary.setVisible(currentStep == Step.Fourth);

                LBLNext.setText("Siguiente paso");
                LBLButtonPrevious.setText("Regresar");

                setImages(FileConstants.chatLeftActiveDm, FileConstants.chatLeftActiveLm, isDarkMode,IMGContextIconSelectStackPane);
                setImages(FileConstants.heartDm, FileConstants.heartLm, isDarkMode,IMGEmotionsIconSelectStackPane);
                setImages(FileConstants.lightningChargeDm, FileConstants.lightningChargeLm, isDarkMode,IMGEmotionScoreIconSelectStackPane);
                setImages(FileConstants.checkDm, FileConstants.checkLm, isDarkMode,IMGSummaryIconSelectStackPane);

                SPContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                SPEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                SPScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                SPSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                SPContextStep.pseudoClassStateChanged(past, false);
                SPEmotionsStep.pseudoClassStateChanged(past, false);
                SPScoreEmotionsStep.pseudoClassStateChanged(past, false);
                SPSummaryStep.pseudoClassStateChanged(past, false);

                LBLContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                LBLEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                LBLScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                LBLSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                validateFields();

            }

            case Second ->{

                SPContext.setVisible(currentStep == Step.First);
                SPEmotions.setVisible(currentStep == Step.Second);
                SPScoreEmotions.setVisible(currentStep == Step.Third);
                SPSummary.setVisible(currentStep == Step.Fourth);

                LBLNext.setText("Siguiente paso");
                LBLButtonPrevious.setText("Paso anterior");

                setImages(FileConstants.chatLeftPastDm, FileConstants.chatLeftPastLm, isDarkMode,IMGContextIconSelectStackPane);
                setImages(FileConstants.heartActiveDm, FileConstants.heartActiveLm, isDarkMode,IMGEmotionsIconSelectStackPane);
                setImages(FileConstants.lightningChargeDm, FileConstants.lightningChargeLm, isDarkMode,IMGEmotionScoreIconSelectStackPane);
                setImages(FileConstants.checkDm, FileConstants.checkLm, isDarkMode,IMGSummaryIconSelectStackPane);

                SPContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                SPEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                SPScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                SPSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                SPContextStep.pseudoClassStateChanged(past, true);
                SPEmotionsStep.pseudoClassStateChanged(past, false);
                SPScoreEmotionsStep.pseudoClassStateChanged(past, false);
                SPSummaryStep.pseudoClassStateChanged(past, false);

                LBLContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                LBLEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                LBLScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                LBLSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                validateFields();

            }

            case Third ->{

                SPContext.setVisible(currentStep == Step.First);
                SPEmotions.setVisible(currentStep == Step.Second);
                SPScoreEmotions.setVisible(currentStep == Step.Third);
                SPSummary.setVisible(currentStep == Step.Fourth);

                LBLNext.setText("Siguiente paso");
                LBLButtonPrevious.setText("Paso anterior");

                setImages(FileConstants.chatLeftPastDm, FileConstants.chatLeftPastLm, isDarkMode,IMGContextIconSelectStackPane);
                setImages(FileConstants.heartPastDm, FileConstants.heartPastLm, isDarkMode,IMGEmotionsIconSelectStackPane);
                setImages(FileConstants.lightningChargeActiveDm, FileConstants.lightningChargeActiveLm, isDarkMode,IMGEmotionScoreIconSelectStackPane);
                setImages(FileConstants.checkDm, FileConstants.checkLm, isDarkMode,IMGSummaryIconSelectStackPane);

                SPContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                SPEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                SPScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                SPSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                SPContextStep.pseudoClassStateChanged(past, true);
                SPEmotionsStep.pseudoClassStateChanged(past, true);
                SPScoreEmotionsStep.pseudoClassStateChanged(past, false);
                SPSummaryStep.pseudoClassStateChanged(past, false);

                LBLContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                LBLEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                LBLScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                LBLSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                VBXScoreEmotionsAnger.getChildren().clear();
                VBXScoreEmotionsDisgust.getChildren().clear();
                VBXScoreEmotionsFear.getChildren().clear();
                VBXScoreEmotionsHappy.getChildren().clear();
                VBXScoreEmotionsSad.getChildren().clear();
                VBXScoreEmotionsSurprised.getChildren().clear();

                emotionSliders.clear();

                SPScoreEmotionsHappy.setVisible(false);
                SPScoreEmotionsSurprised.setVisible(false);
                SPScoreEmotionsFear.setVisible(false);
                SPScoreEmotionsDisgust.setVisible(false);
                SPScoreEmotionsAnger.setVisible(false);
                SPScoreEmotionsSad.setVisible(false);


                EmotionalNodes sliders = new EmotionalNodes();

                int [] maxPosArray = sliders.getEmotionMaxPos();

                for(int i = 0; i < emotionsSelected.length; i++){

                    if(toggleButtons[i].isSelected()){

                        emotionsSelected[i] = true;

                        if(i < maxPosArray[0]){

                            SPScoreEmotionsHappy.setVisible(true);

                            ScoreEmotionSlider node = sliders.getEmotionSlider(i);
                            VBXScoreEmotionsHappy.getChildren().add(node);
                            emotionSliders.add(node);

                        }

                        else if(i < maxPosArray[1]){

                            SPScoreEmotionsSurprised.setVisible(true);

                            ScoreEmotionSlider node = sliders.getEmotionSlider(i);
                            VBXScoreEmotionsSurprised.getChildren().add(node);
                            emotionSliders.add(node);

                        }
                        else if(i < maxPosArray[2]){

                            SPScoreEmotionsFear.setVisible(true);

                            ScoreEmotionSlider node = sliders.getEmotionSlider(i);
                            VBXScoreEmotionsFear.getChildren().add(node);
                            emotionSliders.add(node);

                        }
                        else if(i < maxPosArray[3]){

                            SPScoreEmotionsAnger.setVisible(true);

                            ScoreEmotionSlider node = sliders.getEmotionSlider(i);
                            VBXScoreEmotionsAnger.getChildren().add(node);
                            emotionSliders.add(node);

                        }
                        else if(i < maxPosArray[4]){

                            SPScoreEmotionsDisgust.setVisible(true);

                            ScoreEmotionSlider node = sliders.getEmotionSlider(i);
                            VBXScoreEmotionsDisgust.getChildren().add(node);
                            emotionSliders.add(node);

                        }
                        else if(i < maxPosArray[5]) {

                            SPScoreEmotionsSad.setVisible(true);

                            ScoreEmotionSlider node = sliders.getEmotionSlider(i);
                            VBXScoreEmotionsSad.getChildren().add(node);
                            emotionSliders.add(node);

                        }
                    }else{

                        emotionsSelected[i] = false;

                    }

                }

                validateFields();

            }

            case Fourth -> {

                SPContext.setVisible(currentStep == Step.First);
                SPEmotions.setVisible(currentStep == Step.Second);
                SPScoreEmotions.setVisible(currentStep == Step.Third);
                SPSummary.setVisible(currentStep == Step.Fourth);

                LBLNext.setText("Enviar");
                LBLButtonPrevious.setText("Paso anterior");

                setImages(FileConstants.chatLeftPastDm, FileConstants.chatLeftPastLm, isDarkMode,IMGContextIconSelectStackPane);
                setImages(FileConstants.heartPastDm, FileConstants.heartPastLm, isDarkMode,IMGEmotionsIconSelectStackPane);
                setImages(FileConstants.lightningChargePastDm, FileConstants.lightningChargePastLm, isDarkMode,IMGEmotionScoreIconSelectStackPane);
                setImages(FileConstants.checkActiveDm, FileConstants.checkActiveLm, isDarkMode,IMGSummaryIconSelectStackPane);

                SPContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                SPEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                SPScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                SPSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                SPContextStep.pseudoClassStateChanged(past, true);
                SPEmotionsStep.pseudoClassStateChanged(past, true);
                SPScoreEmotionsStep.pseudoClassStateChanged(past, true);
                SPSummaryStep.pseudoClassStateChanged(past, false);

                LBLContextStep.pseudoClassStateChanged(active, currentStep == Step.First);
                LBLEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Second);
                LBLScoreEmotionsStep.pseudoClassStateChanged(active, currentStep == Step.Third);
                LBLSummaryStep.pseudoClassStateChanged(active, currentStep == Step.Fourth);

                buildTextFlow(TXTContextWhatHappening.getText(),TFLSummaryContext);
                buildTextFlow(TXTContextWhatDidYouFeel.getText(), TFLSummaryFeel);

                VBXSummaryEmotions.getChildren().clear();

                int posSlider = 0;
                int emotions = 0;

                for(boolean emotion : emotionsSelected){

                    emotion = false;

                }

                for(int i= 0; i < toggleButtons.length; i++){

                    if(toggleButtons[i].isSelected()){

                        emotionsSelected[i] = true;

                        VBXSummaryEmotions.getChildren().add(new EmotionalScoreAdvice(toggleButtons[i].getText(), emotionSliders.get(posSlider).getScore()));

                        posSlider++;
                        emotions++;

                    }

                }

                LBLSummaryEmotions.setText(emotions == 1 ? "Emoción" : ("Emociones (" + emotions + ")") );

                LBLSummaryGeneralState.setText((int) SLDGeneralState.getValue() + "/10");

            }

            default -> {

                System.out.println("La opción " + currentStep + " aún no ha sido configurada");

            }

        }

    }

    private void validateFields(){

        switch(currentStep){

            case First -> {

                allConditionsMet = (!TXTContextWhatHappening.getText().isBlank() && !TXTContextWhatDidYouFeel.getText().isBlank()) && (TXTContextWhatDidYouFeel.getText().length() < 4000 && TXTContextWhatHappening.getText().length() < 4000);

            }

            case Second -> {

                allConditionsMet = false;

                for(ToggleButton button : toggleButtons) {

                    if (button.isSelected()) {

                        allConditionsMet = true;
                        break;

                    }

                }

            }

            case Third -> {

                allConditionsMet = true;

            }

            case Fourth -> {

                allConditionsMet = TXTSummaryAdditionalNotes.getText().length() < 4000;

            }

            default -> {

                System.out.println("La opción " + currentStep + " aún no se ha configurado");

            }

        }

        if(allConditionsMet != pastAllConditionsMet){

            if(allConditionsMet){

                applyStylesToButtonsWithLabel(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNNext}, new Label [] {LBLNext});
                BTNNext.setOpacity(1);
                IMGButtonNext.setOpacity(1);

            }else{

                applyStylesToButtonsWithLabel(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNNext}, new Label [] {LBLNext});
                BTNNext.setOpacity(0.66);
                IMGButtonNext.setOpacity(0);

            }

            pastAllConditionsMet = allConditionsMet;

        }

    }

    private static boolean isValidLength(Label label1, Label label2, TextArea textArea, boolean pastStatus){

        label2.setText(textArea.getText().length() + "/4000");

        boolean actualStatus = textArea.getText().length() > 4000;

        if(actualStatus != pastStatus){

            if(textArea.getText().length() > 4000){

                label1.pseudoClassStateChanged(LBLErr, true);
                label2.pseudoClassStateChanged(LBLErr, true);
                textArea.getStyleClass().add("error");

            }else{

                label1.pseudoClassStateChanged(LBLErr, false);
                label2.pseudoClassStateChanged(LBLErr, false);
                textArea.getStyleClass().remove("error");

            }

        }

        return actualStatus;

    }

    private void buildTextFlow(String input, TextFlow TFL){

        TFL.getChildren().clear();

        TFL.getChildren().add(Complements.addStringFromTextList(input, Styles.px12, Colors.getColor("content-font-color", isDarkMode)));

    }

}
