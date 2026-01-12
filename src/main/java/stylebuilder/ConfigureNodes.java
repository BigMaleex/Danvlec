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

public class ConfigureNodes extends ConfigureInitializeStyles{

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

    //PopupToggleButton
    private static String popupToggleButtonBackground;
    private static String popupToggleButtonBorder;
    private static String popupToggleButtonFontColor;

    private static String popupToggleButtonBackgroundHover;
    private static String popupToggleButtonBorderHover;
    private static String popupToggleButtonFontColorHover;

    private static String popupToggleButtonBackgroundActive;
    private static String popupToggleButtonBorderActive;
    private static String popupToggleButtonFontColorActive;

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

        //PopupToggleButton
        popupToggleButtonBackground = Colors.getColor("popup-toggle-button-background", isDarkMode);
        popupToggleButtonBorder = Colors.getColor("popup-toggle-button-border", isDarkMode);
        popupToggleButtonFontColor = Colors.getColor("popup-toggle-button-font-color", isDarkMode);

        popupToggleButtonBackgroundHover = Colors.getColor("popup-toggle-button-background-hover", isDarkMode);
        popupToggleButtonBorderHover = Colors.getColor("popup-toggle-button-border-hover", isDarkMode);
        popupToggleButtonFontColorHover = Colors.getColor("popup-toggle-button-font-color-hover", isDarkMode);

