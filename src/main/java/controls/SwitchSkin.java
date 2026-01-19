package controls;

import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.SkinBase;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.css.PseudoClass;



public class SwitchSkin extends SkinBase<SwitchButton> {

    private static final PseudoClass SELECTED_PSEUDO = PseudoClass.getPseudoClass("selected");

    private final Rectangle track = new Rectangle();
    private final Circle thumb = new Circle();

    private final StackPane container = new StackPane();

    private TranslateTransition translate;
    private FillTransition fill;

    // drag helpers
    private double dragStartX = 0;
    private double thumbStartTranslate = 0;
    private boolean dragging = false;

    protected SwitchSkin(SwitchButton control) {
        super(control);
        initializeGraphics();
        registerListeners();
        getChildren().add(container);
    }

    private void initializeGraphics() {
        SwitchButton control = getSkinnable();

        container.setAlignment(Pos.CENTER_LEFT);
        container.getChildren().addAll(track, thumb);
        container.setPickOnBounds(false);

        track.widthProperty().bind(control.switchWidthProperty());
        track.heightProperty().bind(control.switchHeightProperty());

        // CAMBIO AQUÍ: En lugar de 1000, usa la altura del switch
        // Esto hace que las esquinas sean semicirculares basadas en la altura
        track.arcWidthProperty().bind(control.switchHeightProperty());
        track.arcHeightProperty().bind(control.switchHeightProperty());

        thumb.radiusProperty().bind(control.switchHeightProperty().divide(2).subtract(2));
        thumb.setTranslateY(0);
        thumb.setTranslateX(2);

        track.setFill(control.offColorProperty().get());
        thumb.setFill(control.thumbColorProperty().get());

        DropShadow shadow = new DropShadow();
        shadow.setRadius(2);
        shadow.setOffsetY(1);
        shadow.setColor(Color.rgb(0,0,0,0.25));
        thumb.setEffect(shadow);

        container.setOnMouseEntered(e -> {
            if (!getSkinnable().isDisabled()) container.setCursor(Cursor.HAND);
        });
        container.setOnMouseExited(e -> container.setCursor(Cursor.DEFAULT));
    }

    private void registerListeners() {
        SwitchButton control = getSkinnable();

        translate = new TranslateTransition(control.getAnimationDuration(), thumb);
        fill = new FillTransition(control.getAnimationDuration(), track);

        control.animationDurationProperty().addListener((obs, oldD, newD) -> {
            translate.setDuration(newD);
            fill.setDuration(newD);
        });

        control.onColorProperty().addListener((obs, o, n) -> {
            if (control.isSelected()) track.setFill(n);
        });
        control.offColorProperty().addListener((obs, o, n) -> {
            if (!control.isSelected()) track.setFill(n);
        });
        control.thumbColorProperty().addListener((obs, o, n) -> thumb.setFill(n));

        // CAMBIO IMPORTANTE: Inicializar la posición ANTES del listener
        initializePosition();

        control.selectedProperty().addListener((obs, oldV, newV) -> {
            updateSelectedState(newV);
            playToggleAnimation(newV);
        });

        updateSelectedState(control.isSelected());

        container.setOnMouseClicked(ev -> {
            if (ev.getButton() != MouseButton.PRIMARY) return;
            if (dragging) return;
            control.setSelected(!control.isSelected());
        });

        container.setOnMousePressed(ev -> {
            if (getSkinnable().isDisabled() || ev.getButton() != MouseButton.PRIMARY) return;
            dragging = false;
            dragStartX = ev.getScreenX();
            thumbStartTranslate = thumb.getTranslateX();
        });

        container.setOnMouseDragged(ev -> {
            if (getSkinnable().isDisabled()) return;
            double dx = ev.getScreenX() - dragStartX;
            double minX = 2;
            double maxX = control.switchWidthProperty().get() - control.switchHeightProperty().get() + 2;
            double newX = thumbStartTranslate + dx;
            if (newX < minX) newX = minX;
            if (newX > maxX) newX = maxX;
            thumb.setTranslateX(newX);
            double ratio = (newX - minX) / (maxX - minX);
            track.setFill(interpolateColor(control.offColorProperty().get(), control.onColorProperty().get(), ratio));
            dragging = true;
        });

        container.setOnMouseReleased(ev -> {
            if (getSkinnable().isDisabled()) return;
            if (!dragging) return;
            double minX = 2;
            double maxX = control.switchWidthProperty().get() - control.switchHeightProperty().get() + 2;
            double mid = (minX + maxX) / 2.0;
            boolean newSelected = thumb.getTranslateX() >= mid;
            control.setSelected(newSelected);
            dragging = false;
        });

        control.disabledProperty().addListener((obs, oldV, newV) -> {
            if (newV) {
                container.setOpacity(0.5);
                container.setCursor(Cursor.DEFAULT);
            } else {
                container.setOpacity(1.0);
            }
        });

        ChangeListener<Number> layoutListener = (obs, o, n) -> {
            if (!dragging) {
                updatePositionAndColor();
            }
        };

        control.switchWidthProperty().addListener(layoutListener);
        control.switchHeightProperty().addListener(layoutListener);
    }

