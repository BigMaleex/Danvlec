package controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class EmotionalScoreAdvice extends StackPane {

    private Label labelHeader = new Label();
    private Label labelScore = new Label();

    public EmotionalScoreAdvice(String header, int score){

        this.labelHeader.setText(header);
        this.labelHeader.getStyleClass().add("LBLTitle");
        this.labelHeader.setMaxWidth(Double.MAX_VALUE);
        this.labelScore.setText(score + "/10");
        this.labelScore.setPadding(new Insets(0,5,0,5));
        this.labelScore.getStyleClass().add("LBLScore");

        HBox.setHgrow(this.labelHeader, Priority.ALWAYS);

        HBox hbox = new HBox( this.labelHeader, this.labelScore);

        this.getChildren().add(hbox);

    }

}
