package controls;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class EmotionToggleButton extends ToggleButton {

    public Label label;
    public ImageView imageView;

    public EmotionToggleButton(String text){

        super();

        this.label = new Label(text);
        this.imageView = new ImageView();

        this.imageView.setFitHeight(16);
        this.imageView.setFitWidth(16);

        this.label.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(label, Priority.ALWAYS);

        HBox hbox = new HBox(this.label, this.imageView);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);

        this.setGraphic(hbox);
        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        this.setMaxWidth(Double.MAX_VALUE);

    }

    public Label getToggleButtonLabel(){

        return label;

    }

    public ImageView getToggleButtonImageView (){

        return imageView;

    }

}
