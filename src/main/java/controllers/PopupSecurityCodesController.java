package controllers;

import connections.SecurityCodes;
import files.SecurityCodesFile;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import logical.ValidateOutputs;
import messagebuilder.Notifications;
import stylebuilder.ConfigureInitializeStyles;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.Colors;

public class PopupSecurityCodesController extends ConfigureInitializeStyles {

    //Variables
    private static boolean isDarkMode;
    private static String allCodes;

    //Variables de color
    //Botón primario
    private static String principalButtonBackground;
    private static String principalButtonBorder;
    private static String principalButtonFontColor;

    private static String principalButtonBackgroundHover;
    private static String principalButtonBorderHover;
    private static String principalButtonFontColorHover;

    //Botón secundario
    private static String secondaryButtonBackground;
    private static String secondaryButtonBorder;
    private static String secondaryButtonFontColor;

    private static String secondaryButtonBackgroundHover;
    private static String secondaryButtonBorderHover;
    private static String secondaryButtonFontColorHover;

    //Popup Card
    private static String popupCardBackground;
    private static String popupCardBorder;

    private static String popupCardBackgroundHover;
    private static String popupCardBorderHover;

    //Popup Card Button
    private static String popupCardButtonBackground;
    private static String popupCardButtonBorder;
    private static String popupCardButtonFontColor;

    private static String popupCardButtonBackgroundHover;
    private static String popupCardButtonBorderHover;
    private static String popupCardButtonFontColorHover;

    //PopupTitleBarButton
    private static String popupTitleBarCloseButtonBackground;
    private static String popupTitleBarCloseButtonBorder;
    private static String popupTitleBarCloseButtonFontColor;

    private static String popupTitleBarCloseButtonBackgroundHover;
    private static String popupTitleBarCloseButtonBorderHover;
    private static String popupTitleBarCloseButtonFontColorHover;

    //PopupThirdButton
    private static String popupThirdButtonBackground;
    private static String popupThirdButtonBorder;
    private static String popupThirdButtonFontColor;

    private static String popupThirdButtonBackgroundHover;
    private static String popupThirdButtonBorderHover;
    private static String popupThirdButtonFontColorHover;


    @FXML
    private AnchorPane APMain;

    @FXML
    private Button BTNClose;

    @FXML
    private Button BTNCopy1;

    @FXML
    private Button BTNCopy2;

    @FXML
    private Button BTNCopy3;

    @FXML
    private Button BTNCopy4;

    @FXML
    private Button BTNCopy5;

    @FXML
    private Button BTNCopy6;

    @FXML
    private Button BTNCopy7;

    @FXML
    private Button BTNCopy8;

    @FXML
    private Button BTNCopy9;

    @FXML
    private Button BTNCopy10;

    @FXML
    private Button BTNCopyAllCodes;

    @FXML
    private Button BTNDownloadCodes;

    @FXML
    private Button BTNGenerateNewCodes;

    @FXML
    private ImageView IMGButtonCopy1;

    @FXML
    private ImageView IMGButtonCopy1Hover;

    @FXML
    private ImageView IMGButtonCopy2;

    @FXML
    private ImageView IMGButtonCopy2Hover;

    @FXML
    private ImageView IMGButtonCopy3;

    @FXML
    private ImageView IMGButtonCopy3Hover;

    @FXML
    private ImageView IMGButtonCopy4;

    @FXML
    private ImageView IMGButtonCopy4Hover;

    @FXML
    private ImageView IMGButtonCopy5;

    @FXML
    private ImageView IMGButtonCopy5Hover;

    @FXML
    private ImageView IMGButtonCopy6;

    @FXML
    private ImageView IMGButtonCopy6Hover;

    @FXML
    private ImageView IMGButtonCopy7;

    @FXML
    private ImageView IMGButtonCopy7Hover;

    @FXML
    private ImageView IMGButtonCopy8;

    @FXML
    private ImageView IMGButtonCopy8Hover;

    @FXML
    private ImageView IMGButtonCopy9;

    @FXML
    private ImageView IMGButtonCopy9Hover;

    @FXML
    private ImageView IMGButtonCopy10;

    @FXML
    private ImageView IMGButtonCopy10Hover;

    @FXML
    private ImageView IMGCopyAllCodes;

