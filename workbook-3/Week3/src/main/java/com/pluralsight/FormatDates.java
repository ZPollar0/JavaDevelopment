package com.pluralsight;
import java.time.*;
import java.time.format.*;

public class FormatDates {
    // Create the variables.
    static LocalDateTime now;
    static DateTimeFormatter dateFormat1;
    static DateTimeFormatter dateFormat2;
    static DateTimeFormatter dateFormat3;
    static DateTimeFormatter dateFormat4;
    static ZonedDateTime localTime;
    static DateTimeFormatter dateFormat5;

    public static void main(String[] args) {
        // Get current date and time.
        now = LocalDateTime.now();

        // Call the setFormats method.
        setFormats();

        // Call the localTime method.
        localTime();

        // Call the printTime method.
        printTime();
    }

    public static void setFormats() {
        // MM/dd/yyyy format.
        dateFormat1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // yyyy-MM-dd format.
        dateFormat2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // MMMM d, yyyy format.
        dateFormat3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");

        // EEE, MMM d, yyyy HH:mm format.
        dateFormat4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
    }

    public static void localTime() {
        // Convert time to local time zone.
        localTime = now.atZone(ZoneId.systemDefault());

        // Set the format.
        dateFormat5 = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy");
    }

    public static void printTime() {
        // Print the current date and time in the different formats.
        System.out.println(dateFormat1.format(now));
        System.out.println(dateFormat2.format(now));
        System.out.println(dateFormat3.format(now));
        System.out.println(dateFormat4.format(now.atZone(ZoneId.of("GMT"))));

        // Print the time in local time zone and date.
        System.out.println("\nChallenge:");
        System.out.println(dateFormat5.format(localTime));
    }
}