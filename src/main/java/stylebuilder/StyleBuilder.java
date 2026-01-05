package stylebuilder;

import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import user.UserPreferences;
import utilities.FileConstants;
import utilities.Images;

public class StyleBuilder {

    // Constantes
    private static final double TRANSITION_DURATION = 0.3d;
    private static final int ANIMATION_STEPS = 20;
    private static final int SWEEP_ANIMATION_STEPS = 25;

    // Regex para limpiar estilos (basados en propiedades en línea)
    private static final String BACKGROUND_COLOR_REGEX = "-fx-background-color:[^;]*;?";
    private static final String BORDER_COLOR_REGEX = "-fx-border-color:[^;]*;?";
    private static final String TEXT_FILL_REGEX = "-fx-text-fill:[^;]*;?";


    public static void animateButtonColorsWithImagesAndLabels(String bgStart, String bgEnd, String brStart, String brEnd, String fColorStart, String fColorEnd, Button button, ImageView image, ImageView imageHover, Label label){

        animateButtonColors(button, bgStart, bgEnd,brStart, brEnd, fColorStart, fColorEnd);
        animateLabelTextColor(label, fColorStart, fColorEnd);
        fadeAndChangeImage(image, imageHover);

    }

    public static void showAndHideToastNotification(StackPane sp, boolean isLong){

        double transition = 0.3d;

        sp.setOpacity(0.0);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(transition), sp);
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(transition), sp);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        PauseTransition pause = new PauseTransition(Duration.seconds(isLong ? 3 : 2));

        SequentialTransition sequential = new SequentialTransition(fadeIn,pause, fadeOut);

        sequential.play();

    }

    /**
     * Cambia el estado del passwordField y de las imágenes
     * @param PSField PasswordField
     * @param TXTField TextField
     * @param icon Imagen normal
     * @param iconHover Imagen Hover
     * @param status Visible o invisible
     * @param isDarkMode modo oscuro o claro
     */

    public static void togglePasswordAndVisibility(PasswordField PSField, TextField TXTField, ImageView icon, ImageView iconHover, String darkVisible, String darkVisibleHover, String lightVisible, String lightVisibleHover, String darkHide, String darkHideHover, String lightHide, String lightHideHover, boolean status, boolean isDarkMode){

        if(status){

            //Visible
            TXTField.setText(PSField.getText());
            TXTField.setVisible(true);
            TXTField.setManaged(true);
            PSField.setVisible(false);
            PSField.setManaged(false);

            setImages(darkVisible, lightVisible, isDarkMode, icon);
            setImages(darkVisibleHover, lightVisibleHover, isDarkMode, iconHover);

        }else{

            //Invisible

            PSField.setText(TXTField.getText());
            PSField.setVisible(true);
            PSField.setManaged(true);
            TXTField.setVisible(false);
            TXTField.setManaged(false);

            setImages(darkHide, lightHide, isDarkMode, icon);
            setImages(darkHideHover, lightHideHover, isDarkMode, iconHover);

        }



    }

    private static void setImages(String darkSRC, String lightSRC, boolean isDM, ImageView... images){

        Image img = Images.getImage(isDM ? darkSRC : lightSRC);

        if(img == null) return;

        for(ImageView image: images){

            if(image != null){

                image.setImage(img);

            }

        }

    }

    /**
     * Normaliza los Label para que no se vean
     * @param labels lista de labels a normalizar
     */

    public static void normalizeLabels(Label... labels){

        for(Label label : labels){

            label.getStyleClass().clear();
            label.getStyleClass().add("norm");

        }

    }

    /**
     * Limpia el formato de un string eliminando espacios extras
     */
    public static String clearStringFormat(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }
        return input.trim().replaceAll("\\s+", " ");
    }

    /**
     * Convierte un string de color (hex/rgba) a objeto Color de JavaFX
     * Soporta formatos: #RGB, #RGBA, #RRGGBB, #RRGGBBAA
     */
    private static Color parseColor(String colorString, Color fallback) {
        if (colorString == null || colorString.trim().isEmpty()) {
            return fallback;
        }
        try {
            // JavaFX Color.web soporta automáticamente todos los formatos hex
            return Color.web(colorString.trim());
        } catch (Exception ex) {
            System.err.println("Error parsing color: " + colorString + " - " + ex.getMessage());
            return fallback;
        }
    }

    /**
     * Convierte un Color de JavaFX a string CSS con soporte alpha
     */
    private static String colorToCss(Color color) {
        if (color == null) {
            return "transparent";
        }

        int r = (int) Math.round(color.getRed() * 255);
        int g = (int) Math.round(color.getGreen() * 255);
        int b = (int) Math.round(color.getBlue() * 255);
        double a = color.getOpacity();

        // Para colores completamente opacos, usar formato hex (más eficiente)
        if (Math.abs(a - 1.0) < 1e-6) {
            return String.format("#%02X%02X%02X", r, g, b);
        }
        // Para transparencias, usar rgba
        else {
            return String.format("rgba(%d, %d, %d, %.3f)", r, g, b, a);
        }
    }

    /**
     * Elimina reglas específicas de CSS del estilo actual y normaliza el separador final.
     *
     * Esta versión asegura que el resultado esté vacío o termine en "; " para facilitar
     * concatenaciones seguras posteriores.
     */
    private static String removeStyleRules(String style, String... regexPatterns) {
        if (style == null || style.isEmpty()) {
            return "";
        }

        String result = style;
        for (String regex : regexPatterns) {
            result = result.replaceAll(regex, "");
        }

        // Normalizar múltiples ; y espacios
        result = result.replaceAll(";+", ";").trim();

        // Eliminar ; finales sobrantes
        result = result.replaceAll(";\\s*$", "");

        // Si no está vacío, asegurar "; " al final para concatenaciones seguras
        if (!result.isEmpty()) {
            result = result + "; ";
        }

        return result;
    }

    /**
     * Construye el string completo de style de forma segura: asegura separadores ("; ")
     * entre la parte base y las reglas nuevas, y añade ';' si las reglas no las tienen.
     */
    private static String buildStyle(String baseStyle, String... rules) {
        String base = (baseStyle == null) ? "" : baseStyle;

        // Normalizar base: si no está vacía, asegurar que termina en "; "
        if (!base.isEmpty()) {
            base = base.replaceAll(";\\s*$", "");
            base = base + "; ";
        }

        StringBuilder sb = new StringBuilder(base);
        for (String r : rules) {
            if (r == null || r.trim().isEmpty()) continue;
            String rr = r.trim();
            // Añadir la regla y asegurar ';' al final
            if (!rr.endsWith(";")) {
                sb.append(rr).append(";");
            } else {
                sb.append(rr);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    /**
     * Cambia suavemente los colores de un botón
     */
    public static void animateButtonColors(ButtonBase button, String startBg, String endBg, String startBorder, String endBorder, String startText, String endText) {

        String baseStyle = removeStyleRules(button.getStyle(),
                BACKGROUND_COLOR_REGEX, BORDER_COLOR_REGEX, TEXT_FILL_REGEX);

        // Parsear colores con soporte alpha
        Color cBgStart = parseColor(startBg, Color.WHITE);
        Color cBgEnd = parseColor(endBg, Color.WHITE);
        Color cBorderStart = parseColor(startBorder, Color.TRANSPARENT);
        Color cBorderEnd = parseColor(endBorder, Color.TRANSPARENT);
        Color cTextStart = parseColor(startText, Color.BLACK);
        Color cTextEnd = parseColor(endText, Color.BLACK);

        // Estado inicial
        button.setTextFill(cTextStart);
        button.setStyle(buildStyle(baseStyle,
                "-fx-background-color: " + colorToCss(cBgStart),
                "-fx-border-color: " + colorToCss(cBorderStart),
                "-fx-text-fill: " + colorToCss(cTextStart)
        ));

        // Crear animación
        Timeline timeline = new Timeline();
        double totalMillis = TRANSITION_DURATION * 1000.0;

        for (int i = 0; i <= ANIMATION_STEPS; i++) {
            final double t = (double) i / ANIMATION_STEPS;

            KeyFrame kf = new KeyFrame(Duration.millis(totalMillis * t), e -> {
                Color cBgNow = cBgStart.interpolate(cBgEnd, t);
                Color cBorderNow = cBorderStart.interpolate(cBorderEnd, t);
                Color cTextNow = cTextStart.interpolate(cTextEnd, t);

                button.setTextFill(cTextNow);
                button.setStyle(buildStyle(baseStyle,
                        "-fx-background-color: " + colorToCss(cBgNow),
                        "-fx-border-color: " + colorToCss(cBorderNow),
                        "-fx-text-fill: " + colorToCss(cTextNow)
                ));
            });
            timeline.getKeyFrames().add(kf);
        }

        timeline.play();
    }

    /**
     * Cambia suavemente entre imágenes con efecto fade
     */
    public static void fadeAndChangeImage(ImageView startImage, ImageView endImage) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(TRANSITION_DURATION), startImage);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(TRANSITION_DURATION), endImage);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition transition = new ParallelTransition(fadeOut, fadeIn);
        transition.play();
    }

    /**
     * Anima el color de texto de un Label
     */
    public static void animateLabelTextColor(Label label, String startColor, String endColor) {
        Color cStart = parseColor(startColor, Color.BLACK);
        Color cEnd = parseColor(endColor, Color.BLACK);

        String baseStyle = removeStyleRules(label.getStyle(), TEXT_FILL_REGEX);
        label.setTextFill(cStart);
        label.setStyle(buildStyle(baseStyle, "-fx-text-fill: " + colorToCss(cStart)));

        // Crear animación
        Timeline timeline = new Timeline();
        double totalMillis = TRANSITION_DURATION * 1000.0;

        for (int i = 0; i <= ANIMATION_STEPS; i++) {
            final double t = (double) i / ANIMATION_STEPS;

            KeyFrame kf = new KeyFrame(Duration.millis(totalMillis * t), e -> {
                Color cNow = cStart.interpolate(cEnd, t);
                label.setTextFill(cNow);
                label.setStyle(buildStyle(baseStyle, "-fx-text-fill: " + colorToCss(cNow)));
            });
            timeline.getKeyFrames().add(kf);
        }

        timeline.play();
    }

    /**
     * Método genérico para animar fondos de cualquier Region
     */
    private static void animateRegionBackground(Region region, String startBgColor, String endBgColor,
                                                String startBorderColor, String endBorderColor) {

        String baseStyle = removeStyleRules(region.getStyle(),
                BACKGROUND_COLOR_REGEX, BORDER_COLOR_REGEX);

        Color bgStart = parseColor(startBgColor, Color.WHITE);
        Color bgEnd = parseColor(endBgColor, Color.WHITE);
        Color borderStart = parseColor(startBorderColor, Color.TRANSPARENT);
        Color borderEnd = parseColor(endBorderColor, Color.TRANSPARENT);

        // Estado inicial
        region.setStyle(buildStyle(baseStyle,
                "-fx-background-color: " + colorToCss(bgStart),
                "-fx-border-color: " + colorToCss(borderStart)
        ));

        // Crear animación
        Timeline timeline = new Timeline();
        double totalMillis = TRANSITION_DURATION * 1000.0;

        for (int i = 0; i <= ANIMATION_STEPS; i++) {
            final double t = (double) i / ANIMATION_STEPS;

            KeyFrame kf = new KeyFrame(Duration.millis(totalMillis * t), e -> {
                Color bgNow = bgStart.interpolate(bgEnd, t);
                Color borderNow = borderStart.interpolate(borderEnd, t);
                region.setStyle(buildStyle(baseStyle,
                        "-fx-background-color: " + colorToCss(bgNow),
                        "-fx-border-color: " + colorToCss(borderNow)
                ));
            });
            timeline.getKeyFrames().add(kf);
        }

        timeline.play();
    }

    /**
     * Animar fondo de StackPane (usa el método genérico)
     */
    public static void animateStackPaneBackground(StackPane pane, String startBgColor, String endBgColor,
                                                  String startBorderColor, String endBorderColor) {
        animateRegionBackground(pane, startBgColor, endBgColor, startBorderColor, endBorderColor);
    }

    /**
     * Animar fondo de AnchorPane (usa el método genérico)
     */
    public static void animateAnchorPaneBackground(AnchorPane pane, String startBgColor, String endBgColor,
                                                   String startBorderColor, String endBorderColor) {
        animateRegionBackground(pane, startBgColor, endBgColor, startBorderColor, endBorderColor);
    }

    /**
     * Limpia el contenido de controles de entrada
     */
    public static void clearControls(Control... controls) {
        if (controls == null) return;

        for (Control control : controls) {
            if (control == null) continue;

            if (control instanceof TextInputControl) {
                ((TextInputControl) control).clear();
            } else if (control instanceof ComboBox<?>) {
                ComboBox<?> combo = (ComboBox<?>) control;
                combo.getSelectionModel().clearSelection();
                combo.setValue(null);
            }
        }
    }

    /**
     * Asigna la clase que corresponda al AnchorPane según el tema del usuario
     */
    public static void setAnchorPaneClass(AnchorPane anchorPane) {
        if (anchorPane == null) return;

        anchorPane.getStyleClass().clear();
        anchorPane.getStyleClass().add(UserPreferences.getUserThemeMode() ? "rootActive" : "root");
    }
}
