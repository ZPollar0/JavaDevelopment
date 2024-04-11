package com.pluralsight;
import java.util.Scanner;
import java.text.DecimalFormat;

public class RentalCarCalculator {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // Create the variables.
    static double tagPrice = 3.95;
    static double gpsPrice = 2.95;
    static double roadsidePrice = 3.95;
    static double rentalPrice = 29.99;
    static double underageRate = .30;
    static double optionsTotal = 0;
    static double underageTotal = 0;
    static String pickupDate;
    static int rentDays;
    static String tollTag;
    static String gps;
    static String roadside;
    static int age;
    static double noOptionsRental;

    public static void main(String[] args) {
        // Ask the user the pickup date.
        System.out.println("What is the pickup date? (MM/DD/YYYY)");
        pickupDate = scanner.nextLine();

        // Ask the user how many days they want to rent.
        System.out.println("How many days do you want to rent for?");
        rentDays = scanner.nextInt();

        // Ask the user if they want an electronic toll tag.
        System.out.println("Do you want an electronic toll tag at $3.95/day? (Yes/No)");
        tollTag = scanner.nextLine();
        scanner.nextLine();

        // Ask the user if they want a GPS.
        System.out.println("Do you want a GPS at $2.95/day? (Yes/No)");
        gps = scanner.nextLine();

        // Ask the user if they want roadside assistance.
        System.out.println("Do you want roadside assistance at $3.95/day? (Yes/No)");
        roadside = scanner.nextLine();

        // Ask the user their age.
        System.out.println("What is your age?");
        age = scanner.nextInt();

        // Calculate car rental without any options.
        noOptions();

        // Calculate electronic toll tag total if user said yes.
        if (tollTag.equalsIgnoreCase("yes")) {
            wantsTollTag();
        }

        // Calculate GPS total if user said yes.
        if (gps.equalsIgnoreCase("yes")) {
            wantsGPS();
        }

        // Calculate roadside assistance total if user said yes.
        if (roadside.equalsIgnoreCase("yes")) {
            wantsRoadside();
        }

        // Calculate underage surcharge if user is 25 or younger.
        if (age <= 25) {
            isUnderage();
        }

        // Calculate and print everything.
        finalPrint();
    }

    // No rental options calculation.
    public static void noOptions() {
        noOptionsRental = rentalPrice * rentDays;
    }

    // Electronic toll tag calculation.
    public static void wantsTollTag() {
        optionsTotal += tagPrice * rentDays;
    }

    // GPS calculation.
    public static void wantsGPS() {
        optionsTotal += gpsPrice * rentDays;
    }

    // Roadside assistance calculation.
    public static void wantsRoadside() {
        optionsTotal += roadsidePrice * rentDays;
    }

    // Underage calculation.
    public static void isUnderage() {
        underageTotal = rentalPrice * underageRate;
    }

    // Final calculation and print.
    public static void finalPrint() {
        // Calculate total cost of the rental.
        double totalCost = rentalPrice + optionsTotal + underageTotal;

        // Print out the calculations.
        System.out.println("Rental Summary:");
        System.out.println("Basic Car Rental Cost: $" + df.format(rentalPrice));
        System.out.println("Total Options Cost: $" + df.format(optionsTotal));
        System.out.println("Underage Driver Surcharge Cost: $" + df.format(underageTotal));
        System.out.println("Total Cost: $" + df.format(totalCost));
    }
}