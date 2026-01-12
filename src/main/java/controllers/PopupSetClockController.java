package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;

public class PopupSetClockController {

    //Variables
    private static boolean isDarkMode;

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
    private ToggleButton TBTDateHour;

    @FXML
    private TextField TXTDate;

    @FXML
    private TextField TXTDescription;

    @FXML
    private TextField TXTHour;

    @FXML
    private ToggleGroup group;

    ToggleButton [] toggleButtons;
    ImageView [] imageViews;

    @FXML
    void initialize(){

        isDarkMode = UserPreferences.getUserThemeMode();

        removeSelection(TBTButtonFocus1, TBTButtonFocus2, TBTButtonFocus3, TBTButtonFocus4, TBTButtonFocus5, TBTButtonHabits1, TBTButtonHabits2, TBTButtonHabits3, TBTButtonHabits4, TBTButtonHabits5, TBTButtonOther, TBTButtonPersonalGrowth1, TBTButtonPersonalGrowth2, TBTButtonPersonalGrowth3, TBTButtonPersonalGrowth4, TBTButtonPersonalGrowth5, TBTButtonRelations1, TBTButtonRelations2, TBTButtonRelations3, TBTButtonRelations4, TBTButtonRelations5, TBTButtonTech1, TBTButtonTech2, TBTButtonTech3, TBTButtonTech4);

        toggleButtons = new ToggleButton[]{TBTButtonFocus1, TBTButtonFocus2, TBTButtonFocus3, TBTButtonFocus4, TBTButtonFocus5, TBTButtonHabits1, TBTButtonHabits2, TBTButtonHabits3, TBTButtonHabits4, TBTButtonHabits5, TBTButtonOther, TBTButtonPersonalGrowth1, TBTButtonPersonalGrowth2, TBTButtonPersonalGrowth3, TBTButtonPersonalGrowth4, TBTButtonPersonalGrowth5, TBTButtonRelations1, TBTButtonRelations2, TBTButtonRelations3, TBTButtonRelations4, TBTButtonRelations5, TBTButtonTech1, TBTButtonTech2, TBTButtonTech3, TBTButtonTech4};

        imageViews = new ImageView [] {IMGFocus1, IMGFocus2, IMGFocus3, IMGFocus4, IMGFocus5, IMGHabits1, IMGHabits2, IMGHabits3, IMGHabits4, IMGHabits5, IMGOther, IMGPersonalGrowth1, IMGPersonalGrowth2, IMGPersonalGrowth3, IMGPersonalGrowth4, IMGPersonalGrowth5, IMGRelations1, IMGRelations2, IMGRelations3, IMGRelations4, IMGRelations5, IMGTech1, IMGTech2, IMGTech3, IMGTech4};

        StyleBuilder.clearControls(TXTDate, TXTDescription, TXTHour);

        TXTDescription.textProperty().addListener((obs, oldVal, newVal) ->{countChars();});

        SPDateHourSelector.setVisible(false);
        SPDateHourSelector.setManaged(false);

        StyleBuilder.clearControls(TXTHour, TXTDescription, TXTDate);

        changeTheme();

    }

