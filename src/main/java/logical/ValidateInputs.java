package logical;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidateInputs {

    /**
     * Verifica si una fecha es anterior al día de hoy (opcional), pero después que hace 100 años
     * @param date fecha en LocalDate
     * @return true si es una fecha valida, false si no
     */

    public static boolean isValidDate(LocalDate date, boolean todayIsValid){

        if(date == null) return false;

        if(todayIsValid){

            return !date.isAfter(LocalDate.now()) && date.isAfter(LocalDate.now().minusYears(100));

        }else{

            return date.isBefore(LocalDate.now()) && date.isAfter(LocalDate.now().minusYears(100));

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
