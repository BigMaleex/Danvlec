package stylebuilder;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class DrawClocks extends VBox {

    private final String font = "Oswald SemiBold";

    public enum ClockUnitType {
        YEAR("Año", 0, Integer.MAX_VALUE, 0),
        MONTH("Mes", 0, 11, 1),
        DAY("Día", 0, 30, 2),
        HOUR("Hora", 0, 23, 3),
        MINUTE("Minuto", 0, 59, 4),
        SECOND("Segundo", 0, 59, 5);

        final String label;
        final int min;
        final int max;
        final int arrayIndex;

        ClockUnitType(String label, int min, int max, int arrayIndex) {
            this.label = label;
            this.min = min;
            this.max = max;
            this.arrayIndex = arrayIndex;
        }
    }

    private final ClockUnitType type;
    private int currentValue;

    private Color activeColor;
    private Color trackColor;

    private final double size;
    private final double strokeWidth;

    private final Canvas canvas;
    private final Label lblValue;
    private final Label lblUnitName;
    private final Label lblTitle;
    private final Label lblValueDetail;

    private final DoubleProperty animatedValue = new SimpleDoubleProperty(0);
    private Timeline valueAnimation;

    public DrawClocks(ClockUnitType type,
                      String activeColorString,
                      String trackColorString,
                      double size) {
        this.type = type;
        this.activeColor = Color.web(activeColorString);
        this.trackColor = Color.web(trackColorString);
        this.size = size;
        this.strokeWidth = size * 0.10;

        canvas = new Canvas(size, size);

        lblValue = new Label("0");
        lblValue.setFont(Font.font(font, FontWeight.BOLD, size * 0.28));
        lblValue.setTextFill(activeColor);

        lblUnitName = new Label(unitLabelFor(0));
        lblUnitName.setFont(Font.font(font, FontWeight.NORMAL, size * 0.14));
        lblUnitName.setTextFill(Color.GRAY);

        VBox centerBox = new VBox(0, lblValue, lblUnitName);
        centerBox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane(canvas, centerBox);
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setPrefSize(size, size);
        stackPane.setMaxSize(size, size);

        lblTitle = new Label(unitLabelFor(0));
        lblTitle.setFont(Font.font(font, FontWeight.BOLD, size * 0.14));
        lblTitle.setTextFill(activeColor);

        lblValueDetail = new Label("0 / ?");
        lblValueDetail.setFont(Font.font(font, FontWeight.NORMAL, size * 0.13));
        lblValueDetail.setTextFill(Color.GRAY);

        setAlignment(Pos.TOP_CENTER);
        setSpacing(6);
        getChildren().addAll(stackPane, lblTitle, lblValueDetail);

        animatedValue.addListener((obs, oldVal, newVal) -> redraw());
        redraw();
    }

    public void setValue(int value) {
        int nextValue = Math.max(0, value);
        if (nextValue == this.currentValue && valueAnimation == null) {
            return;
        }
        this.currentValue = nextValue;
        animateTo(nextValue);
    }

    public void setValues(int[] elapsed) {
        if (elapsed == null || elapsed.length < 6) {
            throw new IllegalArgumentException(
                "El array debe tener al menos 6 elementos: [y, mo, d, h, min, s]");
        }
        setValue(elapsed[type.arrayIndex]);
    }

    public int getValue() {
        return currentValue;
    }

    // FIX: garantiza ejecución en el FX Thread y fuerza redraw completo
    public void setActiveColor(Color color) {
        Runnable update = () -> {
            this.activeColor = color;
            lblValue.setTextFill(color);
            lblTitle.setTextFill(color);
            redraw();
        };

        if (Platform.isFxApplicationThread()) {
            update.run();
        } else {
            Platform.runLater(update);
        }
    }

    // FIX: garantiza ejecución en el FX Thread
    public void setTrackColor(Color color) {
        Runnable update = () -> {
            this.trackColor = color;
            redraw();
        };

        if (Platform.isFxApplicationThread()) {
            update.run();
        } else {
            Platform.runLater(update);
        }
    }

    public static void updateAll(int[] elapsed, DrawClocks... units) {
        if (elapsed == null || elapsed.length < 6) {
            throw new IllegalArgumentException(
                "El array debe tener al menos 6 elementos: [y, mo, d, h, min, s]");
        }
        for (DrawClocks unit : units) {
            unit.setValues(elapsed);
        }
    }

    // FIX: usa Platform.runLater para garantizar actualización en el FX Thread
    // cuando se llama desde hilos secundarios (ScheduledExecutorService, Thread, etc.)
    public static void updateColor(DrawClocks[] clocks, String[] activeColors, String[] trackColors) {
        if (clocks == null || activeColors == null || trackColors == null) {
            throw new IllegalArgumentException("clocks, activeColors y trackColors no pueden ser null.");
        }
        if (clocks.length != activeColors.length || clocks.length != trackColors.length) {
            throw new IllegalArgumentException(
                "Los arrays deben tener la misma longitud: clocks, activeColors y trackColors.");
        }

        for (int i = 0; i < clocks.length; i++) {
            if (clocks[i] != null && activeColors[i] != null && trackColors[i] != null) {
                final int idx = i;

                // FIX PRINCIPAL: toda modificación de nodos JavaFX debe ocurrir
                // en el Application Thread. setActiveColor/setTrackColor ya
                // manejan esto internamente, pero al pasarles Color.web() desde
                // un hilo externo también protegemos esa conversión.
                Runnable colorUpdate = () -> {
                    clocks[idx].setActiveColor(Color.web(activeColors[idx]));
                    clocks[idx].setTrackColor(Color.web(trackColors[idx]));
                };

                if (Platform.isFxApplicationThread()) {
                    colorUpdate.run();
                } else {
                    Platform.runLater(colorUpdate);
                }

            } else {
                System.out.println("No se pudo actualizar el color del reloj en " + i + " posición");
            }
        }
    }

    private void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, size, size);

        double padding = strokeWidth / 2.0 + 2;
        double arcSize = size - padding * 2;

        gc.setLineCap(StrokeLineCap.ROUND);
        gc.setLineWidth(strokeWidth);

        gc.setStroke(trackColor);
        gc.strokeArc(padding, padding, arcSize, arcSize, 90, -360, ArcType.OPEN);

        int effectiveMin;
        int effectiveMax;

        if (type == ClockUnitType.YEAR) {
            int scale = yearScale(currentValue);
            effectiveMin = (scale == 10) ? 0 : scale / 10;
            effectiveMax = scale;
        } else {
            effectiveMin = type.min;
            effectiveMax = type.max;
        }

        double range = effectiveMax - effectiveMin;
        double valueForDraw = animatedValue.get();
        double fraction = (range == 0) ? 0.0 : (valueForDraw - effectiveMin) / range;
        fraction = Math.max(0.0, Math.min(1.0, fraction));
        double sweep = fraction * 360;

        if (sweep > 0) {
            gc.setStroke(activeColor);
            gc.strokeArc(padding, padding, arcSize, arcSize, 90, -sweep, ArcType.OPEN);
        }

        lblValue.setText(String.valueOf(currentValue));
        String unitLabel = unitLabelFor(currentValue);
        lblUnitName.setText(unitLabel);
        lblTitle.setText(unitLabel);
        lblValueDetail.setText(currentValue + " / " + effectiveMax);
    }

    private void animateTo(int targetValue) {
        if (valueAnimation != null) {
            valueAnimation.stop();
        }

        double start = animatedValue.get();
        double end = targetValue;

        if (type != ClockUnitType.YEAR && end < start) {
            double wrapEnd = type.max + 1.0;
            valueAnimation = new Timeline(
                new KeyFrame(Duration.ZERO,
                    new KeyValue(animatedValue, start, Interpolator.EASE_BOTH)),
                new KeyFrame(Duration.millis(260),
                    new KeyValue(animatedValue, wrapEnd, Interpolator.EASE_BOTH)),
                new KeyFrame(Duration.millis(420),
                    new KeyValue(animatedValue, end, Interpolator.EASE_OUT))
            );
        } else {
            valueAnimation = new Timeline(
                new KeyFrame(Duration.ZERO,
                    new KeyValue(animatedValue, start, Interpolator.EASE_BOTH)),
                new KeyFrame(Duration.millis(320),
                    new KeyValue(animatedValue, end, Interpolator.EASE_BOTH))
            );
        }

        valueAnimation.setOnFinished(e -> valueAnimation = null);
        valueAnimation.play();
    }

    private String unitLabelFor(int value) {
        boolean singular = value == 1;
        return switch (type) {
            case YEAR -> singular ? "Año" : "Años";
            case MONTH -> singular ? "Mes" : "Meses";
            case DAY -> singular ? "Día" : "Días";
            case HOUR -> singular ? "Hora" : "Horas";
            case MINUTE -> singular ? "Minuto" : "Minutos";
            case SECOND -> singular ? "Segundo" : "Segundos";
        };
    }

    private static int yearScale(int value) {
        int scale = 10;
        while (scale <= value) {
            scale *= 10;
        }
        return scale;
    }
}