package controllers;

import connections.DataManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logical.ValidateOutputs;
import messagebuilder.MessageBuilder;
import messagebuilder.Notifications;
import stylebuilder.ConfigureNodes;
import stylebuilder.StyleBuilder;
import user.UserPreferences;
import utilities.Colors;
import utilities.FileConstants;
import utilities.ScreenManager;

import java.sql.SQLException;

public class PopupBDErrController {

    //Clases
    private ScreenManager sm = ScreenManager.getInstance();

    //Variables
    private boolean isDarkMode;
    private static int option;
    private static String err;

    //Botón secundario
    private static String secondaryButtonBackground;
    private static String secondaryButtonBorder;
    private static String secondaryButtonFontColor;
    private static String secondaryButtonBackgroundHover;
    private static String secondaryButtonBorderHover;
    private static String secondaryButtonFontColorHover;

    //Botón primario
    private static String principalButtonBackground;
    private static String principalButtonBorder;
    private static String principalButtonFontColor;
    private static String principalButtonBackgroundHover;
    private static String principalButtonBorderHover;
    private static String principalButtonFontColorHover;

    //Botón oculto
    private static String hideButtonBackground;
    private static String hideButtonBorder;
    private static String hideButtonFontColor;
    private static String hideButtonBackgroundHover;
    private static String hideButtonBorderHover;
    private static String hideButtonFontColorHover;


    @FXML
    private AnchorPane APChangeIP;

    @FXML
    private AnchorPane APContinue;

    @FXML
    private AnchorPane APCopy;

    @FXML
    private AnchorPane APMain;

    @FXML
    private AnchorPane APReload;

    @FXML
    private Button BTNClose;

    @FXML
    private ImageView IMGChangeIPIcon;

    @FXML
    private ImageView IMGChangeIPIconHover;

    @FXML
    private ImageView IMGContinue;

    @FXML
    private ImageView IMGContinueHover;

    @FXML
    private ImageView IMGCopy;

    @FXML
    private ImageView IMGCopyHover;

    @FXML
    private ImageView IMGOfflineMode;

    @FXML
    private ImageView IMGReload;

    @FXML
    private ImageView IMGReloadHover;

    @FXML
    private Label LBLChangeIP;

    @FXML
    private Label LBLContinue;

    @FXML
    private Label LBLCopy;

    @FXML
    private Label LBLReload;

    @FXML
    private TextArea TATError;

    @FXML
    private VBox contentVBox;

    @FXML
    public void initialize(){

        StyleBuilder.clearControls(TATError);

        isDarkMode = UserPreferences.getUserThemeMode();

        IMGReloadHover.setOpacity(0);
        IMGCopyHover.setOpacity(0);
        IMGContinueHover.setOpacity(0);
        IMGChangeIPIconHover.setOpacity(0);

        changeTheme();

    }

    private void changeTheme(){

        StyleBuilder.setAnchorPaneClass(APMain);

        ConfigureNodes.configureNodesForPopupBDErrController(APChangeIP,APContinue,APCopy,APReload,BTNClose,IMGChangeIPIcon,IMGChangeIPIconHover,IMGContinue,IMGContinueHover,IMGCopy,IMGCopyHover,IMGOfflineMode,IMGReload,IMGReloadHover,LBLChangeIP,LBLContinue,LBLCopy,LBLReload,isDarkMode);

        changeColors();

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

        //Botón oculto
        hideButtonBackground = Colors.getColor("hide-button-background", isDarkMode);
        hideButtonBorder = Colors.getColor("hide-button-border", isDarkMode);
        hideButtonFontColor = Colors.getColor("hide-button-font-color", isDarkMode);

        hideButtonBackgroundHover = Colors.getColor("hide-button-background-hover", isDarkMode);
        hideButtonBorderHover = Colors.getColor("hide-button-border-hover", isDarkMode);
        hideButtonFontColorHover = Colors.getColor("hide-button-font-color-hover", isDarkMode);

    }

    public void setError(String error){

        err = error;

        TATError.setText("Detalles del error:\n" +error);

    }
    public void setOption (int newOption){

        option = newOption;

    }


    @FXML
    void APChangeIPOnMouseClicked(MouseEvent event) {

        sm.openDynamicPopup(

                FileConstants.PopupChangeIPFXML,
                "Cambia la dirección IP",
                alertController->{

                    PopupChangeIPController controller = (PopupChangeIPController) alertController;

                    controller.initialize();

                }

        );

        BTNCloseOnMouseClicked(event);

    }

