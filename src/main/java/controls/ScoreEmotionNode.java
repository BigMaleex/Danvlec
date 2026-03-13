package controls;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;

public class ScoreEmotionNode extends StackPane {

    private Label labelEmotion = new Label();
    private Label labelScore = new Label();
    private Slider slider = new Slider();

    public ScoreEmotionNode(String emotion){

        this.labelEmotion.setText(emotion);
        this.labelEmotion.getStyleClass().add("LBLTitle");
        this.labelScore.getStyleClass().add("LBLScore");
        this.labelEmotion.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(labelEmotion, Priority.ALWAYS);
        this.labelScore.setPadding(new Insets(0, 2, 0, 2));

        HBox HBoxHeader = new HBox(labelEmotion, labelScore);

        Label max = new Label("Muy alta");
        Label min = new Label("Muy baja");
        max.getStyleClass().add("LBLStep");
        min.getStyleClass().add("LBLStep");
        max.setAlignment(Pos.CENTER_RIGHT);
        Region spaceBetweenLabels = new Region();
        HBox.setHgrow(spaceBetweenLabels, Priority.ALWAYS);


        HBox HBoxScore = new HBox(min, spaceBetweenLabels, max);

        this.slider.setMin(1);
        this.slider.setMax(10);
        this.slider.setValue(5);
        this.slider.setMajorTickUnit(1);
        this.slider.setMinorTickCount(0);
        this.slider.setSnapToTicks(true);
        this.slider.setShowTickLabels(true);
        this.slider.setShowTickMarks(true);
        this.slider.setBlockIncrement(1);

        this.labelScore.textProperty().bind(
            Bindings.createStringBinding(
                () -> (int) slider.getValue() + "/10",
                slider.valueProperty()
            )
        );

        VBox main = new VBox(HBoxHeader, HBoxScore, slider);
        main.setAlignment(Pos.CENTER);
        main.setSpacing(10);
        main.setFillWidth(Boolean.TRUE);

        this.getChildren().add(main);

    }

    public int getScore(){

        return (int) this.slider.getValue();

    }

}
