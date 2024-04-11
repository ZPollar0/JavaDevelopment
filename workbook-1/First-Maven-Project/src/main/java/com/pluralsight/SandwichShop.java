package workbook_1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SandwichShop {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // Create the variables.
    static double regularSandwich = 5.45;
    static double largeSandwich = 8.95;
    static double total;
    static double discount;
    static int sandwichSize;
    static String loaded;
    static int age;

    public static void main(String[] args) {
        // Ask the user what size sandwich they want.
        System.out.println("What size sandwich would you like?");
        System.out.println("1: Regular");
        System.out.println("2: Large");
        sandwichSize = scanner.nextInt();
        scanner.nextLine();

        // Ask the user if they want the sandwich "loaded".
        System.out.print("Would you like a loaded sandwich? (Yes/No) ");
        loaded = scanner.nextLine();

        // Ask the user how old they are.
        System.out.print("How old are you? ");
        age = scanner.nextInt();

        // If user chose a regular sandwich, is under 17, and wants it loaded.
        if (sandwichSize == 1 && age <= 17 && loaded.equalsIgnoreCase("yes")) {
            underageLoadedRegular();
            // If user chose a regular sandwich, is over 65, and wants it loaded.
        } else if (sandwichSize == 1 && age >= 65 && loaded.equalsIgnoreCase("yes")) {
            seniorLoadedRegular();
        }

        // If user chose a regular sandwich, is under 17, and doesn't want it loaded.
        if (sandwichSize == 1 && age <= 17 && loaded.equalsIgnoreCase("no")) {
            underageRegular();
            // If user chose a regular sandwich, is over 65, and doesn't want it loaded.
        } else if (sandwichSize == 1 && age >= 65 && loaded.equalsIgnoreCase("no")) {
            seniorRegular();
        }

        // If user chose a large sandwich, is under 17, and wants it loaded.
        if (sandwichSize == 2 && age <= 17 && loaded.equalsIgnoreCase("yes")) {
            underageLoadedLarge();
            // If user chose a large sandwich, is over 65, and wants it loaded.
        } else if (sandwichSize == 2 && age >= 65 && loaded.equalsIgnoreCase("yes")) {
            seniorLoadedLarge();
        }

        // If user chose a large sandwich, is under 17, and doesn't want it loaded.
        if (sandwichSize == 2 && age <= 17 && loaded.equalsIgnoreCase("no")) {
            underageLarge();
            // If user chose a large sandwich, is over 65, and doesn't want it loaded.
        } else if (sandwichSize == 2 && age >= 65 && loaded.equalsIgnoreCase("no")) {
            seniorLarge();
        }

        // Print the total.
        printTotal();
    }

    // Regular sandwich, is under 17, and loaded.
    public static void underageLoadedRegular() {
        // Calculate the discount.
        discount = regularSandwich * .10;

        // Calculate the total with the discount.
        total = regularSandwich + 1 - discount;
    }

    // Regular sandwich, is under 17, and isn't loaded.
    public static void underageRegular() {
        // Calculate the discount.
        discount = regularSandwich * .10;

        // Calculate the total with the discount.
        total = regularSandwich - discount;
    }

    // Large sandwich, is under 17, and loaded.
    public static void underageLoadedLarge() {
        // Calculate the discount.
        discount = largeSandwich * .10;

        // Calculate the total with the discount.
        total = largeSandwich + 1.75 - discount;
    }

    // Large sandwich, is under 17, and isn't loaded.
    public static void underageLarge() {
        // Calculate the discount.
        discount = largeSandwich * .10;

        // Calculate the total with the discount.
        total = largeSandwich - discount;
    }

    // Regular sandwich, is over 65, and loaded.
    public static void seniorLoadedRegular() {
        // Calculate the discount.
        discount = regularSandwich * .20;

        // Calculate the total with the discount.
        total = regularSandwich + 1 - discount;
    }

    // Regular sandwich, is over 65, and isn't loaded.
    public static void seniorRegular() {
        // Calculate the discount.
        discount = regularSandwich * .20;

        // Calculate the total with the discount.
        total = regularSandwich - discount;
    }

    // Large sandwich, is over 65, and loaded.
    public static void seniorLoadedLarge() {
        // Calculate the discount.
        discount = largeSandwich * .20;

        // Calculate the total with the discount.
        total = largeSandwich + 1.75 - discount;
    }

    // Large sandwich, is over 65, and isn't loaded.
    public static void seniorLarge() {
        // Calculate the discount.
        discount = largeSandwich * .20;

        // Calculate the total with the discount.
        total = largeSandwich - discount;
    }

    // What to print for total.
    public static void printTotal() {
        System.out.println("The total is: $" + df.format(total));
    }
}