    @FXML
    private ImageView IMGCopyAllCodesHover;

    @FXML
    private ImageView IMGDownloadCodes;

    @FXML
    private ImageView IMGDownloadCodesHover;

    @FXML
    private ImageView IMGGenerateNewCodes;

    @FXML
    private ImageView IMGGenerateNewCodesHover;

    @FXML
    private ImageView IMGIconSecurity;

    @FXML
    private ImageView IMGIcon;

    @FXML
    private Label LBLButtonCopy1;

    @FXML
    private Label LBLButtonCopy2;

    @FXML
    private Label LBLButtonCopy3;

    @FXML
    private Label LBLButtonCopy4;

    @FXML
    private Label LBLButtonCopy5;

    @FXML
    private Label LBLButtonCopy6;

    @FXML
    private Label LBLButtonCopy7;

    @FXML
    private Label LBLButtonCopy8;

    @FXML
    private Label LBLButtonCopy9;

    @FXML
    private Label LBLButtonCopy10;

    @FXML
    private Label LBLCode1;

    @FXML
    private Label LBLCode2;

    @FXML
    private Label LBLCode3;

    @FXML
    private Label LBLCode4;

    @FXML
    private Label LBLCode5;

    @FXML
    private Label LBLCode6;

    @FXML
    private Label LBLCode7;

    @FXML
    private Label LBLCode8;

    @FXML
    private Label LBLCode9;

    @FXML
    private Label LBLCode10;

    @FXML
    private Label LBLCopyAllCodes;

    @FXML
    private Label LBLDownloadCodes;

    @FXML
    private Label LBLGenerateNewCodes;

    @FXML
    private StackPane SPCode1;

    @FXML
    private StackPane SPCode2;

    @FXML
    private StackPane SPCode3;

    @FXML
    private StackPane SPCode4;

    @FXML
    private StackPane SPCode5;

    @FXML
    private StackPane SPCode6;

    @FXML
    private StackPane SPCode7;

    @FXML
    private StackPane SPCode8;

    @FXML
    private StackPane SPCode9;

    @FXML
    private StackPane SPCode10;

    @FXML
    private StackPane SPFooterBar;

    @FXML
    private StackPane SPTitleBar;

    //Arreglos
    private static Label[] codeLabels;
    private static Button[] copyButtons;
    private static boolean[] theUserCanCopyText = new boolean[10];

    @FXML
    private void initialize(){

        isDarkMode = UserPreferences.getUserThemeMode();


        codeLabels = new Label[]{
                LBLCode1, LBLCode2, LBLCode3, LBLCode4, LBLCode5,
                LBLCode6, LBLCode7, LBLCode8, LBLCode9, LBLCode10
        };

        copyButtons = new Button[]{
                BTNCopy1, BTNCopy2, BTNCopy3, BTNCopy4, BTNCopy5,
                BTNCopy6, BTNCopy7, BTNCopy8, BTNCopy9, BTNCopy10
        };

        hideNodes(IMGButtonCopy1Hover, IMGButtonCopy2Hover, IMGButtonCopy3Hover, IMGButtonCopy4Hover, IMGButtonCopy5Hover, IMGButtonCopy6Hover, IMGButtonCopy7Hover, IMGButtonCopy8Hover, IMGButtonCopy9Hover, IMGButtonCopy10Hover, IMGDownloadCodesHover, IMGGenerateNewCodesHover, IMGCopyAllCodesHover, BTNCopy1, BTNCopy2, BTNCopy3, BTNCopy4, BTNCopy5, BTNCopy6, BTNCopy7, BTNCopy8, BTNCopy9, BTNCopy10);


        changeTheme();

    }

