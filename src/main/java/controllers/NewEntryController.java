package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class NewEntryController {

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
    private ImageView IMGSummaryAditionalNotes;

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
    private Label LBLContextCoutMaxCharsWhatDidYouFeel;

    @FXML
    private Label LBLContextCoutMaxCharsWhatWasHappening;

    @FXML
    private Label LBLContextStep;

    @FXML
    private Label LBLEmotionsStep;

    @FXML
    private Label LBLNext;

    @FXML
    private Label LBLScoreEmotionsStep;

    @FXML
    private Label LBLSummaryCoutMaxCharsAditionalNotes;

    @FXML
    private Label LBLSummaryStep;

    @FXML
    private Label LBLTitleBar;

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
    private StackPane SPSCoreEmotionsAnger;

    @FXML
    private StackPane SPSCoreEmotionsDisgust;

    @FXML
    private StackPane SPSCoreEmotionsFear;

    @FXML
    private StackPane SPSCoreEmotionsHappy;

    @FXML
    private StackPane SPSCoreEmotionsSad;

    @FXML
    private StackPane SPSCoreEmotionsSurprised;

    @FXML
    private StackPane SPScoreEmotions;

    @FXML
    private StackPane SPScoreEmotionsStep;

    @FXML
    private StackPane SPSummary;

    @FXML
    private StackPane SPSummaryStep;

    @FXML
    private StackPane SPTheme;

    @FXML
    private TextArea TXTContextWashappening;

    @FXML
    private TextArea TXTContextWhatDidYouFeel;

    @FXML
    private TextArea TXTSummaryAditionalNotes;

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

    private ToggleButton [] toggleButtons;
    private Label [] labels;
    private ImageView [] imageViews;

    @FXML
    public void initialize () {



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
    void BTNMinimizeOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNMinimizeOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNMinimizeOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNNextOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNNextOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNNextOnMouseExited(MouseEvent event) {

    }

    @FXML
    void BTNPreviousOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNPreviousOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNPreviousOnMouseExited(MouseEvent event) {

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
