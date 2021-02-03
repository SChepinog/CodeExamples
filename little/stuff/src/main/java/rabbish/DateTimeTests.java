package rabbish;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateTimeTests {

    public static void main(String[] args) throws InterruptedException {
        String testString = "03/16/2020 12:53 PM (MSK)";
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
//        sleep(5_000);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.minusMinutes(1));
//        System.out.println(localDateTime1.format(DateTimeFormatter.RFC_1123_DATE_TIME));
        System.out.println(localDateTime1.format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a")));
        localDateTime1.getChronology();
        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
//        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a (z)")));
        System.out.println(ZonedDateTime.parse(testString, DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a (z)")).getSecond());

        long days = DAYS.between(LocalDateTime.now(), LocalDateTime.now().minusDays(54));
        System.out.println(days);

        long daysPlus = DAYS.between(LocalDateTime.now().minusDays(54), LocalDateTime.now());
        System.out.println(daysPlus);
    }
}
