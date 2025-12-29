package messagebuilder;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import utilities.Colors;
import utilities.Styles;

public class Complements {

    protected static final String womanColor = "#F7609A";
    protected static final String manColor = "#0089F8";
    protected static final String bullet = "• ";
    protected static final String errorTitle = "¡Nos hemos encontrado con un problema!";
    protected static final String okTitle = "¡Todo se encuentra bien!";

    protected static Text addStringFromTextList(String text, String size, String color){

        Text t = new Text(text);

        t.setStyle(Styles.fontFamily + Styles.fontSize + size + Styles.end);
        t.setFill(Color.web(color));

        return t;

    }


}