    private void changeTheme(){

        changeColors();
        StyleBuilder.setAnchorPaneClass(APMain);

        ConfigureNodes.configureNodesForPopupSecurityCodesController(BTNClose, BTNCopy1, BTNCopy2, BTNCopy3, BTNCopy4, BTNCopy5, BTNCopy6, BTNCopy7, BTNCopy8, BTNCopy9, BTNCopy10,BTNCopyAllCodes, BTNDownloadCodes, BTNGenerateNewCodes, IMGButtonCopy1, IMGButtonCopy1Hover, IMGButtonCopy2, IMGButtonCopy2Hover, IMGButtonCopy3, IMGButtonCopy3Hover, IMGButtonCopy4, IMGButtonCopy4Hover, IMGButtonCopy5, IMGButtonCopy5Hover, IMGButtonCopy6, IMGButtonCopy6Hover, IMGButtonCopy7, IMGButtonCopy7Hover,IMGButtonCopy8, IMGButtonCopy8Hover, IMGButtonCopy9, IMGButtonCopy9Hover,IMGButtonCopy10,IMGButtonCopy10Hover,IMGCopyAllCodes,IMGCopyAllCodesHover,IMGDownloadCodes,IMGDownloadCodesHover,IMGGenerateNewCodes,IMGGenerateNewCodesHover,IMGIconSecurity, IMGIcon,LBLButtonCopy1, LBLButtonCopy2, LBLButtonCopy3, LBLButtonCopy4, LBLButtonCopy5, LBLButtonCopy6, LBLButtonCopy7, LBLButtonCopy8, LBLButtonCopy9, LBLButtonCopy10, LBLCopyAllCodes, LBLDownloadCodes, LBLGenerateNewCodes, SPCode1, SPCode2, SPCode3, SPCode4, SPCode5, SPCode6, SPCode7, SPCode8, SPCode9, SPCode10, isDarkMode);

    }

    public void initializeLabels(boolean haveAnyCode){

        if(haveAnyCode){

            //Hay códigos
            SecurityCodes securityCodes = new SecurityCodes();
            String[] codes = securityCodes.getCodes();

            for(int i = 0; i < codes.length; i++){

                codeLabels[i].setText(codes[i]);

            }

            theUserCanCopyText();

        }else{

            //No hay ningún código
            generateNewCodes();

        }

    }

