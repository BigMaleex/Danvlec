package controls;

import javafx.beans.property.*;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class SwitchButton extends Control {

    private final BooleanProperty selected = new SimpleBooleanProperty(this, "selected",false);

    private final ObjectProperty<Paint> onColor = new SimpleObjectProperty<>(this, "onColor", javafx.scene.paint.Color.web("#4CAF50"));

    private final ObjectProperty<Paint> offColor = new SimpleObjectProperty<>(this, "offColor", javafx.scene.paint.Color.LIGHTGRAY);

    private final ObjectProperty<Paint> thumbColor = new SimpleObjectProperty<>(this, "thumbColor", javafx.scene.paint.Color.WHITE);

    private final DoubleProperty switchWidth = new SimpleDoubleProperty(this, "switchWidth", 50);

    private final DoubleProperty switchHeight = new SimpleDoubleProperty(this, "switchHeight", 25);

    private final ObjectProperty<Duration> animationDuration = new SimpleObjectProperty<>(this, "animationDuration", Duration.millis(300));

    public SwitchButton() {

        getStyleClass().add("switch-button");
        setFocusTraversable(false);

        setOnKeyPressed(event -> {

            switch(event.getCode()){

                case SPACE:
                case ENTER:
                    setSelected(!isSelected());
                    event.consume();
                    break;
                default:

            }

        });

    }

    @Override
    protected Skin<?> createDefaultSkin(){

        return new SwitchSkin(this);

    }

    public final void setSelected (boolean value){

        selected.set(value);

    }


    public final BooleanProperty selectedProperty(){

        return selected;

    }

    public ObjectProperty<Paint> onColorProperty(){

        return onColor;

    }

    public ObjectProperty<Paint> offColorProperty() {

        return offColor;

    }

    public ObjectProperty<Paint> thumbColorProperty() {

        return thumbColor;

    }

    public DoubleProperty switchWidthProperty() {

        return switchWidth;

    }

    public DoubleProperty switchHeightProperty() {

        return switchHeight;

    }

    public ObjectProperty<Duration> animationDurationProperty() {

        return animationDuration;

    }

    public final boolean isSelected() {
        return selected.get();
    }

    public void setOnColor(String colorString) {

        onColor.set(Color.web(colorString));

    }
    public Paint getOnColor() {

        return onColor.get();

    }

    public void setOffColor(String colorString) {

        offColor.set(Color.web(colorString));

    }
    public Paint getOffColor() {

        return offColor.get();

    }

    public void setThumbColor(String colorString) {

        thumbColor.set(Color.web(colorString));

    }
    public Paint getThumbColor() {

        return thumbColor.get();

    }

    public void setSwitchWidth(double w) {

        switchWidth.set(w);

    }
    public double getSwitchWidth() {

        return switchWidth.get();

    }

    public void setSwitchHeight(double h) {

        switchHeight.set(h);

    }
    public double getSwitchHeight() {

        return switchHeight.get();

    }

    public void setAnimationDuration(Duration d) {

        animationDuration.set(d);

    }
    public Duration getAnimationDuration() {

        return animationDuration.get();

    }

}
