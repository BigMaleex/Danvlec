package logical;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateTimeElapsed {

    public static int[] timeElapsed(LocalDateTime startDateTime) {

        LocalDateTime endDateTime = LocalDateTime.now();

        if (startDateTime.isAfter(endDateTime)) {
            throw new IllegalArgumentException("La fecha proporcionada es posterior a la actual");
        }

        long years = startDateTime.until(endDateTime, ChronoUnit.YEARS);
        startDateTime = startDateTime.plusYears(years);

        long months  = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
        startDateTime = startDateTime.plusMonths(months);

        long days = startDateTime.until(endDateTime, ChronoUnit.DAYS);
        startDateTime = startDateTime.plusDays(days);

        long hours   = startDateTime.until(endDateTime, ChronoUnit.HOURS);
        startDateTime = startDateTime.plusHours(hours);

        long minutes = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
        startDateTime = startDateTime.plusMinutes(minutes);

        long seconds = startDateTime.until(endDateTime, ChronoUnit.SECONDS);

        return new int[]{
                (int) years,
                (int) months,
                (int) days,
                (int) hours,
                (int) minutes,
                (int) seconds
        };

    }

}
