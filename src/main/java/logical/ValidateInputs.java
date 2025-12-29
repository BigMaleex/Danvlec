package logical;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidateInputs {

    /**
     * Verifica si una fecha (cumpleaños) es anterior al día de hoy, pero después que hace 100 años
     * @param birthday cumpleaños en String con formato dd/MM/yyyy
     * @return true si es una fecha valida, false si no
     */

    public static boolean isValidBirthday(String birthday){

        if(birthday == null) return false;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{

            LocalDate birthdayDate = LocalDate.parse(birthday, formatter);

            return birthdayDate.isBefore(LocalDate.now()) && birthdayDate.isAfter(LocalDate.now().minusYears(100));

        }catch(DateTimeException e){

            e.printStackTrace();
            return false;

        }

    }

    /**
     * valida si hay por lo menos una letra o palabra en un String
     * @param input entrada del usuario
     * @return valor verdadero o falso
     */

    public static boolean haveAnyWord (String input){

        if (input == null || input.length() == 0) return false;

        return !input.trim().isBlank();

    }

    /**
     * Mide si la cadena tiene la longitud solicitada o no
     * @param input
     * @param lon
     */

    public static boolean validateStringLength (String input, int lon){

        if(input == null) return false;

        return input.length() <= lon;

    }

}
