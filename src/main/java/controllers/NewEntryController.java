package controllers;

import controls.EmotionToggleButton;
import controls.EmotionalButtons;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import stylebuilder.StyleBuilder;
import utilities.Titles;

import java.util.ArrayList;

public class NewEntryController {

    public enum Step {

        First, Second, Third, Fourth

    }

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
    private Label LBLEmotionsStep;

    @FXML
    private Label LBLNext;

    @FXML
    private Label LBLScoreEmotionsStep;

    @FXML
    private Label LBLSummaryCountMaxCharsAdditionalNotes;

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
    private StackPane SPScoreEmotionsSurprised;

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
    private TextArea TXTContextWhatHappening;

    @FXML
    private TextArea TXTContextWhatDidYouFeel;

    @FXML
    private TextArea TXTSummaryAdditionalNotes;

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

    private EmotionToggleButton[] toggleButtons;
    private Label [] labels;
    private ImageView [] imageViews;

    @FXML
    public void initialize () {

        LBLTitleBar.setText(Titles.NewEntry);

        EmotionalButtons buttons = new EmotionalButtons();

        toggleButtons = buttons.getEmotionNodes();

        ArrayList<Label> labelsToArray = new ArrayList<>();
        ArrayList<ImageView> imagesToArray = new ArrayList<>();

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

        for(int i = 0; i < toggleButtons.length; i++) {

            if(toggleButtons[i] != null) {

                labelsToArray.add(toggleButtons[i].getToggleButtonLabel());
                imagesToArray.add(toggleButtons[i].getToggleButtonImageView());

            }

        }

        labels = labelsToArray.toArray(new Label[labelsToArray.size()]);
        imageViews = imagesToArray.toArray(new ImageView[imagesToArray.size()]);

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

        //Vincular managed a visibility
        SPContext.managedProperty().bind(SPContext.visibleProperty());
        SPEmotions.managedProperty().bind(SPEmotions.visibleProperty());
        SPScoreEmotions.managedProperty().bind(SPScoreEmotions.visibleProperty());
        SPSummary.managedProperty().bind(SPSummary.visibleProperty());

        SPScoreEmotionsHappy.managedProperty().bind(SPScoreEmotionsHappy.visibleProperty());
        SPScoreEmotionsSurprised.managedProperty().bind(SPScoreEmotionsSurprised.visibleProperty());
        SPScoreEmotionsFear.managedProperty().bind(SPScoreEmotionsFear.visibleProperty());
        SPScoreEmotionsAnger.managedProperty().bind(SPScoreEmotionsAnger.visibleProperty());
        SPScoreEmotionsDisgust.managedProperty().bind(SPScoreEmotionsDisgust.visibleProperty());
        SPScoreEmotionsSad.managedProperty().bind(SPScoreEmotionsSad.visibleProperty());

        SPContext.setVisible(false);
        SPEmotions.setVisible(false);
        SPScoreEmotions.setVisible(false);
        SPSummary.setVisible(false);

        StyleBuilder.clearControls(TXTContextWhatDidYouFeel, TXTContextWhatHappening, TXTSummaryAdditionalNotes);



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