    @FXML
    void APChangeIPOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APChangeIP,
                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover

        );

        StyleBuilder.animateLabelTextColor(

                LBLChangeIP,
                secondaryButtonFontColor, secondaryButtonFontColorHover

        );

        StyleBuilder.fadeAndChangeImage(IMGChangeIPIcon, IMGChangeIPIconHover);

    }

    @FXML
    void APChangeIPOnMouseExited(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APChangeIP,
                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder

        );

        StyleBuilder.animateLabelTextColor(

                LBLChangeIP,
                secondaryButtonFontColorHover, secondaryButtonFontColor

        );

        StyleBuilder.fadeAndChangeImage(IMGChangeIPIconHover, IMGChangeIPIcon);

    }

    @FXML
    void APContinueOnMouseClicked(MouseEvent event) {

        switch(option){



            default->{System.out.println("Aún no has configurado la opción " + option);}

        }

        BTNCloseOnMouseClicked(event);

    }

    @FXML
    void APContinueOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APContinue,
                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover

        );

        StyleBuilder.animateLabelTextColor(

                LBLContinue,
                secondaryButtonFontColor, secondaryButtonFontColorHover

        );

        StyleBuilder.fadeAndChangeImage(IMGContinue, IMGContinueHover);

    }

    @FXML
    void APContinueOnMouseExited(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APContinue,
                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder

        );

        StyleBuilder.animateLabelTextColor(

                LBLContinue,
                secondaryButtonFontColorHover, secondaryButtonFontColor

        );

        StyleBuilder.fadeAndChangeImage(IMGContinueHover, IMGContinue);

    }

    @FXML
    void APCopyOnMouseClicked(MouseEvent event) {

        if(ValidateOutputs.copyStringToClipboard(err)){

            Notifications.showNotification("¡Texto copiado exitosamente!", "Ahora puedes copiar el error en cualquier navegador para investigar más sobre el error");

        }else{

            Notifications.showNotification("¡El texto no ha podido ser copiado exitosamente!", "No sabemos que sucedió, inténtalo más tarde");


        }

    }

    @FXML
    void APCopyOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APCopy,
                secondaryButtonBackground, secondaryButtonBackgroundHover,
                secondaryButtonBorder, secondaryButtonBorderHover

        );

        StyleBuilder.animateLabelTextColor(

                LBLCopy,
                secondaryButtonFontColor, secondaryButtonFontColorHover

        );

        StyleBuilder.fadeAndChangeImage(IMGCopy, IMGCopyHover);

    }

    @FXML
    void APCopyOnMouseExited(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APCopy,
                secondaryButtonBackgroundHover, secondaryButtonBackground,
                secondaryButtonBorderHover, secondaryButtonBorder

        );

        StyleBuilder.animateLabelTextColor(

                LBLCopy,
                secondaryButtonFontColorHover, secondaryButtonFontColor

        );

        StyleBuilder.fadeAndChangeImage(IMGCopyHover, IMGCopy);

    }

    @FXML
    void APReloadOnMouseClicked(MouseEvent event) {

        try{

            if(DataManager.reloadConnection()){

                MessageBuilder.showConfirmMessageFromConnectionFailedToBD();

            }else{

                MessageBuilder.showErrorMessageFromConnectionFailedToBD();

            }

        }catch(SQLException e){

            e.printStackTrace();

        }

    }

    @FXML
    void APReloadOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APReload,
                principalButtonBackground, principalButtonBackgroundHover,
                principalButtonBorder, principalButtonBorderHover

        );

        StyleBuilder.animateLabelTextColor(

                LBLReload,
                principalButtonFontColor, principalButtonFontColorHover

        );

        StyleBuilder.fadeAndChangeImage(IMGReload, IMGReloadHover);

    }

    @FXML
    void APReloadOnMouseExited(MouseEvent event) {

        StyleBuilder.animateAnchorPaneBackground(

                APReload,
                principalButtonBackgroundHover, principalButtonBackground,
                principalButtonBorderHover, principalButtonBorder

        );

        StyleBuilder.animateLabelTextColor(
                LBLReload,
                principalButtonFontColorHover, principalButtonFontColor

        );

        StyleBuilder.fadeAndChangeImage(IMGReloadHover, IMGReload);

    }

    @FXML
    void BTNCloseOnMouseClicked(MouseEvent event) {

        Stage stage = (Stage) BTNClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void BTNCloseOnMouseEntered(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNClose,
                hideButtonBackground, hideButtonBackgroundHover,
                hideButtonBorder, hideButtonBorderHover,
                hideButtonFontColor, hideButtonFontColorHover

        );

    }

    @FXML
    void BTNCloseOnMouseExited(MouseEvent event) {

        StyleBuilder.animateButtonColors(

                BTNClose,
                hideButtonBackgroundHover, hideButtonBackground,
                hideButtonBorderHover, hideButtonBorder,
                hideButtonFontColorHover, hideButtonFontColor

        );

    }

}
