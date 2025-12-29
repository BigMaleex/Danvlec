package stylebuilder;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import utilities.Colors;
import utilities.FileConstants;
import utilities.Images;
import utilities.Styles;

public class ConfigureNodes {

    //Botón secundario
    private static String secondaryButtonBackground;
    private static String secondaryButtonBorder;
    private static String secondaryButtonFontColor;

    //Botón primario
    private static String principalButtonBackground;
    private static String principalButtonBorder;
    private static String principalButtonFontColor;

    //Botón oculto
    private static String hideButtonBackground;
    private static String hideButtonBorder;
    private static String hideButtonFontColor;

    //Botón desactivado
    private static String buttonBackgroundDisabled;
    private static String buttonBorderDisabled;
    private static String buttonFontColorDisabled;

    //Tarjetas
    private static String cardBackground;
    private static String cardBorder;

    //Barra de título
    private static String titleBarBackgroundWithoutFocus;
    private static String titleBarBorderWithoutFocus;
    private static String titleBarFontColorWithoutFocus;

    //Botón principal de la barra de título
    private static String titleBarButtonBackgroundWithoutFocus;
    private static String titleBarButtonBorderWithoutFocus;
    private static String titleBarButtonFontColorWithoutFocus;

    //Botón para cerrar de la barra de título
    private static String titleBarCloseButtonBackgroundWithoutFocus;
    private static String titleBarCloseButtonBorderWithoutFocus;
    private static String titleBarCloseButtonFontColorWithoutFocus;

    //ToolTip
    private static String tooltipBackground;
    private static String tooltipBorder;
    private static String tooltipFontColor;

    private static void changeColors(boolean isDarkMode){

        //Botón secundario
        secondaryButtonBackground = Colors.getColor("secondary-button-background", isDarkMode);
        secondaryButtonBorder = Colors.getColor("secondary-button-border", isDarkMode);
        secondaryButtonFontColor = Colors.getColor("secondary-button-font-color", isDarkMode);

        //Botón primario
        principalButtonBackground = Colors.getColor("principal-button-background", isDarkMode);
        principalButtonBorder = Colors.getColor("principal-button-border", isDarkMode);
        principalButtonFontColor = Colors.getColor("principal-button-font-color", isDarkMode);

        //Botón oculto
        hideButtonBackground = Colors.getColor("hide-button-background", isDarkMode);
        hideButtonBorder = Colors.getColor("hide-button-border", isDarkMode);
        hideButtonFontColor = Colors.getColor("hide-button-font-color", isDarkMode);

        //Botón desactivado
        buttonBackgroundDisabled = Colors.getColor("button-background-disabled", isDarkMode);
        buttonBorderDisabled = Colors.getColor("button-border-disabled", isDarkMode);
        buttonFontColorDisabled = Colors.getColor("button-font-color-disabled", isDarkMode);

        //Tarjetas
        cardBackground = Colors.getColor("card-background", isDarkMode);
        cardBorder = Colors.getColor("card-border-color", isDarkMode);

        //Barra de título
        titleBarBackgroundWithoutFocus = Colors.getColor("title-bar-background-without-focus", isDarkMode);
        titleBarBorderWithoutFocus = Colors.getColor("title-bar-border-without-focus", isDarkMode);
        titleBarFontColorWithoutFocus = Colors.getColor("title-bar-font-color-whithout-focus", isDarkMode);

        //Botón principal de la barra de título
        titleBarButtonBackgroundWithoutFocus = Colors.getColor("title-bar-button-background-without-focus", isDarkMode);
        titleBarButtonBorderWithoutFocus = Colors.getColor("title-bar-button-border-without-focus", isDarkMode);
        titleBarButtonFontColorWithoutFocus = Colors.getColor("title-bar-button-font-color-without-focus", isDarkMode);

        //Botón para cerrar de la barra de título
        titleBarCloseButtonBackgroundWithoutFocus = Colors.getColor("title-bar-close-button-background-without-focus", isDarkMode);
        titleBarCloseButtonBorderWithoutFocus = Colors.getColor("title-bar-close-button-border-without-focus", isDarkMode);
        titleBarCloseButtonFontColorWithoutFocus = Colors.getColor("title-bar-close-button-font-color-without-focus", isDarkMode);

        //Tooltip
        tooltipBackground = Colors.getColor("tooltip-background", isDarkMode);
        tooltipBorder = Colors.getColor("tooltip-border", isDarkMode);
        tooltipFontColor = Colors.getColor("tooltip-font-color", isDarkMode);

    }

