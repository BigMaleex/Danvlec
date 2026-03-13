package controls;

import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;

public class EmotionToggleButton extends ToggleButton {

    public EmotionToggleButton(String text){

        super();

        this.setText(text);

        this.setMaxWidth(Double.MAX_VALUE);

        this.setCursor(Cursor.HAND);

    }

}
