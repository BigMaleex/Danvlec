package stylebuilder;

import javafx.scene.Node;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import utilities.FileConstants;
import utilities.Images;
import utilities.Styles;

import java.sql.SQLOutput;

public class ConfigureInitializeStyles {

    protected static void applyStylesToButtonsWithLabel(String background, String border, String fontColor, String fontSize, String borderWidth, String radius, ButtonBase [] buttons, Label [] labels){

        String buttonStyle = buildStylesForContents(background, border, borderWidth, radius);
        String labelStyle = buildStylesForLabels(fontColor, fontSize);

        if(labels.length == buttons.length){

            //Asumimos que está bien organizado
            for(int i = 0; i<buttons.length; i++){

                if(buttons[i] != null){

                    buttons[i].setStyle(buttonStyle);

                }

                if(labels[i] != null){

                    labels[i].setStyle(labelStyle);

                }

            }

        }else{

            System.out.println("No se pueden aplicar estilos debido a que son de distintos tamaños los arreglos: Botones " + buttons.length + ", Labels " + labels.length);

        }

    }

    protected static void setImages(String darkSRC, String lightSRC, boolean isDM, ImageView... images){

        Image img = Images.getImage(isDM ? darkSRC : lightSRC);

        if(img == null) return;

        for(ImageView image: images){

            if(image != null){

                image.setImage(img);

            }

        }

    }

    protected static void applyStylesToContents(String background, String border, String borderWidth, String radius, Region... panes){

        String style = buildStylesForContents(background, border, borderWidth, radius);

        for(Region pane: panes){

            if(pane != null){

                pane.setStyle(style);

            }

        }

    }

    protected static String buildStylesForContents(String background, String border, String borderWidth, String radius){

        StringBuilder style = new StringBuilder();

        if(background != null && !background.trim().isBlank()){

            style.append(Styles.backgroundColor + background + Styles.end);

        }

        if(border != null && !border.trim().isBlank()){

            style.append(Styles.borderColor + border + Styles.end);

        }

        if(borderWidth != null && !borderWidth.trim().isBlank()){

            style.append(Styles.borderWidth + borderWidth + Styles.end);

        }

        if(radius != null && !radius.trim().isBlank()){

            style.append(Styles.borderRadius + radius + Styles.end);
            style.append(Styles.backgroundRadius + radius + Styles.end);

        }

        return style.toString();

    }

    protected static void applyStylesToButtons(String background, String border, String fontColor, String fontSize, String borderWidth, String radius, ButtonBase... buttons){

        String style = buildStylesForButtons(background, border, fontColor, fontSize, borderWidth, radius);

        for(ButtonBase button: buttons){

            if(button != null){

                button.setStyle(style);

            }

        }

    }

    protected static String buildStylesForButtons(String background, String border, String fontColor, String fontSize, String borderWidth, String radius){

        StringBuilder style = new StringBuilder();

        style.append(Styles.fontFamily);

        if(fontColor != null && !fontColor.trim().isBlank()){

            style.append(Styles.textColor + fontColor + Styles.end);

        }

        if(fontSize != null && !fontSize.trim().isBlank()){

            style.append(Styles.fontSize + fontSize + Styles.end);

        }

        if(background != null && !background.trim().isBlank()){

            style.append(Styles.backgroundColor + background + Styles.end);

        }

        if(border != null && !border.trim().isBlank()){

            style.append(Styles.borderColor + border + Styles.end);

        }

        if(borderWidth != null && !borderWidth.trim().isBlank()){

            style.append(Styles.borderWidth + borderWidth + Styles.end);

        }

        if(radius != null && !radius.trim().isBlank()){

            style.append(Styles.borderRadius + radius + Styles.end);
            style.append(Styles.backgroundRadius + radius + Styles.end);

        }

        return style.toString();

    }

    protected static void applyStylesToLabels(String fontColor, String fontSize, Label... labels){

        String style = buildStylesForLabels(fontColor, fontSize);

        for(Label label: labels){

            if(label != null){

                label.setStyle(style);

            }

        }

    }

    protected static String buildStylesForLabels(String fontColor, String fontSize){

        StringBuilder style = new StringBuilder();

        style.append(Styles.fontFamily);

        if(fontColor != null && !fontColor.trim().isBlank()){

            style.append(Styles.textColor + fontColor + Styles.end);

        }

        if(fontSize != null && !fontSize.trim().isBlank()){

            style.append(Styles.fontSize + fontSize + Styles.end);

        }

        return style.toString();

    }

    protected static void setPasswordImages(String darkVisible, String darkVisibleHover, String lightVisible, String lightVisibleHover, String darkHide, String darkHideHover, String lightHide, String lightHideHover, boolean isDarkMode, boolean visible, ImageView image, ImageView imageHover){

        if(visible){

            setImages(darkVisible, lightVisible, isDarkMode, image);
            setImages(darkVisibleHover, lightVisibleHover, isDarkMode, imageHover);

        }else{

            setImages(darkHide, lightHide, isDarkMode, image);
            setImages(darkHideHover, lightHideHover, isDarkMode, imageHover);

        }

    }

    protected static void addToolTip(String message, String tooltipBackground, String tooltipBorder, String tooltipFontColor, Node... nodes){

        Tooltip tooltip = new Tooltip();

        tooltip.setText(message);
        tooltip.setStyle(buildStylesForButtons(tooltipBackground, tooltipBorder, tooltipFontColor, Styles.px10, Styles.px1, Styles.px10));
        tooltip.setShowDelay(Duration.millis(500));
        tooltip.setHideDelay(Duration.millis(100));

        for(Node node: nodes){

            if(node != null){

                Tooltip.install(node, tooltip);

            }

        }

    }

    protected static void setThemeImages(ImageView IMGTheme, ImageView IMGThemeHover, ImageView IMGThemeInit, boolean isDarkMode){

        if(IMGTheme != null){

            IMGTheme.setImage(Images.getImage(isDarkMode ? FileConstants.brightnessHighIcon : FileConstants.moonIcon));

        }

        if(IMGThemeHover != null){

            IMGThemeHover.setImage(Images.getImage(isDarkMode ? FileConstants.brightnessHighIconHover : FileConstants.moonIconHover));

        }

        if(IMGThemeInit != null){

            IMGThemeInit.setImage(Images.getImage(isDarkMode ? FileConstants.brightnessHighIconInit : FileConstants.moonIconInit));

        }

    }

    protected static void applyStylesToTitleBar(String background, String border, AnchorPane APTitleBar){

        if(APTitleBar != null){

            APTitleBar.setStyle(buildStylesForTitleBar(background, border));

        }

    }

    protected static String buildStylesForTitleBar(String background, String border) {

        StringBuilder styles = new StringBuilder();

        if (background != null && !background.isBlank()) {
            styles.append(Styles.backgroundColor).append(background).append(Styles.end);
        }

        if (border != null && !border.isBlank()) {

            styles.append(Styles.borderColor).append(border).append(Styles.end);

        }

        styles.append(Styles.backgroundRadius).append("10px 10px 0px 0px").append(Styles.end);
        styles.append(Styles.borderRadius).append("10px 10px 0px 0px").append(Styles.end);
        styles.append(Styles.borderWidth).append("0px 0px 1px 0px").append(Styles.end);

        return styles.toString();
    }


}
