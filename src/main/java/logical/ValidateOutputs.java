package logical;

import connections.Users;
import user.UserData;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalTime;
import java.util.Base64;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class ValidateOutputs {

    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "1234567890123456".getBytes();

    public static String buildDateAndHour(LocalDate date, LocalTime time, boolean dayMinus, boolean monthMinus){

        StringBuilder builder = new StringBuilder();

        builder.append(getDayOfWeekString(date, dayMinus)).append(" " + date.getDayOfMonth() + " de ").append(getMonthOfYearString(date, monthMinus)).append(date.getYear() < 200 ? " de " : " del ").append(date.getYear());
        builder.append(" a las ").append(getHourAndMinutesString12HRSFormat(time));

        return builder.toString();

    }

    public static String getHourAndMinutesString12HRSFormat(LocalTime time){

        StringBuilder builder = new StringBuilder();

        String partOfDay;
        int hour =  time.getHour();
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

        builder.append(parseHour).append(time.getMinute() != 0 ? ":" : "").append(time.getMinute() != 0 ?String.format("%02d", time.getMinute()) : "").append(" de la ").append(partOfDay);

        return builder.toString();

    }

    private static final String[] chars = {
            "A","B","C","D","E","F","G","H","I","J","K","L","M",
            "N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            "0","1","2","3","4","5","6","7","8","9"
    };

    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decoded));
    }


    public static String[] generateSecurityCodes(){

        String[] codes = new String[10];
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for(int i = 0; i < codes.length; i++){

            do {

                sb.setLength(0);

                for(int j = 0; j<24; j++){

                    if(j > 0 && j % 4 == 0){

                        sb.append("-");

                    }

                    sb.append(chars[rand.nextInt(chars.length)]);

                }

            }while(!isUniqueCode(sb.toString(), codes));

            codes[i] = sb.toString();

        }

        return codes;

    }

    private static boolean isUniqueCode(String newCode, String [] codes){

        for(String code : codes){

            if(code != null){

                if(code.equalsIgnoreCase(newCode)){

                    return false;

                }

            }

        }

        return true;

    }

    public static String getPreferredWayToCallThem(){

        String call = "";

        if(UserData.getName() == null && UserData.getNickname() == null){

            System.out.println("No hay información valida de como llamar al usuario");
            return null;

        }

        if(UserData.getName() != null){

            call = getUserFirstName();

        }

        if(UserData.getNickname() != null){

            call = UserData.getNickname();

        }

        return call;

    }

    /**
     * Genera el correo escondido del usuario
     * @return correo oculto
     */

    public static String getEmailHide(){

        String email = UserData.getEmail();
        if (email == null || !email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            return email;
        }

        int atPos = email.indexOf('@');
        int visibleChars = Math.min(3, atPos);

        StringBuilder sb = new StringBuilder();
        sb.append(email, 0, visibleChars)
                .append("●●●")
                .append(email.substring(atPos));

        return sb.toString();

    }

    /**
     * Extrae el primer nombre del usuario
     * @return letras hasta el primer espacio.
     */

    public static String getUserFirstName(){

        if(UserData.getName() == null) return null;

        String [] parts = UserData.getName().trim().split("\\s+");;

        return parts[0];

    }

    /**
     * Genera un código de 10 carácteres aleatorios
     * @return Código generado
     */

    public static String generateCode10Chars(){

        StringBuilder code = new StringBuilder();

        Random rand = new Random();

        for(int i = 0; i <10 ; i++){

            code.append(chars[rand.nextInt(chars.length)]);

        }

        return code.toString();

    }

    /**
     * Encripta una contraseña en formato sha256Hexadecimal
     * @param input string a encriptar
     * @return string ya encriptado
     */

    public static String sha256Hex(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 no está disponible", e);
        }
    }


    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xFF));
        }
        return sb.toString();
    }

    /**
     * Genera un UserID y lo pone automaticamente si es correcto
     */

    public static void createUserID(){

        Users users = new Users();

        StringBuilder sb = new StringBuilder();

        Random rand = new Random();

        do{

            sb.setLength(0);

            for(int i = 0; i < 24; i++){

                sb.append(chars[rand.nextInt(chars.length)]);

            }

            UserData.setUserID(sb.toString());

        }while(!users.isUniqueUserID());

    }

    /**
     * Obtiene el mes en español de una fecha y retorna el mes en un String ya sea en formato con el primer caracter en mayúscula o con todas las letras en minúsculas
     * @param date fecha de la que se quiere saber el mes en LocalDate
     * @param minus true si se quiere en minúsculas, false si no
     * @return mes según el formato escogido
     */

    public static String getMonthOfYearString(LocalDate date, boolean minus){

        if(date == null) return "No hay ninguna fecha ingresada";

        Locale  locale = new Locale("es", "MX");

        Month month = date.getMonth();

        String result = month.getDisplayName(TextStyle.FULL, locale);

        return minus ? result.toLowerCase() : result.substring(0,1).toUpperCase() + result.substring(1);

    }

    /**
     * Obtiene el día de la semana de una fecha y retorna el día en un String ya sea en formato con el primer caracter en mayúscula o con todas las letras en minúsculas
     * @param date fecha de la que se quiere saber en LocalDate
     * @param minus true si se quiere en minúsculas, false si no
     * @return día de la semana según el formato escogido
     */

    public static String getDayOfWeekString(LocalDate date, boolean minus){

        if(date == null) return "No hay ninguna fecha ingresada";

        Locale dayOfWeek = new Locale("es", "MX");

        DayOfWeek day = date.getDayOfWeek();

        String result = day.getDisplayName(TextStyle.FULL, dayOfWeek);

        return minus ? result.toLowerCase() : result.substring(0,1).toUpperCase() + result.substring(1);

    }

    /**
     * Copia un String al portapapeles y devuelve true si se pudo copiar y false si no
     * @param text texto a copiar
     * @return validación de si se pudo copiar o no
     */

    public static boolean copyStringToClipboard(String text) {

        if(text == null) return false;

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        StringSelection seleccion = new StringSelection(text);

        clipboard.setContents(seleccion, null);

        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {

            try {

                String content = (String) clipboard.getData(DataFlavor.stringFlavor);
                if (text.equals(content)) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){

                e.printStackTrace();

            }

        }else{
            return false;
        }

        return false;

    }

}
