package com.pluralsight;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;


public class UserInterface {
    //Create a Scanner
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static Sandwich sandwich;
    static Order order = new Order();
    static int size;
    static double sandwichPrice;
    static double extraMeatCost;
    static double extraCheeseCost;
    static int choice;
    static String breadType;

    public static void main(String[] args) {
        boolean validChoice;
        do {
            validChoice = true;
            // Print home screen.
            System.out.println("\nHome Screen:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            // Ask user for their choice.
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();

                // Read the user input and execute the appropriate method.
                switch (choice) {
                    case 1:
                        handleNewOrder(scanner, order);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input.");
                        validChoice = false;
                }
                // If user enters invalid input, print error.
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.next();
                validChoice = false;
            }
        } while (!validChoice || choice != 0);
    }

    // Create handleNewOrder method.
    private static void handleNewOrder(Scanner scanner, Order order) {
        boolean validChoice;
        do {
            validChoice = true;
            // Print order screen.
            System.out.println("\nOrder Screen:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Signature Sandwiches");
            System.out.println("3) Add Drink");
            System.out.println("4) Add Chips");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");

            // Ask user for their choice.
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();

                // Read the user input and execute the appropriate method.
                switch (choice) {
                    case 1:
                        addSandwich(scanner, order);
                        break;
                    case 2:
                        signatureSandwich();
                    case 3:
                        addDrink(scanner, order);
                        break;
                    case 4:
                        addChips(scanner, order);
                        break;
                    case 5:
                        checkout();
                        break;
                    case 0:
                        System.out.println("Order canceled.");
                        break;
                    default:
                        System.out.println("Invalid input.");
                        validChoice = false;
                }
                // If user enters invalid input, print error.
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.next();
                validChoice = false;
            }
        } while (!validChoice || (choice != 0 && choice != 4));
    }

    // Create addSandwich method.
    private static void addSandwich(Scanner scanner, Order order) {
        boolean validChoice;
        do {
            validChoice = true;
            // Print bread options.
            System.out.println("\nAdding Sandwich:");
            System.out.println("Select your bread:");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");

            // Ask user for their choice.
            System.out.print("Enter your choice: ");
            int breadChoice;
            try {
                breadChoice = scanner.nextInt();

                // Read the user input and execute the appropriate method.
                switch (breadChoice) {
                    case 1:
                        breadType = "White";
                        break;
                    case 2:
                        breadType = "Wheat";
                        break;
                    case 3:
                        breadType = "Rye";
                        break;
                    case 4:
                        breadType = "Wrap";
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        validChoice = false;
                }
                // If user enters invalid input, print error.
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.next();
                validChoice = false;
            }
        } while (!validChoice);

        // Ask user to enter the size they want.
        do {
            System.out.print("\nEnter sandwich size (4, 8, or 12 inches): ");
            try {
                size = scanner.nextInt();
                if (size != 4 && size != 8 && size != 12) {
                    System.out.println("Invalid size. Please enter 4, 8, or 12.");
                    validChoice = false;
                } else {
                    validChoice = true;
                }
                // If user enters invalid input, print error.
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.next();
                validChoice = false;
            }
        } while (!validChoice);

        // Set sandwich bread and size.
        sandwich = new Sandwich(breadType, size);

        // Call meatChoice method.
        meatChoice();

        // Call cheeseChoice method.
        cheeseChoice();

        // Call toppingChoice method.
        toppingChoice();

        // Call sauceChoice method.
        sauceChoice();

        // Call sideChoice method.
        sideChoice();

        // Ask user if they want it toasted.
        do {
            validChoice = true;
            System.out.print("\nDo you want the sandwich toasted? (Yes/No): ");
            String toastedChoice = scanner.next().toLowerCase();

            if (toastedChoice.equals("yes")) {
                sandwich.setToasted(true);
            } else if (toastedChoice.equals("no")) {
                sandwich.setToasted(false);
                // If user enters invalid input, print error.
            } else {
                System.out.println("Invalid choice.");
                validChoice = false;
            }
        } while (!validChoice);

        // Add the sandwich to the order
        order.addSandwich(sandwich);

        // Print success message.
        System.out.println("Sandwich added to the order.");
    }

    // Create signatureSandwich method.
    public static void signatureSandwich() {
        // Print signature sandwiches menu.
        System.out.println("\nSignature Sandwiches:");
        System.out.println("1) BLT");
        System.out.println("2) Chicken Bacon Ranch");

        // Ask user for their choice.
        System.out.print("Enter your choice: ");
        int signatureChoice = scanner.nextInt();
        scanner.nextLine();

        Sandwich signatureSandwich = null;
        String signatureName = null;

        // Create the sandwich.
        switch (signatureChoice) {
            case 1:
                signatureSandwich = new BLT();
                signatureName = "BLT";
                break;
            case 2:
                signatureSandwich = new ChicBacRanch();
                signatureName = "Chicken Bacon Ranch";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Ask if the user wants to customize.
        System.out.print("Would you like to customize your " + signatureName + " sandwich? (Yes/No): ");
        String customizeChoice = scanner.nextLine().toLowerCase();

        // If user said yes.
        if (customizeChoice.equals("yes")) {
            boolean doneCustomizing = false;
            while (!doneCustomizing) {
                // Print customization options menu.
                System.out.println("\nCustomization Options:");
                System.out.println("1) Remove Toppings");
                System.out.println("2) Add Toppings");
                System.out.println("0) Done Customizing");

                // Ask user for their choice.
                System.out.print("Enter your choice: ");
                int customizationChoice = scanner.nextInt();
                scanner.nextLine();

                switch (customizationChoice) {
                    case 1:
                        // Print current toppings.
                        System.out.println("\nCurrent Toppings:");
                        int index = 1;
                        for (Toppings topping : signatureSandwich.getToppings()) {
                            System.out.println(index + ") " + topping.getName());
                            index++;
                        }

                        // Ask which toppings to remove.
                        System.out.print("Enter the toppings to remove (separated by a comma): ");
                        String toppingsToRemoveInput = scanner.nextLine();

                        // Split the input by commas.
                        String[] toppingIndexes = toppingsToRemoveInput.split(",");

                        // Remove the selected toppings.
                        for (String indexStr : toppingIndexes) {
                            int toppingIndex = Integer.parseInt(indexStr.trim());
                            if (toppingIndex >= 1 && toppingIndex <= signatureSandwich.getToppings().size()) {
                                signatureSandwich.removeTopping(signatureSandwich.getToppings().get(toppingIndex - 1).getName());
                            } else {
                                System.out.println("Invalid topping index: " + toppingIndex);
                            }
                        }
                        break;
                    case 2:
                        // Print available toppings
                        System.out.println("\nAvailable Toppings:");
                        System.out.println("1) Lettuce");
                        System.out.println("2) Peppers");
                        System.out.println("3) Onions");
                        System.out.println("4) Tomatoes");
                        System.out.println("5) Jalapeños");
                        System.out.println("6) Banana Peppers");
                        System.out.println("7) Pickles");
                        System.out.println("8) Olives");
                        System.out.println("9) Mushrooms");

                        // Ask user which topping they want to add.
                        System.out.print("Enter the toppings to add (separated by a comma): ");
                        String toppingsToAdd = scanner.nextLine();

                        // Add toppings.
                        String[] toppingNumbers = toppingsToAdd.split(",");
                        for (String toppingNumber : toppingNumbers) {
                            int toppingIndex = Integer.parseInt(toppingNumber.trim());

                            // Read the user input and execute the appropriate method.
                            switch (toppingIndex) {
                                case 1:
                                    signatureSandwich.addTopping(new Toppings("Lettuce"));
                                    break;
                                case 2:
                                    signatureSandwich.addTopping(new Toppings("Peppers"));
                                    break;
                                case 3:
                                    signatureSandwich.addTopping(new Toppings("Onions"));
                                    break;
                                case 4:
                                    signatureSandwich.addTopping(new Toppings("Tomatoes"));
                                    break;
                                case 5:
                                    signatureSandwich.addTopping(new Toppings("Jalapeños"));
                                    break;
                                case 6:
                                    signatureSandwich.addTopping(new Toppings("Banana Peppers"));
                                    break;
                                case 7:
                                    signatureSandwich.addTopping(new Toppings("Pickles"));
                                    break;
                                case 8:
                                    signatureSandwich.addTopping(new Toppings("Olives"));
                                    break;
                                case 9:
                                    signatureSandwich.addTopping(new Toppings("Mushrooms"));
                                    break;
                                default:
                                    System.out.println("Invalid topping choice.");
                            }
                        }
                        break;
                    case 0:
                        doneCustomizing = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        // Add the sandwich.
        if (signatureSandwich != null) {
            order.addSandwich(signatureSandwich);
            System.out.println("Customized " + signatureName + " sandwich added to the order.");
        }

        handleNewOrder(scanner, order);
    }

    // Create meatChoice method.
    public static void meatChoice() {
        // Print meat menu.
        System.out.println("\nSelect your meat:");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");

        // Ask user for their choice.
        System.out.print("Enter your choices: ");
        scanner.nextLine();
        int meatInput = scanner.nextInt();

        // Read the user input and execute the appropriate method.
        switch(meatInput) {
            case 1:
                sandwich.addMeat(new Meat("Steak", 1, 2, 3, true));
                break;
            case 2:
                sandwich.addMeat(new Meat("Ham", 1, 2, 3, true));
                break;
            case 3:
                sandwich.addMeat(new Meat("Salami", 1, 2, 3, true));
                break;
            case 4:
                sandwich.addMeat(new Meat("Roast Beef", 1, 2, 3, true));
                break;
            case 5:
                sandwich.addMeat(new Meat("Chicken", 1, 2, 3, true));
                break;
            case 6:
                sandwich.addMeat(new Meat("Bacon", 1, 2, 3, true));
                break;
            default:
                System.out.println("Invalid input.");
        }

        // Ask user if they want extra meat.
        boolean validChoice;
        do {
            validChoice = true;
            System.out.print("\nDo you want extra meat? (Yes/No): ");
            scanner.nextLine();
            String extraMeatChoice = scanner.nextLine().toLowerCase();
            extraMeatCost = 0;

            // Read the user input and execute the appropriate method.
            if (extraMeatChoice.equals("yes")) {
                // Calculate extra meat cost based on size.
                switch (size) {
                    case 4:
                        extraMeatCost = 0.50;
                        break;
                    case 8:
                        extraMeatCost = 1;
                        break;
                    case 12:
                        extraMeatCost = 1.50;
                        break;
                    default:
                        System.out.println("Invalid sandwich size.");
                        validChoice = false;
                        break;
                }
                // If user enters invalid input, print error.
            } else if (!extraMeatChoice.equals("no")) {
                System.out.println("Invalid choice.");
                validChoice = false;
            }
        } while (!validChoice);
    }

    // Create cheeseChoice method.
    public static void cheeseChoice() {
        // Print cheese options.
        System.out.println("\nSelect your cheese:");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Pepper Jack");

        // Ask user for their choice.
        System.out.print("Enter your choice: ");
        int cheeseChoice = scanner.nextInt();
        scanner.nextLine();

        // Read the user input and execute the appropriate method.
        switch (cheeseChoice) {
            case 1:
                sandwich.addCheese(new Cheese("American", true, 0.75, 1.50, 2.25));
                break;
            case 2:
                sandwich.addCheese(new Cheese("Provolone", true, 0.75, 1.50, 2.25));
                break;
            case 3:
                sandwich.addCheese(new Cheese("Cheddar", true, 0.75, 1.50, 2.25));
                break;
            case 4:
                sandwich.addCheese(new Cheese("Pepper Jack", true, 0.75, 1.50, 2.25));
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Ask user if they want extra cheese.
        System.out.print("\nDo you want extra cheese? (Yes/No): ");
        String extraCheeseChoice = scanner.nextLine().toLowerCase();
        extraCheeseCost = 0;

        // Read the user input and execute the appropriate method.
        if (extraCheeseChoice.equals("yes")) {
            // Calculate extra cheese cost based on size.
            switch (size) {
                case 4:
                    extraCheeseCost = 0.30;
                    break;
                case 8:
                    extraCheeseCost = 0.60;
                    break;
                case 12:
                    extraCheeseCost = 0.90;
                    break;
                default:
                    System.out.println("Invalid sandwich size.");
                    return;
            }
        }
    }

    // Create toppingChoice method.
    public static void toppingChoice() {
        // Print topping options.
        System.out.println("\nSelect your toppings:");
        System.out.println("1) Lettuce");
        System.out.println("2) Peppers");
        System.out.println("3) Onions");
        System.out.println("4) Tomatoes");
        System.out.println("5) Jalapeños");
        System.out.println("6) Banana Peppers");
        System.out.println("7) Pickles");
        System.out.println("8) Olives");
        System.out.println("9) Mushrooms");

        // Ask user for their choice.
        System.out.print("Enter your choices (numbers separated by a comma): ");
        String toppingInput = scanner.nextLine();

        // Split the input by commas and trim each topping
        String[] toppings = toppingInput.split(",");

        for (String topping : toppings) {
            try {
                int toppingChoice = Integer.parseInt(topping.trim());

                // If user enters invalid input, print error.
                if (toppingChoice < 1 || toppingChoice > 9) {
                    System.out.println("Invalid topping choice.");
                    continue;
                }

                // Read the user input and execute the appropriate method.
                switch (toppingChoice) {
                    case 1:
                        sandwich.addTopping(new Toppings("Lettuce"));
                        break;
                    case 2:
                        sandwich.addTopping(new Toppings("Peppers"));
                        break;
                    case 3:
                        sandwich.addTopping(new Toppings("Onions"));
                        break;
                    case 4:
                        sandwich.addTopping(new Toppings("Tomatoes"));
                        break;
                    case 5:
                        sandwich.addTopping(new Toppings("Jalapeños"));
                        break;
                    case 6:
                        sandwich.addTopping(new Toppings("Banana Peppers"));
                        break;
                    case 7:
                        sandwich.addTopping(new Toppings("Pickles"));
                        break;
                    case 8:
                        sandwich.addTopping(new Toppings("Olives"));
                        break;
                    case 9:
                        sandwich.addTopping(new Toppings("Mushrooms"));
                        break;
                }
                // If user enters invalid input, print error.
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    // Create sauceChoice method.
    public static void sauceChoice() {
        // Print sauce options.
        System.out.println("\nSelect your sauce:");
        System.out.println("1) Mayo");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) Ranch");
        System.out.println("5) Thousand Islands");
        System.out.println("6) Vinaigrette");

        // Ask user for their choice.
        System.out.print("Enter your choices: ");
        String sauceInputStr = scanner.nextLine();

        try {
            int sauceInput = Integer.parseInt(sauceInputStr.trim());

            // If user enters invalid input, print error.
            if (sauceInput < 1 || sauceInput > 6) {
                System.out.println("Invalid sauce choice.");
                return;
            }

            // Read the user input and execute the appropriate method.
            switch (sauceInput) {
                case 1:
                    sandwich.addSauce(new Sauce("Mayo"));
                    break;
                case 2:
                    sandwich.addSauce(new Sauce("Mustard"));
                    break;
                case 3:
                    sandwich.addSauce(new Sauce("Ketchup"));
                    break;
                case 4:
                    sandwich.addSauce(new Sauce("Ranch"));
                    break;
                case 5:
                    sandwich.addSauce(new Sauce("Thousand Islands"));
                    break;
                case 6:
                    sandwich.addSauce(new Sauce("Vinaigrette"));
                    break;
                default:
                    System.out.println("Invalid sauce choice.");
            }
            // If user enters invalid input, print error.
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    // Create sideChoice method.
    public static void sideChoice() {
        // Print side options.
        System.out.println("\nSelect your side:");
        System.out.println("1) Au Jus");
        System.out.println("2) Fries");

        // Ask user for their choice.
        System.out.print("Enter your choice: ");
        String sideInputStr = scanner.nextLine();

        try {
            int sideInput = Integer.parseInt(sideInputStr.trim());

            // If user enters invalid input, print error.
            if (sideInput < 1 || sideInput > 2) {
                System.out.println("Invalid side choice.");
                return;
            }

            // Read the user input and execute the appropriate method.
            switch (sideInput) {
                case 1:
                    order.addSide(new Side("Au Jus"));
                    break;
                case 2:
                    order.addSide(new Side("Fries"));
                    break;
                default:
                    System.out.println("Invalid side choice:");
            }
            // If user enters invalid input, print error.
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    // Create addDrink method.
    public static void addDrink(Scanner scanner, Order order) {
        // Print drink size menu.
        System.out.println("\nSelect drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        // Ask user for their choice.
        String sizeChoice;
        String size;
        double price;

        while (true) {
            System.out.print("Enter your choice: ");
            sizeChoice = scanner.next();

            // Read the user input and execute the appropriate method.
            switch (sizeChoice) {
                case "1":
                    size = "Small";
                    price = 2;
                    break;
                case "2":
                    size = "Medium";
                    price = 2.50;
                    break;
                case "3":
                    size = "Large";
                    price = 3;
                    break;
                default:
                    System.out.println("Invalid size choice.");
                    continue;
            }
            break;
        }

        scanner.nextLine();

        // Print drink type menu.
        System.out.println("\nSelect drink type:");
        System.out.println("1) Cola");
        System.out.println("2) Lemonade");
        System.out.println("3) Iced Tea");

        int drinkChoice;

        while (true) {
            // Ask user for their choice.
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                drinkChoice = scanner.nextInt();
                if (drinkChoice >= 1 && drinkChoice <= 3) {
                    break;
                    // If user enters invalid input, print error.
                } else {
                    System.out.println("Invalid input.");
                }
                // If user enters invalid input, print error.
            } else {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }

        String drinkType;

        // Read the user input and execute the appropriate method.
        switch (drinkChoice) {
            case 1:
                drinkType = "Cola";
                break;
            case 2:
                drinkType = "Lemonade";
                break;
            case 3:
                drinkType = "Iced Tea";
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }

        // Add the drink to the order.
        Drink drink = new Drink(size, drinkType, price);
        order.addDrink(drink);

        // Print success message.
        System.out.println("Drink added to the order.");
    }

    // Create addChips method.
    public static void addChips(Scanner scanner, Order order) {
        // Prompt for chip type
        System.out.println("\nSelect chip type:");
        System.out.println("1) Regular");
        System.out.println("2) BBQ");
        System.out.println("3) Sour Cream & Onion");
        System.out.println("4) Salt & Vinegar");

        int chipChoice;
        String chipType;
        double chipPrice;

        while (true) {
            // Ask user for their input.
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                chipChoice = scanner.nextInt();
                scanner.nextLine();
                if (chipChoice >= 1 && chipChoice <= 4) {
                    break;
                    // If user enters invalid input, print error.
                } else {
                    System.out.println("Invalid input.");
                }
            } else {
                // If user enters invalid input, print error.
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }

        // Set chip type and price based on user input
        switch (chipChoice) {
            case 1:
                chipType = "Regular";
                chipPrice = 1.50;
                break;
            case 2:
                chipType = "BBQ";
                chipPrice = 1.50;
                break;
            case 3:
                chipType = "Sour Cream & Onion";
                chipPrice = 1.50;
                break;
            case 4:
                chipType = "Salt & Vinegar";
                chipPrice = 1.50;
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }

        // Add the selected chips to the order with the calculated price
        Chips chips = new Chips(chipType, chipPrice);
        order.addChips(chips);

        // Print success message.
        System.out.println("Chips added to the order.");

        handleNewOrder(scanner, order);
    }

    // Create checkout method.
    public static void checkout() {
        // Print title.
        System.out.println("\n---- Your Order ----");

        double totalOrderPrice = 0.0;

        // Calculate total price for each sandwich.
        for (Sandwich sandwich : order.getSandwiches()) {
            if (size == 4) {
                sandwichPrice = sandwich.getPrice() + extraMeatCost + extraCheeseCost + 5.50;
            } else if (size == 8) {
                sandwichPrice = sandwich.getPrice() + extraMeatCost + extraCheeseCost + 7;
            } else if (size == 12) {
                sandwichPrice = sandwich.getPrice() + extraMeatCost + extraCheeseCost + 8.5;
            } else if (sandwich instanceof BLT) {
                sandwichPrice = 7.00 + 2.00 + 1.50;
            } else if (sandwich instanceof ChicBacRanch) {
                sandwichPrice = 7.00 + 2.00 + 1.50;
            }

            // Calculate total and print information.
            totalOrderPrice += sandwichPrice;
            System.out.println("\n---- Sandwich ----" + sandwich.getDescription() + "\nSandwich Price: $" + sandwichPrice);
        }

        // Add side to sandwich output.
        for (Side side : order.getSides()) {
            System.out.println("\n---- Side ----\n" + side.getName());
        }

        // Add the prices of drinks.
        for (Drink drink : order.getDrinks()) {
            totalOrderPrice += drink.getPrice();
            System.out.println("\n---- Drink ----\n" + drink.getSize() + " " + drink.getFlavor() + "\nDrink Price: $" + drink.getPrice());
        }

        // Add the prices of chips.
        for (Chips chips : order.getChips()) {
            totalOrderPrice += chips.getPrice();
            System.out.println("\n---- Chips ----\n" + chips.getBrand() + "\nChips Price: $" + chips.getPrice());
        }

        // Display the total order price.
        System.out.println("\nTotal Order Price: $" + totalOrderPrice + "\n");

        // Ask user to confirm or cancel the order.
        System.out.println("1) Confirm");
        System.out.println("2) Cancel");

        // Ask user for their choice.
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Save the order in a text file with proper file name.
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-hhmmss");
            String filename = dateFormat.format(new Date()) + ".txt";

            try {
                FileWriter writer = new FileWriter(filename);
                // Write title.
                writer.write("---- Order Details ----\n");

                // Write sandwich information.
                for (Sandwich sandwich : order.getSandwiches()) {
                    writer.write("\n---- Sandwich ----" + sandwich.getDescription() + "\nPrice: $" + sandwichPrice + "\n");
                }

                // Write drink information.
                for (Drink drink : order.getDrinks()) {
                    writer.write("\n---- Drink ----\n" + drink.getSize() + " " + drink.getFlavor() + "\nPrice: $" + drink.getPrice() + "\n");
                }

                // Write chips information.
                for (Chips chips : order.getChips()) {
                    writer.write("\n---- Chips ----\n" + chips.getBrand() + "\nPrice: $" + chips.getPrice() + "\n");
                }

                // Write total price of order.
                writer.write("\nTotal Order Price: $" + totalOrderPrice + "\n");
                writer.close();

                // Print success message.
                System.out.println("\nOrder confirmed. Order details saved in " + filename);

                // Clear the order after it's confirmed.
                order.clearOrder();
                // If an error occurs, print error.
            } catch (IOException e) {
                System.out.println("\nError occurred while saving order.");
                e.printStackTrace();
            }
        } else if (choice == 2) {
            // Cancel the order
            order.clearOrder();

            // Print success message.
            System.out.println("\nOrder canceled.");
            // If user enters invalid input, print error.
        } else {
            System.out.println("\nInvalid choice.");
        }
    }
}