package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Examples {


    public static void main(String[] args) {
        LocalDate myBirthday = LocalDate.of(2001, 11, 27);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("ru-Ru"));
        String formattedDate = myBirthday.format(formatter);
        System.out.println(formattedDate);

        DayOfWeek dayOfWeek = myBirthday.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.FRIDAY) {
            System.out.println("Дата " + formattedDate + " была пятницей.");
        } else {
            System.out.println("Дата " + formattedDate + " не была пятницей.");
            System.out.println("Это был(а) " + dayOfWeek);
        }

        LocalDate tenYearsEarlier = myBirthday.minusYears(10);
        String formattedTenYearsEarlier = tenYearsEarlier.format(formatter);
        System.out.println("Дата, вычитанная 10 лет из " + formattedDate + ": " + formattedTenYearsEarlier);

        String timeZoneId = "Pacific/Midway";
        ZoneId zoneId = ZoneId.of(timeZoneId);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println("Значение ZonedDateTime: " + zonedDateTime);
    }
}