    // NUEVO MÉTODO: Inicializar posición y color
    private void initializePosition() {
        SwitchButton control = getSkinnable();
        double minX = 2;
        double maxX = control.switchWidthProperty().get() - control.switchHeightProperty().get() + 2;
        double pos = control.isSelected() ? maxX : minX;
        thumb.setTranslateX(pos);
        track.setFill(control.isSelected() ? control.onColorProperty().get() : control.offColorProperty().get());
    }

    private void updatePositionAndColor() {
        SwitchButton control = getSkinnable();
        double minX = 2;
        double maxX = control.switchWidthProperty().get() - control.switchHeightProperty().get() + 2;
        double pos = control.isSelected() ? maxX : minX;
        thumb.setTranslateX(pos);
        track.setFill(control.isSelected() ? control.onColorProperty().get() : control.offColorProperty().get());
    }

    private void updateSelectedState(boolean selected) {
        getSkinnable().pseudoClassStateChanged(SELECTED_PSEUDO, selected);
    }

    private void playToggleAnimation(boolean newState) {
        SwitchButton control = getSkinnable();

        double minX = 2;
        double maxX = control.switchWidthProperty().get() - control.switchHeightProperty().get() + 2;
        double toX = newState ? maxX : minX;

        translate.stop();
        translate.setNode(thumb);
        translate.setToX(toX);
        translate.setDuration(control.getAnimationDuration());
        translate.play();

        fill.stop();
        fill.setShape(track);
        fill.setDuration(control.getAnimationDuration());
        Paint from = (Paint) track.getFill();
        Paint to = newState ? control.getOnColor() : control.getOffColor();
        fill.setFromValue(from instanceof Color ? (Color) from : Color.TRANSPARENT);
        fill.setToValue(to instanceof Color ? (Color) to : Color.TRANSPARENT);
        fill.play();
    }

    private Paint interpolateColor(Paint a, Paint b, double t) {
        Color ca = a instanceof Color ? (Color) a : Color.TRANSPARENT;
        Color cb = b instanceof Color ? (Color) b : Color.TRANSPARENT;
        double r = ca.getRed() + (cb.getRed() - ca.getRed()) * t;
        double g = ca.getGreen() + (cb.getGreen() - ca.getGreen()) * t;
        double bl = ca.getBlue() + (cb.getBlue() - ca.getBlue()) * t;
        double op = ca.getOpacity() + (cb.getOpacity() - ca.getOpacity()) * t;
        return new Color(clamp(r), clamp(g), clamp(bl), clamp(op));
    }

    private double clamp(double v) {
        if (v < 0) return 0;
        if (v > 1) return 1;
        return v;
    }
}