        popupToggleButtonBackgroundActive = Colors.getColor("popup-toggle-button-background-active", isDarkMode);
        popupToggleButtonBorderActive = Colors.getColor("popup-toggle-button-border-active", isDarkMode);
        popupToggleButtonFontColorActive = Colors.getColor("popup-toggle-button-font-color-active", isDarkMode);

    }

    public static void configureNodesForPopupSetClockController(Button BTNClose, Button BTNStart, ImageView IMGDate, ImageView IMGDateHour, ImageView IMGFocus1, ImageView IMGFocus2, ImageView IMGFocus3, ImageView IMGFocus4, ImageView IMGFocus5, ImageView IMGHabits1, ImageView IMGHabits2, ImageView IMGHabits3, ImageView IMGHabits4, ImageView IMGHabits5, ImageView IMGHour, ImageView IMGIcon, ImageView IMGOther, ImageView IMGPersonalGrowth1, ImageView IMGPersonalGrowth2, ImageView IMGPersonalGrowth3, ImageView IMGPersonalGrowth4, ImageView IMGPersonalGrowth5, ImageView IMGRelations1, ImageView IMGRelations2, ImageView IMGRelations3, ImageView IMGRelations4, ImageView IMGRelations5, ImageView IMGSubIcon, ImageView IMGStart, ImageView IMGStartHover, ImageView IMGTech1, ImageView IMGTech2, ImageView IMGTech3, ImageView IMGTech4, Label LBLFocus1, Label LBLFocus2, Label LBLFocus3, Label LBLFocus4, Label LBLFocus5, Label LBLHabits1, Label LBLHabits2, Label LBLHabits3, Label LBLHabits4, Label LBLHabits5, Label LBLOther, Label LBLPersonalGrowth1, Label LBLPersonalGrowth2, Label LBLPersonalGrowth3, Label LBLPersonalGrowth4, Label LBLPersonalGrowth5, Label LBLRelations1, Label LBLRelations2, Label LBLRelations3, Label LBLRelations4, Label LBLRelations5, Label LBLStart, Label LBLTech1, Label LBLTech2, Label LBLTech3, Label LBLTech4, StackPane SPDate, StackPane SPDateHourSelector, StackPane SPOther, ToggleButton TBTButtonFocus1, ToggleButton TBTButtonFocus2, ToggleButton TBTButtonFocus3, ToggleButton TBTButtonFocus4, ToggleButton TBTButtonFocus5, ToggleButton TBTButtonHabits1, ToggleButton TBTButtonHabits2, ToggleButton TBTButtonHabits3, ToggleButton TBTButtonHabits4, ToggleButton TBTButtonHabits5, ToggleButton TBTButtonOther, ToggleButton TBTButtonPersonalGrowth1, ToggleButton TBTButtonPersonalGrowth2, ToggleButton TBTButtonPersonalGrowth3, ToggleButton TBTButtonPersonalGrowth4, ToggleButton TBTButtonPersonalGrowth5, ToggleButton TBTButtonRelations1, ToggleButton TBTButtonRelations2, ToggleButton TBTButtonRelations3, ToggleButton TBTButtonRelations4, ToggleButton TBTButtonRelations5, ToggleButton TBTButtonTech1, ToggleButton TBTButtonTech2, ToggleButton TBTButtonTech3, ToggleButton TBTButtonTech4, ToggleButton TBTDateHour, boolean isDM){

        changeColors(isDM);

        

        applyStylesToContents(popupCardBackground, popupCardBorder, Styles.px1, Styles.px10, SPDate, SPDateHourSelector, SPOther);

        applyStylesToButtonsWithLabel(popupToggleButtonBackground, popupToggleButtonBorder, popupToggleButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase[] {TBTButtonFocus1, TBTButtonFocus2, TBTButtonFocus3, TBTButtonFocus4, TBTButtonFocus5, TBTButtonHabits1, TBTButtonHabits2, TBTButtonHabits3, TBTButtonHabits4, TBTButtonHabits5, TBTButtonOther, TBTButtonPersonalGrowth1, TBTButtonPersonalGrowth2, TBTButtonPersonalGrowth3, TBTButtonPersonalGrowth4, TBTButtonPersonalGrowth5, TBTButtonRelations1, TBTButtonRelations2, TBTButtonRelations3, TBTButtonRelations4, TBTButtonRelations5, TBTButtonTech1, TBTButtonTech2, TBTButtonTech3, TBTButtonTech4}, new Label [] {LBLFocus1, LBLFocus2, LBLFocus3, LBLFocus4, LBLFocus5, LBLHabits1, LBLHabits2, LBLHabits3, LBLHabits4, LBLHabits5, LBLOther, LBLPersonalGrowth1, LBLPersonalGrowth2, LBLPersonalGrowth3, LBLPersonalGrowth4, LBLPersonalGrowth5, LBLRelations1, LBLRelations2, LBLRelations3, LBLRelations4, LBLRelations5, LBLTech1, LBLTech2, LBLTech3, LBLTech4});

        setImages(FileConstants.bullseyeIconDm, FileConstants.bullseyeIconLm, isDM, IMGIcon, IMGSubIcon);

        setImages(FileConstants.hammerPrimaryHoverDm, FileConstants.hammerPrimaryHoverLm, isDM, IMGStartHover);

        setImages(FileConstants.hammerPrimaryDm, FileConstants.hammerPrimaryLm, isDM, IMGStart);

        setImages(FileConstants.clockIconDm, FileConstants.clockIconLm, isDM, IMGHour);

        setImages(FileConstants.checkCircleFillPopupToggleButtonActiveDM, FileConstants.checkCircleFillPopupToggleButtonActiveLM, isDM, IMGFocus1, IMGFocus2, IMGFocus3, IMGFocus4, IMGFocus5, IMGHabits1, IMGHabits2, IMGHabits3, IMGHabits4, IMGHabits5, IMGOther, IMGPersonalGrowth1, IMGPersonalGrowth2, IMGPersonalGrowth3, IMGPersonalGrowth4, IMGPersonalGrowth5, IMGRelations1, IMGRelations2, IMGRelations3, IMGRelations4, IMGRelations5,IMGTech1, IMGTech2, IMGTech3, IMGTech4);

        setImages(FileConstants.calendarTimeRemainingFirstFaseIconDm, FileConstants.calendarTimeRemainingFirstFaseIconLm, isDM, IMGDate, IMGDateHour);

        applyStylesToButtonsWithLabel(principalButtonBackground, principalButtonBorder, principalButtonFontColor, Styles.px12, Styles.px1, Styles.px10, new ButtonBase [] {BTNStart}, new Label [] {LBLStart});

        applyStylesToButtons(popupTitleBarCloseButtonBackground, popupTitleBarCloseButtonBorder, popupTitleBarCloseButtonFontColor, Styles.px12, Styles.px1, Styles.px10, BTNClose);

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

        addToolTip("Minimizar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNMinimize);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), tooltipBackground, tooltipBorder, tooltipFontColor, SPTheme);

        addToolTip("Cerrar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNClose);

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

        addToolTip("Minimizar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNMinimize);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), tooltipBackground, tooltipBorder, tooltipFontColor, SPTheme);

        addToolTip("Cerrar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNClose);

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

        addToolTip("Minimizar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNMinimize);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), tooltipBackground, tooltipBorder, tooltipFontColor, SPTheme);

        addToolTip("Cerrar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNClose);

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

        addToolTip("Minimizar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNMinimize);

        addToolTip("Cerrar", tooltipBackground, tooltipBorder, tooltipFontColor, BTNClose);

        addToolTip(("Cambiar al modo " + (!isDM ? "oscuro": "claro")), tooltipBackground, tooltipBorder, tooltipFontColor, SPTheme);

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

}