    private void changeColors(){

        //Botón primario
        principalButtonBackground = Colors.getColor("principal-button-background", isDarkMode);
        principalButtonBorder = Colors.getColor("principal-button-border", isDarkMode);
        principalButtonFontColor = Colors.getColor("principal-button-font-color", isDarkMode);

        principalButtonBackgroundHover = Colors.getColor("principal-button-background-hover", isDarkMode);
        principalButtonBorderHover = Colors.getColor("principal-button-border-hover", isDarkMode);
        principalButtonFontColorHover = Colors.getColor("principal-button-font-color-hover", isDarkMode);

        //Botón secundario
        secondaryButtonBackground = Colors.getColor("secondary-button-background", isDarkMode);
        secondaryButtonBorder = Colors.getColor("secondary-button-border", isDarkMode);
        secondaryButtonFontColor = Colors.getColor("secondary-button-font-color", isDarkMode);

        secondaryButtonBackgroundHover = Colors.getColor("secondary-button-background-hover", isDarkMode);
        secondaryButtonBorderHover = Colors.getColor("secondary-button-border-hover", isDarkMode);
        secondaryButtonFontColorHover = Colors.getColor("secondary-button-font-color-hover", isDarkMode);

        //Popup Card
        popupCardBackground = Colors.getColor("popup-card-background", isDarkMode);
        popupCardBorder = Colors.getColor("popup-card-border", isDarkMode);

        popupCardBackgroundHover = Colors.getColor("popup-card-background-hover", isDarkMode);
        popupCardBorderHover = Colors.getColor("popup-card-border-hover", isDarkMode);

        //Popup Card Button
        popupCardButtonBackground = Colors.getColor("popup-card-button-background", isDarkMode);
        popupCardButtonBorder = Colors.getColor("popup-card-button-border", isDarkMode);
        popupCardButtonFontColor = Colors.getColor("popup-card-button-font-color", isDarkMode);

        popupCardButtonBackgroundHover = Colors.getColor("popup-card-button-background-hover", isDarkMode);
        popupCardButtonBorderHover = Colors.getColor("popup-card-button-border-hover", isDarkMode);
        popupCardButtonFontColorHover = Colors.getColor("popup-card-button-font-color-hover", isDarkMode);

        //Popup Title Bar Button
        popupTitleBarCloseButtonBackground = Colors.getColor("popup-title-bar-close-button-background", isDarkMode);
        popupTitleBarCloseButtonBorder = Colors.getColor("popup-title-bar-close-button-border", isDarkMode);
        popupTitleBarCloseButtonFontColor = Colors.getColor("popup-title-bar-close-button-font-color", isDarkMode);

        popupTitleBarCloseButtonBackgroundHover = Colors.getColor("popup-title-bar-close-button-background-hover", isDarkMode);
        popupTitleBarCloseButtonBorderHover = Colors.getColor("popup-title-bar-close-button-border-hover", isDarkMode);
        popupTitleBarCloseButtonFontColorHover = Colors.getColor("popup-title-bar-close-button-font-color-hover", isDarkMode);

        //Popup Third Button
        popupThirdButtonBackground = Colors.getColor("popup-third-button-background", isDarkMode);
        popupThirdButtonBorder = Colors.getColor("popup-third-button-border", isDarkMode);
        popupThirdButtonFontColor = Colors.getColor("popup-third-button-font-color", isDarkMode);

        popupThirdButtonBackgroundHover = Colors.getColor("popup-third-button-background-hover", isDarkMode);
        popupThirdButtonBorderHover = Colors.getColor("popup-third-button-border-hover", isDarkMode);
        popupThirdButtonFontColorHover = Colors.getColor("popup-third-button-font-color-hover", isDarkMode);

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage)BTNClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNClose,
                popupTitleBarCloseButtonBackground, popupTitleBarCloseButtonBackgroundHover,
                popupTitleBarCloseButtonBorder, popupTitleBarCloseButtonBorderHover,
                popupTitleBarCloseButtonFontColor, popupTitleBarCloseButtonFontColorHover

        );

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNClose,
                popupTitleBarCloseButtonBackgroundHover, popupTitleBarCloseButtonBackground,
                popupTitleBarCloseButtonBorderHover, popupTitleBarCloseButtonBorder,
                popupTitleBarCloseButtonFontColorHover, popupTitleBarCloseButtonFontColor

                );

    }

    @FXML
    void BTNCopy1OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode1.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy1OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy1, IMGButtonCopy1, IMGButtonCopy1Hover,LBLButtonCopy1

        );

    }

    @FXML
    void BTNCopy1OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy1, IMGButtonCopy1Hover, IMGButtonCopy1,LBLButtonCopy1

        );

    }

    @FXML
    void BTNCopy2OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode2.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy2OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy2, IMGButtonCopy2, IMGButtonCopy2Hover,LBLButtonCopy2

        );

    }

    @FXML
    void BTNCopy2OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy2, IMGButtonCopy2Hover, IMGButtonCopy2,LBLButtonCopy2

        );

    }

    @FXML
    void BTNCopy3OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode3.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy3OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy3, IMGButtonCopy3, IMGButtonCopy3Hover,LBLButtonCopy3

        );

    }

    @FXML
    void BTNCopy3OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy3, IMGButtonCopy3Hover, IMGButtonCopy3,LBLButtonCopy3

        );

    }

    @FXML
    void BTNCopy4OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode4.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy4OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy4, IMGButtonCopy4, IMGButtonCopy4Hover,LBLButtonCopy4

        );

    }

    @FXML
    void BTNCopy4OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy4, IMGButtonCopy4Hover, IMGButtonCopy4,LBLButtonCopy4

        );

    }

    @FXML
    void BTNCopy5OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode5.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy5OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy5, IMGButtonCopy5, IMGButtonCopy5Hover,LBLButtonCopy5

        );

    }

    @FXML
    void BTNCopy5OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy5, IMGButtonCopy5Hover, IMGButtonCopy5,LBLButtonCopy5

        );

    }

    @FXML
    void BTNCopy6OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode6.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy6OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy6, IMGButtonCopy6, IMGButtonCopy6Hover,LBLButtonCopy6

        );

    }

    @FXML
    void BTNCopy6OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy6, IMGButtonCopy6Hover, IMGButtonCopy6,LBLButtonCopy6

        );

    }

    @FXML
    void BTNCopy7OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode7.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy7OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy7, IMGButtonCopy7, IMGButtonCopy7Hover,LBLButtonCopy7

        );

    }

    @FXML
    void BTNCopy7OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy7, IMGButtonCopy7Hover, IMGButtonCopy7,LBLButtonCopy7

        );

    }

    @FXML
    void BTNCopy8OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode8.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy8OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy8, IMGButtonCopy8, IMGButtonCopy8Hover,LBLButtonCopy8

        );

    }

    @FXML
    void BTNCopy8OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy8, IMGButtonCopy8Hover, IMGButtonCopy8,LBLButtonCopy8

        );

    }

    @FXML
    void BTNCopy9OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode9.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy9OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy9, IMGButtonCopy9, IMGButtonCopy9Hover,LBLButtonCopy9
        );

    }

    @FXML
    void BTNCopy9OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy9, IMGButtonCopy9Hover, IMGButtonCopy9,LBLButtonCopy9

        );

    }

    @FXML
    void BTNCopy10OnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(LBLCode10.getText())){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopy10OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackground, popupCardButtonBackgroundHover,
                popupCardButtonBorder, popupCardButtonBorderHover,
                popupCardButtonFontColor, popupCardButtonFontColorHover,
                BTNCopy10, IMGButtonCopy10, IMGButtonCopy10Hover,LBLButtonCopy10
        );

    }

    @FXML
    void BTNCopy10OnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupCardButtonBackgroundHover, popupCardButtonBackground,
                popupCardButtonBorderHover, popupCardButtonBorder,
                popupCardButtonFontColorHover, popupCardButtonFontColor,
                BTNCopy10, IMGButtonCopy10Hover, IMGButtonCopy10,LBLButtonCopy10

        );

    }

    @FXML
    void BTNCopyAllCodesOnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(allCodes)){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void BTNCopyAllCodesOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover,
                secondaryButtonFontColor, secondaryButtonFontColorHover,
                BTNCopyAllCodes, IMGCopyAllCodes, IMGCopyAllCodesHover,LBLCopyAllCodes
        );

    }

    @FXML
    void BTNCopyAllCodesOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder,
                secondaryButtonFontColorHover, secondaryButtonFontColor,
                BTNCopyAllCodes, IMGCopyAllCodesHover, IMGCopyAllCodes,LBLCopyAllCodes
        );

    }

    @FXML
    void BTNDownloadCodesOnMouseClicked(MouseEvent event) {

        //Crear PDF
        boolean save = false;
        SecurityCodesFile PDF = new SecurityCodesFile();
        SecurityCodes sc = new SecurityCodes();

        try{

            PDF.setData();
            save = PDF.generarPdf(new String [] {LBLCode1.getText(),LBLCode2.getText(), LBLCode3.getText(), LBLCode4.getText(), LBLCode5.getText(), LBLCode6.getText(), LBLCode7.getText(), LBLCode8.getText(), LBLCode9.getText(), LBLCode10.getText()});

        }catch (Exception e){

            e.printStackTrace();

        }

        if(save){

            //El usuario si guardo el archivo
            sc.deleteCodes();

            String [] encryptCodes = {LBLCode1.getText(),LBLCode2.getText(), LBLCode3.getText(), LBLCode4.getText(), LBLCode5.getText(), LBLCode6.getText(), LBLCode7.getText(), LBLCode8.getText(), LBLCode9.getText(), LBLCode10.getText()};

            for(int i = 0; i<10; i++){

                try{

                    encryptCodes[i] = ValidateOutputs.encrypt(encryptCodes[i]);

                }catch(Exception e){

                    e.printStackTrace();

                }

            }

            sc.insertCodes(encryptCodes);

            Stage stage = (Stage)BTNDownloadCodes.getScene().getWindow();
            stage.close();

        }

    }

    @FXML
    void BTNDownloadCodesOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                principalButtonBackground, principalButtonBackgroundHover,
                principalButtonBorder, principalButtonBorderHover,
                principalButtonFontColor, principalButtonFontColorHover,
                BTNDownloadCodes, IMGDownloadCodes, IMGDownloadCodesHover,LBLDownloadCodes
        );

    }

    @FXML
    void BTNDownloadCodesOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                principalButtonBackgroundHover, principalButtonBackground,
                principalButtonBorderHover, principalButtonBorder,
                principalButtonFontColorHover, principalButtonFontColor,
                BTNDownloadCodes,IMGDownloadCodesHover, IMGDownloadCodes,LBLDownloadCodes
        );

    }

    @FXML
    void BTNGenerateNewCodesOnMouseClicked(MouseEvent event) {

        generateNewCodes();

    }

    @FXML
    void BTNGenerateNewCodesOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupThirdButtonBackground, popupThirdButtonBackgroundHover,
                popupThirdButtonBorder, popupThirdButtonBorderHover,
                popupThirdButtonFontColor, popupThirdButtonFontColorHover,
                BTNGenerateNewCodes, IMGGenerateNewCodes, IMGGenerateNewCodesHover,LBLGenerateNewCodes
        );

    }

    @FXML
    void BTNGenerateNewCodesOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColorsWithImagesAndLabels(

                popupThirdButtonBackgroundHover, popupThirdButtonBackground,
                popupThirdButtonBorderHover, popupThirdButtonBorder,
                popupThirdButtonFontColorHover, popupThirdButtonFontColor,
                BTNGenerateNewCodes, IMGGenerateNewCodesHover, IMGGenerateNewCodes,LBLGenerateNewCodes
        );

    }

    @FXML
    void SPCode1OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode1,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy1);

    }

    @FXML
    void SPCode1OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode1,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


                );

        hideButton(BTNCopy1);

    }

    @FXML
    void SPCode2OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode2,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy2);

    }

    @FXML
    void SPCode2OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode2,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy2);

    }

    @FXML
    void SPCode3OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode3,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy3);

    }

    @FXML
    void SPCode3OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode3,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy3);

    }

    @FXML
    void SPCode4OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode4,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy4);

    }

    @FXML
    void SPCode4OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode4,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy4);

    }

    @FXML
    void SPCode5OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode5,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy5);

    }

    @FXML
    void SPCode5OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode5,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy5);

    }

    @FXML
    void SPCode6OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode6,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy6);

    }

    @FXML
    void SPCode6OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode6,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy6);

    }

    @FXML
    void SPCode7OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode7,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy7);

    }

    @FXML
    void SPCode7OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode7,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy7);

    }

    @FXML
    void SPCode8OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode8,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy8);

    }

    @FXML
    void SPCode8OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode8,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy8);

    }

    @FXML
    void SPCode9OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode9,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy9);

    }

    @FXML
    void SPCode9OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode9,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy9);

    }

    @FXML
    void SPCode10OnMouseEntered(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode10,
                popupCardBackground, popupCardBackgroundHover,
                popupCardBorder, popupCardBorderHover


        );

        showButton(BTNCopy10);

    }

    @FXML
    void SPCode10OnMouseExited(MouseEvent event) {

        StyleBuilder.animateStackPaneBackground(

                SPCode10,
                popupCardBackgroundHover, popupCardBackground,
                popupCardBorderHover,popupCardBorder


        );

        hideButton(BTNCopy10);

    }

    private static void generateNewCodes(){

        String [] newCodes = ValidateOutputs.generateSecurityCodes();

        for(int i=0;i<newCodes.length;i++){

            codeLabels[i].setText(newCodes[i]);

        }

        theUserCanCopyText();

    }

    private static void theUserCanCopyText(){

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<10; i++){

            if(codeLabels[i].getText().equalsIgnoreCase("Este código ya fue usado")){

                theUserCanCopyText[i] = false;

            }else{

                theUserCanCopyText[i] = true;
                sb.append(codeLabels[i].getText());

            }

            if(i!= 9){

                sb.append("\n");

            }

        }

        for(int i=0; i<10; i++){

            if(!theUserCanCopyText[i]){

                copyButtons[i].setDisable(true);
                copyButtons[i].setMouseTransparent(true);
                copyButtons[i].setVisible(false);

            }else{

                copyButtons[i].setDisable(false);
                copyButtons[i].setMouseTransparent(false);
                copyButtons[i].setVisible(true);

            }

        }

        allCodes = sb.toString();

    }

    private void hideButton(Button button){

        button.setDisable(true);
        FadeTransition fadeIn = new  FadeTransition(Duration.seconds(0.3), button);
        fadeIn.setFromValue(1);
        fadeIn.setToValue(0);
        fadeIn.play();

    }

    private void showButton(Button button){

        button.setDisable(false);
        FadeTransition fadeIn = new  FadeTransition(Duration.seconds(0.3), button);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();

    }

    private void hideNodes(Node... nodes){

        for(Node node: nodes){

            node.setOpacity(0.0);

        }

    }

}
