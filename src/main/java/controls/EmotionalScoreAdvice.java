package controls;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class EmotionalScoreAdvice extends StackPane {

    private Label labelHeader = new Label();
    private Label labelScore = new Label();

    public EmotionalScoreAdvice(String header, String score){

        this.labelHeader.setText(header);
        this.labelHeader.getStyleClass().add("LBLTitle");
        this.labelHeader.setMaxWidth(Double.MAX_VALUE);
        this.labelScore.setText(score + "/10");
        this.labelScore.setPadding(new Insets(0,2,0,2));
        this.labelScore.getStyleClass().add("LBLScore");

        HBox.setHgrow(this.labelHeader, Priority.ALWAYS);

        HBox hbox = new HBox(this.labelScore, this.labelHeader);

        this.getChildren().add(hbox);

    }

    public void setScore (int score){

        this.labelScore.setText(score +"/10");

    }

    public void setEmotion (String emotion){

        this.labelHeader.setText(emotion);

    }

}