    private void changeTheme(){

        changeColors();

        StyleBuilder.setAnchorPaneClass(APMain);

        ConfigureNodes.configureNodesForPopupSetClockController(BTNClose, BTNStart, IMGDate, IMGDateHour, IMGFocus1, IMGFocus2, IMGFocus3, IMGFocus4, IMGFocus5, IMGHabits1, IMGHabits2, IMGHabits3, IMGHabits4, IMGHabits5, IMGHour, IMGIcon, IMGOther, IMGPersonalGrowth1, IMGPersonalGrowth2, IMGPersonalGrowth3, IMGPersonalGrowth4, IMGPersonalGrowth5, IMGRelations1, IMGRelations2, IMGRelations3, IMGRelations4, IMGRelations5, IMGSubIcon, IMGStart, IMGStartHover, IMGTech1, IMGTech2, IMGTech3, IMGTech4, LBLFocus1, LBLFocus2, LBLFocus3, LBLFocus4, LBLFocus5, LBLHabits1, LBLHabits2, LBLHabits3, LBLHabits4, LBLHabits5, LBLOther, LBLPersonalGrowth1, LBLPersonalGrowth2, LBLPersonalGrowth3, LBLPersonalGrowth4, LBLPersonalGrowth5, LBLRelations1, LBLRelations2, LBLRelations3, LBLRelations4, LBLRelations5, LBLStart, LBLTech1, LBLTech2, LBLTech3, LBLTech4, SPDate, SPDateHourSelector, SPOther, TBTButtonFocus1, TBTButtonFocus2, TBTButtonFocus3, TBTButtonFocus4, TBTButtonFocus5, TBTButtonHabits1, TBTButtonHabits2, TBTButtonHabits3, TBTButtonHabits4, TBTButtonHabits5, TBTButtonOther, TBTButtonPersonalGrowth1, TBTButtonPersonalGrowth2, TBTButtonPersonalGrowth3, TBTButtonPersonalGrowth4, TBTButtonPersonalGrowth5, TBTButtonRelations1, TBTButtonRelations2, TBTButtonRelations3, TBTButtonRelations4, TBTButtonRelations5, TBTButtonTech1, TBTButtonTech2, TBTButtonTech3, TBTButtonTech4, TBTDateHour, isDarkMode);

        activeToggleButton();

    }

    private void changeColors(){



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
    void BTNStartOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void BTNStartOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void BTNStartOnMouseExited(MouseEvent event) {

    }

    @FXML
    void SPDateHourSelectorOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void SPDateHourSelectorOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void SPDateHourSelectorOnMouseExited(MouseEvent event) {

    }

    @FXML
    void SPDateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void SPDateOnMouseExited(MouseEvent event) {

    }

    @FXML
    void SPOtherOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void SPOtherOnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus1OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus1OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus1OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus2OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus2OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus2OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus3OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus3OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus3OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus4OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus4OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus4OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus5OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus5OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonFocus5OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits1OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits1OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits1OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits2OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits2OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits2OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits3OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits3OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits3OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits4OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits4OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits4OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits5OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits5OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonHabits5OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonOtherOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonOtherOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonOtherOnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth1OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth1OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth1OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth2OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth2OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth2OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth3OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth3OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth3OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth4OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth4OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth4OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth5OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth5OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonPersonalGrowth5OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations1OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations1OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations1OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations2OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations2OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations2OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations3OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations3OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations3OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations4OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations4OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations4OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations5OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations5OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonRelations5OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech1OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech1OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech1OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech2OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech2OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech2OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech3OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech3OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech3OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech4OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech4OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTButtonTech4OnMouseExited(MouseEvent event) {

    }

    @FXML
    void TBTDateHourOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void TBTDateHourOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void TBTDateHourOnMouseExited(MouseEvent event) {

    }

    private void activeToggleButton(){

        for(int i = 0; i < toggleButtons.length; i++){

            if(toggleButtons [i] != null){

                if(toggleButtons[i].isSelected()){

                    //El botón fue seleccionado
                    imageViews[i].setVisible(true);


                }else{

                    //El botón no está siendo seleccionado
                    imageViews[i].setVisible(false);


                }

            }

        }

    }

    private void countChars(){

        LBLMaxCharsCount.setText(TXTDescription.getText().length() + "/60");

        if(TXTDescription.getText().length() >60){

            //Es mayor de 60

        }else{

            //Es menor de 60

        }

    }

    private void removeSelection(ToggleButton... toggleButtons) {

        for(ToggleButton toggleButton : toggleButtons) {

            if(toggleButton != null){

                toggleButton.setSelected(false);

            }

        }

    }

}
