package controls;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class EmotionToggleButton extends ToggleButton {

    public EmotionToggleButton(String text){

        super();

        this.setText(text);

        this.setMaxWidth(Double.MAX_VALUE);

        this.setCursor(Cursor.HAND);

    }

}
