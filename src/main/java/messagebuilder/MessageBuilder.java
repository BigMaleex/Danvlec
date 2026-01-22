package messagebuilder;

import controllers.PopupOneButtonController;
import controllers.PopupTwoButtonController;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import logical.ValidateOutputs;
import stylebuilder.StyleBuilder;
import user.UserData;
import utilities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MessageBuilder {

    //Referencias
    private static ScreenManager sm = ScreenManager.getInstance();

    private static boolean isDarkMode;
    private static String headerColor;
    private static String contentColor;

    public static void showConfirmMessageFromPopupSetClock(String [] data){

        sm.openDynamicPopup(

                FileConstants.PopupTwoButtonFXML,
                Complements.okTitle,
                alertController ->{

                    PopupTwoButtonController controller = (PopupTwoButtonController) alertController;

                    controller.initialize();
                    isDarkMode = controller.getMode();

                    changeColors();

                    String [] messages = {

                        "Tu objetivo es: ",
                        "La fecha de inicio es el "

                    };



                    controller.setTFLHeader(Complements.addStringFromTextList("¡Todo ha ido de maravilla!", Styles.px14, headerColor));

                    List<Text> texts = new ArrayList<>();

                    texts.add(Complements.addStringFromTextList("Toda la información que agregaste es válida, por favor confirma que sea correcta tu información:\n\n", Styles.px12, contentColor));

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[0], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[0]+"\n", Styles.px12, headerColor));

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.parse(data[1], formatter);

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[1], Styles.px12, contentColor));
                    texts.addAll(buildDateAndHour(dateTime, Styles.px12, headerColor, true, true, true, true));

                    controller.setTFLContent(texts);

                    controller.setTFLFooter(Complements.addStringFromTextList("\n\nSi toda tu información es correcta puedes continuar, sino puedes editarla ahora o más tarde", Styles.px12, contentColor));

                    controller.setOption(Options.options.allClockInformationIsCorrect);

                    controller.setIcon(FileConstants.personRaisedHandIconDm, FileConstants.personRaisedHandIconLm);

                    controller.setTextButton("Editar información", "Mi información es correcta");

                    controller.setData(data);

                }

        );

    }

    public static void showErrorMessageFromPopupSetClock(boolean [] aspects){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;
                    isDarkMode = controller.getMode();
                    changeColors();

                    controller.setIcon(FileConstants.databaseFillExclamationIconDm, FileConstants.databaseFillExclamationIconLm);

                    String [] messages = {

                            "No has ingresado tu objetivo",
                            "El objetivo que ingresaste es demasiado largo",
                            "La fecha que ingresaste es inválida",
                            "La hora que ingresaste es inválida"

                    };

                    controller.setTextButton("Intentar de nuevo");

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Inténtalo de nuevo!", Styles.px14, headerColor));

                    List<Text> text = new ArrayList<>();

                    text.add(Complements.addStringFromTextList("No pudimos registrar tu información debido a lo siguiente:\n\n", Styles.px12, contentColor));

                    for(int i = 0; i < aspects.length; i++){

                        if(!aspects[i]){

                            text.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                            text.add(Complements.addStringFromTextList(messages[i] + "\n", Styles.px12, contentColor));

                        }

                    }

                    controller.setTFLContent(text);

                }
        );

    }

    public static void showErrorMessageFromLogin(boolean [] aspects){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;

                    controller.setIcon(FileConstants.databaseFillExclamationIconDm, FileConstants.databaseFillExclamationIconLm);

                    isDarkMode = controller.getMode();

                    String [] messages = {

                            "No has ingresado tu correo electrónico",
                            "No has ingresado tu contraseña",
                            "Tus credenciales son inválidas"

                    };

                    changeColors();

                    controller.setTextButton("Intentar de nuevo");

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Nos pudimos acceder a tu información!", Styles.px14, headerColor));

                    List<Text> text = new ArrayList<>();

                    text.add(Complements.addStringFromTextList("No pudimos acceder a tu cuenta debido a lo siguiente:\n\n", Styles.px12, contentColor));

                    for(int i = 0; i < aspects.length; i++){

                        if(!aspects[i]){

                            text.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                            text.add(Complements.addStringFromTextList(messages[i] + "\n", Styles.px12, contentColor));

                        }

                    }

                    controller.setTFLContent(text);

                }

        );

    }

    public static void showConfirmMessageFromLogin(){

        sm.openDynamicPopup(

                FileConstants.PopupTwoButtonFXML,
                Complements.okTitle,
                alertController->{

                    PopupTwoButtonController controller = (PopupTwoButtonController) alertController;

                    isDarkMode = controller.getMode();

                    changeColors();

                    controller.setIcon(FileConstants.personRaisedHandIconDm, FileConstants.personRaisedHandIconLm);
                    controller.setTextButton("No guardar mi sesión", "Guardar mi sesión");

                    controller.setOption(Options.options.askTheUserIfTheyWantToSaveTheirInformation);

                    StringBuilder header = new StringBuilder();

                    header.append("¡Bienvenid").append(UserData.getSex() == UserData.Sex.MAN ? "o" : "a").append(", ").append(ValidateOutputs.getPreferredWayToCallThem()). append("!");

                    controller.setTFLHeader(Complements.addStringFromTextList(header.toString(), Styles.px14, headerColor));

                    List<Text> texts  = new ArrayList<>();

                    texts.add(Complements.addStringFromTextList("¡Hemos tenido éxito al encontrar tu información!", Styles.px12, contentColor));

                    controller.setTFLFooter(Complements.addStringFromTextList("¿Deseas que guardemos tu información de sesión para futuras ocasiones?", Styles.px12, headerColor));

                    controller.setTFLContent(texts);

                }

        );

    }

    public static void showConfirmMessageUpdateFromPopupVerifyEmail(){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;

                    controller.initialize();

                    isDarkMode = controller.getMode();

                    changeColors();

                    controller.setIcon(FileConstants.databaseFillCheckIconDm, FileConstants.databaseFillCheckIconLm);

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Tu información ha sido actualizada con éxito!",Styles.px14, headerColor));

                    List<Text> texts = new  ArrayList<>();

                    texts.add(Complements.addStringFromTextList("Gracias por verificar tu correo electrónico, puedes usar tu cuenta con normalidad.", Styles.px12, contentColor));

                    controller.setTFLContent(texts);

                    controller.setTextButton("Cerrar");

                }

        );

    }

    public static void showErrorMessageUpdateFromPopupVerifyEmail(){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;

                    controller.initialize();

                    isDarkMode = controller.getMode();

                    changeColors();

                    controller.setIcon(FileConstants.databaseFillExclamationIconDm, FileConstants.databaseFillExclamationIconLm);

                    controller.setTFLHeader(Complements.addStringFromTextList("¡No pudimos actualizar tu información!",Styles.px14, headerColor));

                    List<Text> texts = new  ArrayList<>();

                    texts.add(Complements.addStringFromTextList("El problema está de nuestro lado, por favor intentalo más tarde.", Styles.px12, contentColor));

                    controller.setTFLContent(texts);

                    controller.setTextButton("Intentar mas tarde");

                }

        );

    }

    public static void showErrorMessageFromPopupVerifyEmail(){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;

                    controller.initialize();

                    isDarkMode = controller.getMode();

                    changeColors();

                    controller.setIcon(FileConstants.exclamationOctagonIconDm, FileConstants.exclamationOctagonIconLm);

                    controller.setTFLHeader(Complements.addStringFromTextList("¡No pudimos validar tu información!",Styles.px14, headerColor));

                    List<Text> texts = new  ArrayList<>();

                    texts.add(Complements.addStringFromTextList("El código de verificación que ingresaste es incorrecto o ya no es válido.", Styles.px12, contentColor));

                    controller.setTFLContent(texts);

                    controller.setTextButton("Intentar de nuevo");

                }

        );

    }

    public static void showConfirmMessageFromGuest(String [] aspects){

        sm.openDynamicPopup(

                FileConstants.PopupTwoButtonFXML,
                Complements.okTitle,
                alertController ->{

                    PopupTwoButtonController controller = (PopupTwoButtonController) alertController;

                    String [] data = new String [aspects.length];

                    for(int i = 0; i < aspects.length; i++){

                        if(i != 4){

                            data[i] = StyleBuilder.clearStringFormat(aspects[i]);

                        }else{

                            data[i] = aspects[i];

                        }

                    }

                    controller.initialize();

                    String [] messages = {

                            aspects[0].contains(" ") ? "Tus nombres son: " : "Tu nombre es: ",
                            aspects[1].contains(" ") ? "Tus apellidos son: " : "Tu apellidos es: ",
                            "Te gusta que te llamen: ",
                            "Eres ",
                            "Naciste el "

                    };

                    isDarkMode = controller.getMode();

                    changeColors();

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Todo ha ido de maravilla!", Styles.px14, headerColor));

                    List<Text> texts = new ArrayList<>();

                    texts.add(Complements.addStringFromTextList("Toda la información que agregaste es válida, por favor confirma que sea correcta tu información:\n\n", Styles.px12, contentColor));

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[0], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[0]+"\n", Styles.px12, headerColor));

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[1], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[1]+"\n", Styles.px12, headerColor));

                    if(data[2] != null){

                        texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                        texts.add(Complements.addStringFromTextList(messages[2], Styles.px12, contentColor));
                        texts.add(Complements.addStringFromTextList(data[2]+"\n", Styles.px12, headerColor));

                    }

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[3], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[3]+"\n", Styles.px12, data[3].equalsIgnoreCase("hombre") ? Complements.manColor : Complements.womanColor));

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date =  LocalDate.parse(data[4], formatter);

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[4], Styles.px12, contentColor));
                    texts.addAll(buildDateText(date, Styles.px12, headerColor, true, true, true, true));

                    controller.setTFLContent(texts);

                    controller.setTFLFooter(Complements.addStringFromTextList("\n\nSi toda tu información es correcta puedes continuar, sino puedes editarla ahora o más tarde", Styles.px12, contentColor));

                    controller.setOption(Options.options.allUserInformationIsCorrectFromGuestGenerateFile);

                    controller.setIcon(FileConstants.personRaisedHandIconDm, FileConstants.personRaisedHandIconLm);

                    controller.setTextButton("Editar información", "Mi información es correcta");

                    controller.setData(data);

                }

        );

    }

    public static void showErrorMessageFromGuest(boolean [] aspects){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;
                    controller.initialize();

                    isDarkMode = controller.getMode();

                    changeColors();

                    List<Text> texts = new ArrayList<>();

                    controller.setTFLHeader(Complements.addStringFromTextList(hasMoreThanOneFalse(aspects) ? "¡Nos hemos encontrado con algunos problemas!" : "¡Nos hemos encontrado con un problema!", Styles.px14, headerColor));

                    String [] messages = {

                            "No has ingresado ningún nombre",
                            "No has ingresado ningún apellido",
                            "No has ingresado ningún apodo",
                            "No has ingresado ningún sexo",
                            "La fecha de nacimiento que ingresaste es inválida, recuerda que debe de ser anterior al día de hoy, pero posterior a 100 años atrás"

                    };

                    texts.add(Complements.addStringFromTextList((hasMoreThanOneFalse(aspects) ? "No hemos podido crear tu cuenta debido a los siguientes problemas:" : "No hemos podido crear tu cuenta debido al siguiente problema:") + "\n", Styles.px12, contentColor));

                    for(int i = 0; i < aspects.length; i++){

                        if(!aspects[i]){

                            texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                            texts.add(Complements.addStringFromTextList(messages[i]+"\n", Styles.px12, contentColor));

                        }

                    }

                    controller.setTFLContent(texts);
                    controller.setTFLFooter(Complements.addStringFromTextList("Por favor, verifica la información e inténtalo más tarde", Styles.px12, headerColor));

                    controller.setTextButton("Editar información");
                    controller.setIcon(FileConstants.exclamationOctagonIconDm,FileConstants.exclamationOctagonIconDm);

                }

        );

    }

    public static void showOkMessageFromAllInfoUploadToTheBD(){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.okTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;
                    controller.initialize();

                    isDarkMode = controller.getMode();

                    changeColors();

                    List<Text> texts = new ArrayList<>();


                    controller.setIcon(FileConstants.databaseFillCheckIconDm, FileConstants.databaseFillCheckIconLm);

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Tu cuenta ha sido creada con éxito!", Styles.px14, headerColor));

                    texts.add(Complements.addStringFromTextList("\n\nDe ahora en adelante puedes acceder a tu cuenta con la información que nos proporcionaste\n\n", Styles.px12, contentColor));

                    controller.setTFLContent(texts);

                    controller.setTFLFooter(Complements.addStringFromTextList("Por favor, inicia sesión", Styles.px12, headerColor));

                    controller.setTextButton("Iniciar sesión");

                }

        );

    }

    public static void showErrorMessageFromAllInfoUploadToTheBD(){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;
                    controller.initialize();

                    isDarkMode = controller.getMode();

                    changeColors();

                    List<Text> texts = new ArrayList<>();

                    controller.setIcon(FileConstants.bugIconDm, FileConstants.bugIconLm);

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Nos encontramos con un problema!", Styles.px14, headerColor));

                    texts.add(Complements.addStringFromTextList("\n\nNo sabemos aún bien que sucedió, el problema viene por parte de nosotros. Disculpa las molestias\n\n", Styles.px12, contentColor));

                    controller.setTFLContent(texts);

                    controller.setTFLFooter(Complements.addStringFromTextList("Por favor, inténtalo más tarde", Styles.px12, headerColor));

                    controller.setTextButton("Aceptar");

                }

        );

    }

    public static void showConfirmMessageFromSignUp(String [] aspects){

        sm.openDynamicPopup(

                FileConstants.PopupTwoButtonFXML,
                Complements.okTitle,
                alertController ->{

                    PopupTwoButtonController controller = (PopupTwoButtonController) alertController;

                    String [] data = new String [aspects.length];

                    for(int i = 0; i < aspects.length; i++){

                        if(i != 4){

                            data[i] = StyleBuilder.clearStringFormat(aspects[i]);

                        }else{

                            data[i] = aspects[i];

                        }

                    }

                    controller.initialize();

                    String [] messages = {

                            aspects[0].contains(" ") ? "Tus nombres son: " : "Tu nombre es: ",
                            aspects[1].contains(" ") ? "Tus apellidos son: " : "Tu apellidos es: ",
                            "Te gusta que te llamen: ",
                            "Tu correo electrónico es: ",
                            "Tu contraseña es ",
                            "Eres ",
                            "Naciste el "

                    };

                    isDarkMode = controller.getMode();

                    changeColors();

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Todo ha ido de maravilla!", Styles.px14, headerColor));

                    List<Text> texts = new ArrayList<>();

                    texts.add(Complements.addStringFromTextList("Toda la información que agregaste es válida, por favor confirma que sea correcta tu información:\n\n", Styles.px12, contentColor));

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[0], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[0]+"\n", Styles.px12, headerColor));

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[1], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[1]+"\n", Styles.px12, headerColor));

                    if(data[2] != null){

                        texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                        texts.add(Complements.addStringFromTextList(messages[2], Styles.px12, contentColor));
                        texts.add(Complements.addStringFromTextList(data[2]+"\n", Styles.px12, headerColor));

                    }

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[3], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[3]+"\n", Styles.px12, headerColor));

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[4], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList((data[4].length() <=12 ? "muy débil" : (data[4].length() >12 && data[4].length() < 20 ? "medianamente fuerte" : "Muy fuerte"))  +"\n", Styles.px12, headerColor));

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[5], Styles.px12, contentColor));
                    texts.add(Complements.addStringFromTextList(data[5]+"\n", Styles.px12, data[5].equalsIgnoreCase("hombre") ? Complements.manColor : Complements.womanColor));

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date =  LocalDate.parse(data[6], formatter);

                    texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                    texts.add(Complements.addStringFromTextList(messages[6], Styles.px12, contentColor));
                    texts.addAll(buildDateText(date, Styles.px12, headerColor, true, true, true, true));

                    controller.setTFLContent(texts);

                    controller.setTFLFooter(Complements.addStringFromTextList("\n\nSi toda tu información es correcta puedes continuar, sino puedes editarla ahora o más tarde", Styles.px12, contentColor));

                    controller.setOption(Options.options.allUserInformationIsCorrectUploadToTheBD);

                    controller.setIcon(FileConstants.personRaisedHandIconDm, FileConstants.personRaisedHandIconLm);

                    controller.setTextButton("Editar información", "Mi información es correcta");

                    controller.setData(data);

                }

        );

    }

    public static void showErrorMessageFromSignUp(boolean [] aspects, String [] data){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;
                    controller.initialize();

                    isDarkMode = controller.getMode();

                    List<Text> texts = new ArrayList<>();

                    changeColors();

                    controller.setTFLHeader(Complements.addStringFromTextList(hasMoreThanOneFalse(aspects) ? "¡Nos hemos encontrado con algunos problemas!" : "¡Nos hemos encontrado con un problema!", Styles.px14, headerColor));

                    String [] messages = {

                            "No has ingresado ningún nombre",
                            data[0].contains(" ") ? "Tus nombres son demasiado largos" : "Tu nombre es demasiado largo",
                            "No has ingresado ningún apellido",
                            data[1].contains(" ") ? "Tus apellidos son demasiado largos" : "Tu apellido es demasiado largo",
                            "No has ingresado ningún apodo",
                            "El apodo que ingresaste es demasiado largo",
                            "No has ingresado ningún correo electrónico",
                            "El correo electrónico que ingresaste es demasiado largo",
                            "El correo electrónico que ingresaste está dado de alta con otra cuenta",
                            "No has ingresado una contraseña",
                            "No has confirmado tu contraseña",
                            "Las contraseñas que ingresaste no coinciden",
                            "No has ingresado ningún sexo",
                            "La fecha de nacimiento que ingresaste es inválida, recuerda que debe de ser anterior al día de hoy, pero posterior a 100 años atrás"

                    };

                    texts.add(Complements.addStringFromTextList((hasMoreThanOneFalse(aspects) ? "No hemos podido crear tu cuenta debido a los siguientes problemas:" : "No hemos podido crear tu cuenta debido al siguiente problema:") + "\n", Styles.px12, contentColor));

                    for(int i = 0; i < aspects.length; i++){

                        if(!aspects[i]){

                            texts.add(Complements.addStringFromTextList(Complements.bullet, Styles.px12, headerColor));
                            texts.add(Complements.addStringFromTextList(messages[i]+"\n", Styles.px12, contentColor));

                        }

                    }

                    controller.setTFLContent(texts);
                    controller.setTFLFooter(Complements.addStringFromTextList("Por favor, verifica la información e inténtalo más tarde", Styles.px12, headerColor));

                    controller.setTextButton("Editar información");
                    controller.setIcon(FileConstants.exclamationOctagonIconDm,FileConstants.exclamationOctagonIconLm);

                }

        );

    }

    public static void showConfirmMessageFromConnectionFailedToBD(){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.okTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;
                    controller.initialize();
                    isDarkMode = controller.getMode();

                    changeColors();

                    List<Text> texts = new ArrayList<>();

                    controller.setTFLHeader(Complements.addStringFromTextList("¡Nos hemos conectado a la base de datos!", Styles.px18, headerColor));

                    texts.add(Complements.addStringFromTextList("Se ha restablecido la conexión de manera exitosa, puedes usar la aplicación normalmente", Styles.px12, contentColor));

                    controller.setTFLContent(texts);

                    controller.setTextButton("Aceptar");

                    controller.setIcon(FileConstants.databaseFillCheckIconDm, FileConstants.databaseFillCheckIconLm);

                }

        );

    }

    public static void showErrorMessageFromConnectionFailedToBD(){

        sm.openDynamicPopup(

                FileConstants.PopupOneButtonFXML,
                Complements.errorTitle,
                alertController ->{

                    PopupOneButtonController controller = (PopupOneButtonController) alertController;
                    controller.initialize();
                    isDarkMode = controller.getMode();

                    changeColors();

                    List<Text> texts = new ArrayList<>();

                    controller.setTFLHeader(Complements.addStringFromTextList("¡No pudimos conectarnos con la base de datos!", Styles.px18, headerColor));

                    texts.add(Complements.addStringFromTextList("No hemos podido conectar con la base de datos, prueba revisar tu conexión e intentalo más tarde", Styles.px12, contentColor));

                    controller.setTFLContent(texts);

                    controller.setTextButton("Aceptar");

                    controller.setIcon(FileConstants.databaseFillExclamationIconDm, FileConstants.databaseFillExclamationIconLm);

                }

        );

    }

    private static boolean hasMoreThanOneFalse(boolean[] arr) {
        int count = 0;
        for (boolean value : arr) {
            if (!value) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<Text> buildDateAndHour(LocalDateTime dateTime, String size, String glowColor, boolean dayMinus, boolean monthMinus, boolean dayGlow, boolean monthGlow){

        List<Text> texts = new ArrayList<>();

        if(dateTime != null){

            //Fecha
            texts.add(Complements.addStringFromTextList(ValidateOutputs.getDayOfWeekString(dateTime.toLocalDate(), dayMinus),size, contentColor));
            texts.add(Complements.addStringFromTextList(" ", size, contentColor));
            texts.add(Complements.addStringFromTextList(dateTime.toLocalDate().getDayOfMonth()+"", size, dayGlow ? glowColor : contentColor));
            texts.add(Complements.addStringFromTextList(" de ", size, contentColor));
            texts.add(Complements.addStringFromTextList(ValidateOutputs.getMonthOfYearString(dateTime.toLocalDate(), monthMinus), size, monthGlow ? glowColor : contentColor));
            texts.add(Complements.addStringFromTextList(dateTime.getYear() >= 2000? " del " : " de ", size, contentColor));
            texts.add(Complements.addStringFromTextList(dateTime.getYear() +"", size, glowColor));

            //Hora
            String partOfDay;
            int hour =  dateTime.getHour();
            int parseHour;

            if(hour >12){

                parseHour = hour -12;

            }else{

                parseHour = hour;

            }

            if(hour >= 0 && hour <12){

                partOfDay = "mañana";

            }
            else if(hour >= 12 && hour < 18){

                partOfDay = "tarde";

            }else{

                partOfDay = "noche";

            }

            StringBuilder builder = new StringBuilder();

            builder.append(parseHour).append(dateTime.getMinute() != 0 ? ":" : "").append(dateTime.getMinute() != 0 ?String.format("%02d", dateTime.getMinute()) : "").append(" de la ");

            texts.add(Complements.addStringFromTextList(" a las " + builder, size, contentColor));
            texts.add(Complements.addStringFromTextList(partOfDay, size, glowColor));

        }else{

            texts.add(Complements.addStringFromTextList("¡No se ha ingresado ninguna fecha!", size, glowColor));

        }

        return texts;

    }

    private static List<Text> buildDateText(LocalDate date, String size, String glowColor, boolean monthMinus, boolean dayMinus, boolean dayGlow, boolean monthGlow){

        List<Text> texts = new ArrayList<>();

        if(date != null){

            texts.add(Complements.addStringFromTextList(ValidateOutputs.getDayOfWeekString(date, dayMinus),size, contentColor));
            texts.add(Complements.addStringFromTextList(" ", size, contentColor));
            texts.add(Complements.addStringFromTextList(date.getDayOfMonth()+"", size, dayGlow ? glowColor : contentColor));
            texts.add(Complements.addStringFromTextList(" de ", size, contentColor));
            texts.add(Complements.addStringFromTextList(ValidateOutputs.getMonthOfYearString(date, monthMinus), size, monthGlow ? glowColor : contentColor));
            texts.add(Complements.addStringFromTextList(date.getYear() >= 2000? " del " : " de ", size, contentColor));
            texts.add(Complements.addStringFromTextList(date.getYear()+".", size, glowColor));

        }else{

            texts.add(Complements.addStringFromTextList("¡No se ha ingresado ninguna fecha!", size, glowColor));

        }

        return texts;

    }

    public static List<Text> buildMessagesAboutEmailFromPopupVerifyEmail(boolean isDM){

        List<Text> texts = new ArrayList<>();

        isDarkMode = isDM;
        changeColors();

        texts.add(Complements.addStringFromTextList("Hemos enviado un código de verificación al siguiente correo electrónico: ", Styles.px12, (contentColor)));
        texts.add(Complements.addStringFromTextList(UserData.getEmail(), Styles.px12, (headerColor)));

        return texts;

    }

    public static List<Text> buildMessagesAboutTimeRemainingFromPopupVerifyEmail(long daysThatHavePassed, boolean isDM){

        List<Text> texts = new ArrayList<>();

        isDarkMode = isDM;

        changeColors();

        String contentMessage = null;

        if(daysThatHavePassed >= 0 && daysThatHavePassed < 6){

            contentMessage = "Tienes " + (15 - daysThatHavePassed) + " días para verificar tu correo electrónico. Si no lo haces en " + (15 - daysThatHavePassed) + " días desde el registro, tu cuenta será eliminada automáticamente.";

        }
        else if(daysThatHavePassed >=6 &&  daysThatHavePassed < 10){

            contentMessage = "Tu cuenta será eliminada automáticamente en " + (15 - daysThatHavePassed) + " días si no verificas tu correo electrónico. Completa la verificación para mantener tu cuenta activa.";

        }else if(daysThatHavePassed >= 10 && daysThatHavePassed < 15){

            contentMessage = "Tu cuenta será eliminada permanentemente si no verificas tu correo electrónico en " + (15 - daysThatHavePassed) + ((15 - daysThatHavePassed) == 1 ? " día" : " días")+ ". Todos tus datos se perderán de forma irreversible.";

        }else if(daysThatHavePassed == 15){

            contentMessage = "Tu cuenta será eliminada permanentemente si no verificas tu correo electrónico hoy. Todos tus datos se perderán de forma irreversible.";

        }

        texts.add(Complements.addStringFromTextList(

                contentMessage,
                Styles.px12,
                daysThatHavePassed >= 0 && daysThatHavePassed < 6 ?  (headerColor) :
                        daysThatHavePassed >=6 &&  daysThatHavePassed < 10 ? Colors.getColor("email-not-verified-second-fase-font-color", isDM) : Colors.getColor("email-not-verified-third-fase-font-color", isDM)

        ));

        System.out.println(contentMessage);

        return texts;

    }

    public static void addToastNotification (TextFlow TFLToast, String message, String color){

        TFLToast.getChildren().clear();
        TFLToast.getChildren().add(addTextToToastNotification(message, color));

    }

    private static Text addTextToToastNotification(String message, String color){

        Text text =  Complements.addStringFromTextList(message, Styles.px12, color);
        text.setWrappingWidth(0);

        return text;

    }

    private static void changeColors(){

        headerColor = Colors.getColor("title-font-color", isDarkMode);
        contentColor = Colors.getColor("content-font-color", isDarkMode);

    }

}
