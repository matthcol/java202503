package basics.demo;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.stream.Stream;

public class DemoTemps {

    @Test
    void demoDate(){
        Date date1 = new Date();
        System.out.println(date1); // Thu Mar 13 13:17:59 CET 2025

        Date date2 = null; // TODO
    }

    @Test
    void demoCalendar(){
        Calendar dateGC1 = Calendar.getInstance();
        System.out.println(dateGC1);
        System.out.println(dateGC1.getClass()); // class java.util.GregorianCalendar
        System.out.println("year : " + dateGC1.get(Calendar.YEAR));
        System.out.println("month : " + dateGC1.get(Calendar.MONTH)); // numéroté à partir de 0 !

        // downcasting
        // GregorianCalendar dateGC = (GregorianCalendar) dateGC1;

        Calendar dateGC2 = new GregorianCalendar(2024, 1, 29); // 29/02/2024
        Calendar dateGC3 = new GregorianCalendar(2000, Calendar.FEBRUARY, 29);
        Calendar dateGC4 = new GregorianCalendar(2100, Calendar.FEBRUARY, 29, 13, 34);

        System.out.println();
        // format de Date: voir tableau API JAVA
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/SimpleDateFormat.html
        SimpleDateFormat formatDateFr = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatDateTimeFr = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Stream.of(dateGC1, dateGC2, dateGC3, dateGC4)
                .forEach(dateGC -> {
                    System.out.println(dateGC);
                    System.out.println(MessageFormat.format(
                            "{0,number,00}/{1,number,00}/{2,number,####}",
                            dateGC.get(Calendar.DAY_OF_MONTH),
                            dateGC.get(Calendar.MONTH) + 1,
                            dateGC.get(Calendar.YEAR)
                    ));

                    // convert GC => Date before formatting
                    Date date = dateGC.getTime();
                    System.out.println(formatDateFr.format(date));
                    System.out.println(formatDateTimeFr.format(date));
                    System.out.println(MessageFormat.format(
                            "dateGC ISO = {0,date,yyyy-dd-MM} ; time = {0,date,HH:mm:ss}",
                            date
                    ));
                    System.out.println();
                });
    }

    @Test
    void demoModernTemporalTypesNow(){
        LocalDateTime dt1 = LocalDateTime.now();
        ZonedDateTime zdt1 = ZonedDateTime.now();
        LocalDate d1 = LocalDate.now();
        LocalTime t1 = LocalTime.now();
        Stream.of(dt1, zdt1, d1, t1)
                .forEach(System.out::println); // reference de fonction

        System.out.println();
        System.out.println("Year: " + dt1.getYear());
        System.out.println("Month (object): " + dt1.getMonth());
        System.out.println("Month (nombre): " + dt1.getMonth().getValue());
        System.out.println("Month (nombre): " + dt1.getMonthValue());
        System.out.println("Day (of month): " + dt1.getDayOfMonth());
        System.out.println("Day (of year): " + dt1.getDayOfYear());

        // etc.
    }

    @Test
    void demoModernTemporalTypesBuild(){
        LocalDateTime dt1 = LocalDateTime.of(2024, 2, 29, 0, 0);
        LocalDateTime dt2 = LocalDateTime.of(2024, 2, 29, 14, 40, 23, 111);
        LocalDate d1 = LocalDate.of(2025, 2, 28);
        LocalTime t1 = LocalTime.of(15, 25, 59, 999999999);
        LocalTime t2 = LocalTime.of(16, 33);

        // concat date + time
        LocalDateTime dt3 = LocalDateTime.of(d1, t1);

        // split datetime => date + time
        // TODO
//        LocalDate d2 = dt2.get???;
//        LocalTime t3 = dt2.get???;

        Stream.of(dt1, dt2, dt3, d1, t1, t2)
                .forEach(System.out::println);  // snippet: soutc

        System.out.println();
        System.out.println(dt1);
        LocalDateTime dt4 = dt1.plusHours(2);
        System.out.println("+2H => " + dt4);
        dt4 = dt1.plusDays(3).plusMinutes(30);
        System.out.println("+3J 30mn => " + dt4);
        // NB: idem avec minus

        Duration duration = Duration.between(dt1, dt2);
        System.out.println("Ecart => " + duration);
        System.out.println("Ecart (s) => " + duration.getSeconds());
        // NB: see also Period

        Duration duration2 = Duration.ofHours(72);
        var dt5 = dt1.plus(duration2);
        System.out.println("+72H => " + dt5);

        duration2 = Duration.ofDays(3).plusHours(4);
        var dt6 = dt1.plus(duration2);
        System.out.println("+3J +4H => " + dt6);

        System.out.println();
        System.out.println(dt1);;
        duration2 = Duration.parse("P3DT2H12.567S");
        var dt7 = dt1.plus(duration2);
        System.out.println("3 days 2 hours 12 seconds 567ms => " + dt7);
    }

    @Test
    void demoModernTemporalTypesFormat(){
        // format + parse datetime, date, time
        String dateFrStr = "13/03/2026"; // => LocalDate
        String datetimeIsoStr = "2025-03-05T13:45:23"; // => LocalDateTime

        // Voir tableau des formats dans l'API de Java
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter formatDateFr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatDateTimeFr = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        LocalDate dateFr = LocalDate.parse(dateFrStr, formatDateFr); // String => LocalDate with format FR
        System.out.println(dateFr); // display ISO format
        System.out.println(formatDateFr.format(dateFr)); // display format FR

        System.out.println();
        LocalDateTime datetimeIso = LocalDateTime.parse(datetimeIsoStr); // convert from ISO Format (default)
        System.out.println(datetimeIso); // display ISO format
        System.out.println(formatDateFr.format(datetimeIso)); // display format date FR
        System.out.println(formatDateTimeFr.format(datetimeIso)); // display format datetime FR

        System.out.println();

        // exercice : afficher l'horodatage en français : mercredi 5 mars 2025 13:25
        DateTimeFormatter formatDateTimeFrVerbose = DateTimeFormatter.ofPattern("eeee d MMMM yyyy HH:mm"); // default locale (FR for me)
        System.out.println(formatDateTimeFrVerbose.format(datetimeIso));

        // exercice : afficher l'horodatage en anglais : wednesday march 5 2025 13:25
        DateTimeFormatter formatDateTimeEnVerbose = DateTimeFormatter.ofPattern("eeee MMMM d yyyy HH:mm", Locale.ENGLISH);
        System.out.println(formatDateTimeEnVerbose.format(datetimeIso));

        DateTimeFormatter formatDateTimeEsVerbose = DateTimeFormatter.ofPattern("eeee d MMMM yyyy HH:mm", Locale.of("es", "ES"));
        System.out.println(formatDateTimeEsVerbose.format(datetimeIso));
    }

    // timezone
    @Test
    void demoTimezones(){
        var tzJapan = ZoneId.of("Asia/Tokyo");
        var zdt = ZonedDateTime.now(tzJapan);
        System.out.println(zdt);
    }

    @Test
    void demoTimezones2(){
        Stream.of(
                ZoneId.of("Asia/Tokyo"),
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Europe/Paris"),
                ZoneId.of("Europe/London"),
                ZoneId.of("America/New_York"),
                ZoneId.of("America/Los_Angeles")
        ).forEach(tz -> System.out.println(tz + " : " + ZonedDateTime.now(tz)));
    }

}



























