package stylebuilder;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;
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

    //Fases de activación del correo
    private static String emailNotVerifiedBackground;
    private static String emailNotVerifiedBorder;
    private static String emailNotVerifiedFontColor;

    //Toast notification
    private static String toastNotificationBackground;
    private static String toastNotificationBorder;

    //Popup Card
    private static String popupCardBackground;
    private static String popupCardBorder;

    //Popup Card Button
    private static String popupCardButtonBackground;
    private static String popupCardButtonBorder;
    private static String popupCardButtonFontColor;

    //PopupTitleBarButton
    private static String popupTitleBarCloseButtonBackground;
    private static String popupTitleBarCloseButtonBorder;
    private static String popupTitleBarCloseButtonFontColor;

    //PopupThirdButton
    private static String popupThirdButtonBackground;
    private static String popupThirdButtonBorder;
    private static String popupThirdButtonFontColor;

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

        //Toast Notifications
        toastNotificationBackground = Colors.getColor("toast-notification-background", isDarkMode);
        toastNotificationBorder = Colors.getColor("toast-notification-border", isDarkMode);

        //Popup card
        popupCardBackground = Colors.getColor("popup-card-background", isDarkMode);
        popupCardBorder = Colors.getColor("popup-card-border", isDarkMode);

        //Popup Card Button
        popupCardButtonBackground = Colors.getColor("popup-card-button-background", isDarkMode);
        popupCardButtonBorder = Colors.getColor("popup-card-button-border", isDarkMode);
        popupCardButtonFontColor = Colors.getColor("popup-card-button-font-color", isDarkMode);

        //PopupTitleBarButton
        popupTitleBarCloseButtonBackground = Colors.getColor("popup-title-bar-close-button-background", isDarkMode);
        popupTitleBarCloseButtonBorder = Colors.getColor("popup-title-bar-close-button-border", isDarkMode);
        popupTitleBarCloseButtonFontColor = Colors.getColor("popup-title-bar-close-button-font-color", isDarkMode);

        //PopupThirdButton
        popupThirdButtonBackground = Colors.getColor("popup-third-button-background", isDarkMode);
        popupThirdButtonBorder = Colors.getColor("popup-third-button-border", isDarkMode);
        popupThirdButtonFontColor = Colors.getColor("popup-third-button-font-color", isDarkMode);

    }

    public static void configureNodesForPopupSecurityCodesController(Button BTNClose, Button BTNCopy1, Button BTNCopy2, Button BTNCopy3, Button BTNCopy4, Button BTNCopy5, Button BTNCopy6, Button BTNCopy7, Button BTNCopy8, Button BTNCopy9, Button BTNCopy10, Button BTNCopyAllCodes, Button BTNDownloadCodes, Button BTNGenerateNewCodes, ImageView IMGButtonCopy1, ImageView IMGButtonCopy1Hover, ImageView IMGButtonCopy2, ImageView IMGButtonCopy2Hover, ImageView IMGButtonCopy3, ImageView IMGButtonCopy3Hover, ImageView IMGButtonCopy4, ImageView IMGButtonCopy4Hover, ImageView IMGButtonCopy5, ImageView IMGButtonCopy5Hover, ImageView IMGButtonCopy6, ImageView IMGButtonCopy6Hover, ImageView IMGButtonCopy7, ImageView IMGButtonCopy7Hover, ImageView IMGButtonCopy8, ImageView IMGButtonCopy8Hover, ImageView IMGButtonCopy9, ImageView IMGButtonCopy9Hover, ImageView IMGButtonCopy10, ImageView IMGButtonCopy10Hover, ImageView IMGCopyAllCodes, ImageView IMGCopyAllCodesHover, ImageView IMGDownloadCodes, ImageView IMGDownloadCodesHover, ImageView IMGGenerateNewCodes, ImageView IMGGenerateNewCodesHover, ImageView IMGIconSecurity, ImageView IMGIcon, Label LBLButtonCopy1, Label LBLButtonCopy2, Label LBLButtonCopy3, Label LBLButtonCopy4, Label LBLButtonCopy5, Label LBLButtonCopy6, Label LBLButtonCopy7, Label LBLButtonCopy8, Label LBLButtonCopy9, Label LBLButtonCopy10, Label LBLCopyAllCodes, Label LBLDownloadCodes, Label LBLGenerateNewCodes, StackPane SPCode1, StackPane SPCode2, StackPane SPCode3, StackPane SPCode4, StackPane SPCode5, StackPane SPCode6, StackPane SPCode7, StackPane SPCode8, StackPane SPCode9, StackPane SPCode10, boolean isDM){

        changeColors(isDM);

        applyStylesToContents(popupCardBackground, popupCardBorder, Styles.px2, Styles.px10,SPCode1, SPCode2, SPCode3, SPCode4, SPCode5, SPCode6, SPCode7, SPCode8, SPCode9, SPCode10);

        applyStylesToLabels(principalButtonFontColor, Styles.px12, LBLDownloadCodes);

        applyStylesToLabels(secondaryButtonFontColor, Styles.px12, LBLCopyAllCodes);

        applyStylesToLabels(popupThirdButtonFontColor, Styles.px12, LBLGenerateNewCodes);

        applyStylesToLabels(popupCardButtonFontColor, Styles.px12, LBLButtonCopy1, LBLButtonCopy2, LBLButtonCopy3, LBLButtonCopy4, LBLButtonCopy5, LBLButtonCopy6, LBLButtonCopy7, LBLButtonCopy8, LBLButtonCopy9, LBLButtonCopy10);

        setImages(FileConstants.shieldIconDm, FileConstants.shieldIconLm, isDM, IMGIconSecurity, IMGIcon);

        setImages(FileConstants.arrowClockwisePopupThirdLmdmnormalhover, FileConstants.arrowClockwisePopupThirdLmdmnormalhover, isDM, IMGGenerateNewCodes, IMGGenerateNewCodesHover);

        setImages(FileConstants.filetypePdfPrincipalHoverDm, FileConstants.filetypePdfPrincipalHoverLm, isDM, IMGDownloadCodesHover);

        setImages(FileConstants.filetypePdfPrincipalDm, FileConstants.filetypePdfPrincipalLm, isDM, IMGDownloadCodes);

        setImages(FileConstants.copySecondaryHoverDm, FileConstants.copySecondaryHoverLm, isDM, IMGCopyAllCodesHover);

        setImages(FileConstants.copySecondaryDm, FileConstants.copySecondaryLm, isDM, IMGCopyAllCodes);

        setImages(FileConstants.copyPopupCardButtonHoverDm, FileConstants.copyPopupCardButtonHoverLm, isDM, IMGButtonCopy1Hover, IMGButtonCopy2Hover, IMGButtonCopy3Hover, IMGButtonCopy4Hover, IMGButtonCopy5Hover, IMGButtonCopy6Hover, IMGButtonCopy7Hover, IMGButtonCopy8Hover, IMGButtonCopy9Hover, IMGButtonCopy10Hover);

        setImages(FileConstants.copyPopupCardButtonDm, FileConstants.copyPopupCardButtonLm, isDM, IMGButtonCopy1, IMGButtonCopy2, IMGButtonCopy3, IMGButtonCopy4, IMGButtonCopy5, IMGButtonCopy6, IMGButtonCopy7, IMGButtonCopy8, IMGButtonCopy9, IMGButtonCopy10);

        applyStylesToButtons(popupThirdButtonBackground, popupThirdButtonBorder, popupThirdButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNGenerateNewCodes);

        applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNDownloadCodes);

        applyStylesToButtons(secondaryButtonBackground, secondaryButtonBorder, secondaryButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNCopyAllCodes);

        applyStylesToButtons(popupCardButtonBackground, popupCardButtonBorder, popupCardButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNCopy1, BTNCopy2, BTNCopy3, BTNCopy4, BTNCopy5, BTNCopy6, BTNCopy7, BTNCopy8, BTNCopy9, BTNCopy10);

        applyStylesToButtons(popupTitleBarCloseButtonBackground, popupTitleBarCloseButtonBorder, popupTitleBarCloseButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNClose);

    }

    public static void configureNodesForPopupVerifyEmailController(AnchorPane APResendEmail, Button BTNClose, Button BTNVerifyEmail, ImageView IMGIcon, ImageView IMGResendEmail, ImageView IMGResendEmailHover, ImageView IMGTimeRemaining, Label LBLResendEmail, Label LBLTimeRemainingDays, Label LBLTimeRemainingTitle, StackPane SPTimeRemaining, StackPane SPToast, boolean isDM, boolean allConditionsMet, boolean theUserCanForwardTheEmail, long daysThatHavePassed ){

        changeColors(isDM);

        setImages(

                daysThatHavePassed >= 0 && daysThatHavePassed < 6 ? FileConstants.calendarTimeRemainingFirstFaseIconDm :
                        daysThatHavePassed >=6 &&  daysThatHavePassed < 10 ? FileConstants.calendarTimeRemainingSecondFaseIcon :
                                FileConstants.calendarTimeRemainingThirdFaseIcon,
                daysThatHavePassed >= 0 && daysThatHavePassed < 6 ? FileConstants.calendarTimeRemainingFirstFaseIconLm :
                        daysThatHavePassed >=6 &&  daysThatHavePassed < 10 ? FileConstants.calendarTimeRemainingSecondFaseIcon :
                                FileConstants.calendarTimeRemainingThirdFaseIcon,
                isDM, IMGTimeRemaining


        );

        emailNotVerifiedBackground = Colors.getColor(

                daysThatHavePassed >= 0 && daysThatHavePassed < 6 ? "email-not-verified-first-fase-background":
                        daysThatHavePassed >=6 &&  daysThatHavePassed < 10 ? "email-not-verified-second-fase-background":
                                "email-not-verified-third-fase-background"
                , isDM

        );
        emailNotVerifiedBorder = Colors.getColor(

                daysThatHavePassed >= 0 && daysThatHavePassed < 6 ? "email-not-verified-first-fase-border":
                        daysThatHavePassed >=6 &&  daysThatHavePassed < 10 ? "email-not-verified-second-fase-border":
                                "email-not-verified-third-fase-border"
                , isDM

        );
        emailNotVerifiedFontColor = Colors.getColor(

                daysThatHavePassed >= 0 && daysThatHavePassed < 6 ? "email-not-verified-first-fase-font-color":
                        daysThatHavePassed >=6 &&  daysThatHavePassed < 10 ? "email-not-verified-second-fase-font-color":
                                "email-not-verified-third-fase-font-color"
                , isDM

        );

        applyStylesToContents(toastNotificationBackground, toastNotificationBorder, Styles.px1, Styles.px10, SPToast);

        applyStylesToContents(emailNotVerifiedBackground, emailNotVerifiedBorder, Styles.px1, Styles.px10, SPTimeRemaining);

        setImages(FileConstants.sendSecondaryHoverDm, FileConstants.sendSecondaryHoverLm, isDM, IMGResendEmailHover);

        setImages(FileConstants.sendSecondaryDm, FileConstants.sendSecondaryLm, isDM, IMGResendEmail);

        setImages(FileConstants.atIconDm, FileConstants.atIconLm, isDM, IMGIcon);

        LBLTimeRemainingDays.setStyle(

                buildStylesForLabels((daysThatHavePassed >= 15 ? "#ffffffff" : emailNotVerifiedFontColor), Styles.px12) +
                        Styles.borderColor + emailNotVerifiedFontColor + Styles.end +
                        Styles.borderWidth + Styles.px1 + Styles.end +
                        Styles.borderRadius + Styles.px10 + Styles.end +
                        Styles.backgroundColor + (daysThatHavePassed >= 15 ? emailNotVerifiedFontColor : "#00000000") + Styles.end +
                        Styles.backgroundRadius + Styles.px10 + Styles.end +
                        Styles.padding + "2 6;"
        );

        applyStylesToLabels(emailNotVerifiedFontColor, Styles.px12, LBLTimeRemainingTitle);

        if(allConditionsMet){

            applyStylesToButtons(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNVerifyEmail);
            BTNVerifyEmail.setOpacity(1.0);

        }else{

            applyStylesToButtons(buttonBackgroundDisabled, buttonBorderDisabled, buttonFontColorDisabled, Styles.px12, Styles.px1, Styles.px10, BTNVerifyEmail);
            BTNVerifyEmail.setOpacity(0.66);

        }

        applyStylesToButtons(hideButtonBackground, hideButtonBorder, hideButtonFontColor, Styles.px12, Styles.px1,Styles.px10, BTNClose);

        if(theUserCanForwardTheEmail){

            applyStylesToContents(secondaryButtonBackground, secondaryButtonBorder, Styles.px1, Styles.px10,APResendEmail);
            applyStylesToLabels(secondaryButtonFontColor, Styles.px12, LBLResendEmail);
            LBLResendEmail.setOpacity(1);
            APResendEmail.setOpacity(1);

        }else{

            applyStylesToContents(buttonBackgroundDisabled, buttonBorderDisabled, Styles.px1, Styles.px10, APResendEmail);
            applyStylesToLabels(buttonFontColorDisabled, Styles.px12, LBLResendEmail);
            LBLResendEmail.setOpacity(0.66);
            APResendEmail.setOpacity(0.66);

        }

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