    public static void configureNodesForLoginController(AnchorPane APTitleBar, Button BTNBack, Button BTNClose, Button BTNLogin, Button BTNMinimize, ImageView IMGEmail, ImageView IMGIcon, StackPane SPPassword, ImageView IMGPasswordIcon, ImageView IMGPasswordIconHover, ImageView IMGShield, ImageView IMGTheme, ImageView IMGThemeHover, ImageView IMGThemeInit, Label LBLTitleBar, StackPane SPTheme, boolean isDM, boolean allConditionsMet, boolean passwordVisible){

        changeColors(isDM);

        addToolTip("Minimizar",  BTNMinimize);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), SPTheme);

        addToolTip("Cerrar", BTNClose);

        applyStylesToLabels(titleBarFontColorWithoutFocus, Styles.px14, LBLTitleBar);

        setThemeImages(IMGTheme, IMGThemeHover, IMGThemeInit, isDM);

        setImages(FileConstants.shieldIconDm, FileConstants.shieldIconLm, isDM, IMGShield);

        applyStylesToContents(hideButtonBackground, hideButtonBorder, Styles.px1, Styles.px10, SPPassword);

        setPasswordImages(

                FileConstants.eyeThirdDm, FileConstants.eyeThirdHoverDm,
                FileConstants.eyeThirdLm, FileConstants.eyeThirdHoverLm,
                FileConstants.eyeSlashThirdDm, FileConstants.eyeSlashThirdHoverDm,
                FileConstants.eyeSlashThirdLm, FileConstants.eyeSlashThirdHoverLm,
                isDM, passwordVisible, IMGPasswordIcon, IMGPasswordIconHover

        );

        setImages(FileConstants.personIconDm, FileConstants.personIconLm, isDM, IMGIcon);

        setImages(FileConstants.envelopeAtIconDm, FileConstants.envelopeAtIconLm, isDM, IMGEmail);

        if(allConditionsMet){

            applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNLogin);
            BTNLogin.setOpacity(1.0);

        }else{

            applyStylesToButtons(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, BTNLogin);
            BTNLogin.setOpacity(0.66);

        }

        applyStylesToButtons(titleBarButtonBackgroundWithoutFocus, titleBarButtonBorderWithoutFocus, titleBarButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNMinimize);

        applyStylesToButtons(titleBarCloseButtonBackgroundWithoutFocus, titleBarCloseButtonBorderWithoutFocus, titleBarCloseButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNClose);

        applyStylesToButtons(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNBack);

        applyStylesToTitleBar(titleBarBackgroundWithoutFocus, titleBarBorderWithoutFocus, APTitleBar);

    }

    public static void configureNodesForSignUpController(AnchorPane APTitleBar, Button BTNBack, Button BTNClose, Button BTNMinimize, Button BTNSignUp, ImageView IMGBirthday, ImageView IMGConfirmPasswordIcon, ImageView IMGConfirmPasswordIconHover, ImageView IMGConfirmShield, ImageView IMGEmail, ImageView IMGIcon, ImageView IMGLastname, ImageView IMGName, ImageView IMGNickname, ImageView IMGPasswordIcon, ImageView IMGPasswordIconHover, ImageView IMGShield, ImageView IMGTheme, ImageView IMGThemeHover, ImageView IMGThemeInit, Label LBLTitleBar, StackPane SPTheme, ToggleButton TBTToggle, StackPane SPPassword, StackPane SPConfirmPassword, boolean isDM, boolean allConditionsMet, boolean passwordVisible, boolean confirmPasswordVisible){

        changeColors(isDM);

        addToolTip("Minimizar",  BTNMinimize);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), SPTheme);

        addToolTip("Cerrar", BTNClose);

        applyStylesToContents(hideButtonBackground, hideButtonBorder, Styles.px1, Styles.px10, SPConfirmPassword, SPPassword);

        applyStylesToContents(titleBarButtonBackgroundWithoutFocus, titleBarButtonBorderWithoutFocus, Styles.px1, Styles.px10, SPTheme);

        setThemeImages(IMGTheme, IMGThemeHover, IMGThemeInit, isDM);

        applyStylesToLabels(titleBarFontColorWithoutFocus, Styles.px14, LBLTitleBar);

        setImages(FileConstants.atIconDm, FileConstants.atIconLm, isDM, IMGNickname);

        setImages(FileConstants.personIconDm, FileConstants.personIconLm, isDM, IMGName, IMGLastname);

        setImages(FileConstants.personAddIconDm, FileConstants.personAddIconLm, isDM, IMGIcon);

        setImages(FileConstants.envelopeAtIconDm, FileConstants.envelopeAtIconLm, isDM, IMGEmail);

        setImages(FileConstants.shieldIconDm, FileConstants.shieldIconLm, isDM, IMGShield, IMGConfirmShield);

        setPasswordImages(

                FileConstants.eyeThirdDm, FileConstants.eyeThirdHoverDm,
                FileConstants.eyeThirdLm, FileConstants.eyeThirdHoverLm,
                FileConstants.eyeSlashThirdDm, FileConstants.eyeSlashThirdHoverDm,
                FileConstants.eyeSlashThirdLm, FileConstants.eyeSlashThirdHoverLm,
                isDM, confirmPasswordVisible,
                IMGConfirmPasswordIcon, IMGConfirmPasswordIconHover

        );

        setPasswordImages(

                FileConstants.eyeThirdDm, FileConstants.eyeThirdHoverDm,
                FileConstants.eyeThirdLm, FileConstants.eyeThirdHoverLm,
                FileConstants.eyeSlashThirdDm, FileConstants.eyeSlashThirdHoverDm,
                FileConstants.eyeSlashThirdLm, FileConstants.eyeSlashThirdHoverLm,
                isDM, passwordVisible,
                IMGPasswordIcon, IMGPasswordIconHover

        );

        setImages(FileConstants.cakeIconDm, FileConstants.cakeIconLm, isDM, IMGBirthday);

        if(allConditionsMet){

            applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNSignUp);
            BTNSignUp.setOpacity(1.0);

        }else{

            applyStylesToButtons(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, BTNSignUp);
            BTNSignUp.setOpacity(0.66);

        }

        applyStylesToButtons(titleBarButtonBackgroundWithoutFocus, titleBarButtonBorderWithoutFocus, titleBarButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNMinimize);

        applyStylesToButtons(titleBarCloseButtonBackgroundWithoutFocus, titleBarCloseButtonBorderWithoutFocus, titleBarCloseButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNClose);

        applyStylesToButtons(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, TBTToggle, BTNBack);

        applyStylesToTitleBar(titleBarBackgroundWithoutFocus, titleBarBorderWithoutFocus, APTitleBar);

    }

    public static void configureNodesForGuestController(AnchorPane APTitleBar, Button BTNBack, Button BTNClose, Button BTNGuest, Button BTNMinimize, ImageView IMGBirthday, ImageView IMGExplanation, ImageView IMGIcon, ImageView IMGLastname, ImageView IMGName, ImageView IMGNickname, ImageView IMGTheme, ImageView IMGThemeHover, ImageView IMGThemeInit, Label LBLTitleBar, StackPane SPTheme, ToggleButton TBTToggle, boolean isDM, boolean allConditionsMet){

        changeColors(isDM);

        addToolTip("Minimizar", BTNMinimize);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), SPTheme);

        addToolTip("Cerrar", BTNClose);

        applyStylesToButtons(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, TBTToggle, BTNBack);

        applyStylesToContents(titleBarButtonBackgroundWithoutFocus, titleBarButtonBorderWithoutFocus, Styles.px1, Styles.px10, SPTheme);

        setThemeImages(IMGTheme, IMGThemeHover, IMGThemeInit, isDM);

        applyStylesToLabels(titleBarFontColorWithoutFocus, Styles.px14, LBLTitleBar);

        setImages(FileConstants.atIconDm, FileConstants.atIconLm, isDM, IMGNickname);

        setImages(FileConstants.personIconDm, FileConstants.personIconLm, isDM, IMGName, IMGLastname);

        setImages(FileConstants.heartIconDm, FileConstants.heartIconLm, isDM, IMGExplanation, IMGIcon);

        setImages(FileConstants.cakeIconDm, FileConstants.cakeIconLm, isDM, IMGBirthday);

        applyStylesToButtons(titleBarButtonBackgroundWithoutFocus, titleBarButtonBorderWithoutFocus, titleBarButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNMinimize);

        if(allConditionsMet){

            applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNGuest);
            BTNGuest.setOpacity(1.0);

        }else{

            applyStylesToButtons(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, BTNGuest);
            BTNGuest.setOpacity(0.66);

        }

        applyStylesToButtons(titleBarCloseButtonBackgroundWithoutFocus, titleBarCloseButtonBorderWithoutFocus, titleBarCloseButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNClose);

        applyStylesToTitleBar(titleBarBackgroundWithoutFocus, titleBarBorderWithoutFocus, APTitleBar);

    }

    public static void configureNodesForAccountMenuController(AnchorPane APGuest, AnchorPane APLogin, AnchorPane APSignUp, AnchorPane APTitleBar, Button BTNClose, Button BTNGuest, Button BTNLogin, Button BTNMinimize, Button BTNSignUp, ImageView IMGAddUser, ImageView IMGHeart, ImageView IMGLogin, ImageView IMGTheme, ImageView IMGThemeHover, ImageView IMGThemeInit, Label LBLTitleBar, StackPane SPTheme, boolean isDM){

        changeColors(isDM);

        addToolTip("Minimizar", BTNMinimize);

        addToolTip("Cerrar", BTNClose);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), SPTheme);

        applyStylesToContents(cardBackground, cardBorder, Styles.px1, Styles.px10, APGuest, APLogin, APSignUp);

        applyStylesToTitleBar(titleBarBackgroundWithoutFocus, titleBarBorderWithoutFocus, APTitleBar);

        applyStylesToButtons(titleBarButtonBackgroundWithoutFocus, titleBarButtonBorderWithoutFocus, titleBarButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNMinimize);

        applyStylesToButtons(titleBarCloseButtonBackgroundWithoutFocus, titleBarCloseButtonBorderWithoutFocus, titleBarCloseButtonFontColorWithoutFocus, Styles.px12, Styles.px1, Styles.px10, BTNClose);

        applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNLogin);

        applyStylesToButtons(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNSignUp, BTNGuest);

        setImages(FileConstants.personAddIconDm, FileConstants.personAddIconLm, isDM, IMGAddUser);

        setImages(FileConstants.heartIconDm, FileConstants.heartIconLm, isDM, IMGHeart);

        setImages(FileConstants.personIconDm, FileConstants.personIconLm, isDM, IMGLogin);

        setThemeImages(IMGTheme, IMGThemeHover, IMGThemeInit, isDM);

        applyStylesToLabels(titleBarFontColorWithoutFocus, Styles.px14, LBLTitleBar);

        applyStylesToContents(titleBarButtonBackgroundWithoutFocus, titleBarButtonBorderWithoutFocus, Styles.px1, Styles.px10, SPTheme);

    }

    public static void configureNodesForPopupTwoButtonController(Button BTNAccept, Button BTNCancel, boolean isDM){

        changeColors(isDM);

        applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNAccept);

        applyStylesToButtons(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNCancel);

    }

    public static void configureNodesForPopupOneButtonController(Button BTNAccept, boolean isDM){

        changeColors(isDM);

        applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNAccept);

    }

    public static void configureNodesForPopupChangeIPController(Button BTNChangeIP, Button BTNClose, ImageView IMGIcon, boolean isDM, boolean allConditionsMet){

        changeColors(isDM);

        setImages(FileConstants.arrowLeftRightIconDm, FileConstants.arrowLeftRightIconLm, isDM, IMGIcon);

        applyStylesToButtons(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNClose);

        if(allConditionsMet){

            applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNChangeIP);
            BTNChangeIP.setOpacity(1.0);

        }else{

            applyStylesToButtons(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, BTNChangeIP);
            BTNChangeIP.setOpacity(0.66);

        }

    }

    public static void configureNodesForPopupBDErrController(AnchorPane APChangeIP, AnchorPane APContinue, AnchorPane APCopy, AnchorPane APReload, Button BTNClose, ImageView IMGChangeIPIcon, ImageView IMGChangeIPIconHover, ImageView IMGContinue, ImageView IMGContinueHover, ImageView IMGCopy, ImageView IMGCopyHover, ImageView IMGOfflineMode, ImageView IMGReload, ImageView IMGReloadHover, Label LBLChangeIP, Label LBLContinue, Label LBLCopy, Label LBLReload, boolean isDM){

        changeColors(isDM);

        applyStylesToContents(secondaryButtonBackground, secondaryButtonBorder, Styles.px1, Styles.px10, APChangeIP, APContinue, APCopy);
        applyStylesToContents(principalButtonBackground, principalButtonBorder, Styles.px1, Styles.px10, APReload);

        applyStylesToButtons(hideButtonBackground, hideButtonBorder, hideButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNClose);

        setImages(FileConstants.reception4SecondaryDM, FileConstants.reception4SecondaryLM, isDM, IMGChangeIPIcon);
        setImages(FileConstants.reception4SecondaryHoverDM, FileConstants.reception4SecondaryHoverLM, isDM, IMGChangeIPIconHover);

        setImages(FileConstants.wifiOffSecondaryDM, FileConstants.wifiOffSecondaryLM, isDM, IMGContinue);
        setImages(FileConstants.wifiOffSecondaryHoverDM, FileConstants.wifiOffSecondaryHoverLM, isDM, IMGContinueHover);

        setImages(FileConstants.clipboardSecondaryDm, FileConstants.clipboardSecondaryLm, isDM, IMGCopy);
        setImages(FileConstants.clipboardSecondaryHoverDm, FileConstants.clipboardSecondaryHoverLm, isDM, IMGCopyHover);

        setImages(FileConstants.globeIconDm, FileConstants.globeIconLm, isDM, IMGOfflineMode);

        setImages(FileConstants.arrowClockwisePrimaryDm, FileConstants.arrowClockwisePrimaryLm, isDM, IMGReload);
        setImages(FileConstants.arrowClockwisePrimaryHoverDm, FileConstants.arrowClockwisePrimaryHoverLm, isDM, IMGReloadHover);

        applyStylesToLabels(secondaryButtonFontColor, Styles.px12, LBLChangeIP, LBLContinue, LBLCopy);

        applyStylesToLabels(principalButtonFontColor, Styles.px12, LBLReload);

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

    private static String buildStylesForContents(String background, String border, String borderWidth, String radius){

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

    private static String buildStylesForButtons(String background, String border, String fontColor, String fontSize, String borderWidth, String radius){

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

    private static String buildStylesForLabels(String fontColor, String fontSize){

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

    private static void setPasswordImages(String darkVisible, String darkVisibleHover, String lightVisible, String lightVisibleHover, String darkHide, String darkHideHover, String lightHide, String lightHideHover, boolean isDarkMode, boolean visible, ImageView image, ImageView imageHover){

        if(visible){

            setImages(darkVisible, lightVisible, isDarkMode, image);
            setImages(darkVisibleHover, lightVisibleHover, isDarkMode, imageHover);

        }else{

            setImages(darkHide, lightHide, isDarkMode, image);
            setImages(darkHideHover, lightHideHover, isDarkMode, imageHover);

        }

    }

    private static void addToolTip(String message, Node... nodes){

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

    private static void setThemeImages(ImageView IMGTheme, ImageView IMGThemeHover, ImageView IMGThemeInit, boolean isDarkMode){

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

    private static String buildStylesForTitleBar(String background, String border) {

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
