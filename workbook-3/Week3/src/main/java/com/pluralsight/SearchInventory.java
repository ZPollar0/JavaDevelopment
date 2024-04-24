
import com.pluralsight.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the array.
    private ArrayList<Product> inventory;

    // Create the variables.
    static SearchInventory searchInventory;
    static int choice;
    static int id;
    static Product product;
    static double minPrice;
    static double maxPrice;
    static ArrayList<Product> productsInRange;
    static int newId;
    static String newName;
    static double newPrice;
    static ArrayList<Product> productsInPriceRange;
    static String line;
    static String delimiter;
    static String csvFile;

    public static void main(String[] args) {
        searchInventory = new SearchInventory();

        do {
            // Create the menu.
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Read the user input and execute the appropiate method.
            switch (choice) {
                case 1:
                    printArray();
                    break;
                case 2:
                    lookupProductID();
                    break;
                case 3:
                    findByPrice();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    System.out.println("Quitting the application.");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    public static void printArray() {
        // Call listAllProducts method to print all the products.
        searchInventory.listAllProducts();
    }

    public static void lookupProductID() {
        // Ask for the product ID to search.
        System.out.print("Enter product ID: ");
        id = scanner.nextInt();

        // Call lookupByID method to find the product.
        product = searchInventory.lookupByID(id);

        // Print message if product was found.
        if (product != null) {
            System.out.println("\nProduct found: " + product);
            // Print error messsage if product not found.
        } else {
            System.out.println("Product not found");
        }
    }

    public static void findByPrice() {
        // Ask user for minimum price.
        System.out.print("Enter minimum price: ");
        minPrice = scanner.nextDouble();

        // Ask user for maximum price.
        System.out.print("Enter maximum price: ");
        maxPrice = scanner.nextDouble();

        // Call findByPriceRange to search array for products within minimum and maximum price.
        productsInRange = searchInventory.findByPriceRange(minPrice, maxPrice);

        // Print message if it found products.
        if (!productsInRange.isEmpty()) {
            System.out.println("\nProducts within price range:");
            for (Product p : productsInRange) {
                System.out.println(p);
            }
            // Print error messsage if no products found.
        } else {
            System.out.println("No products found within the price range.");
        }
    }

    public static void addProduct() {
        // Ask user for the product ID.
        System.out.print("Enter product ID: ");
        newId = scanner.nextInt();
        scanner.nextLine();

        // Ask user for the name of the product.
        System.out.print("Enter product name: ");
        newName = scanner.nextLine();

        // Ask user for the price of the product.
        System.out.print("Enter product price: ");
        newPrice = scanner.nextDouble();

        // Call addNewProduct method to add product to array.
        searchInventory.addNewProduct(new Product(newId, newName, newPrice));

        // Print message once added to array.
        System.out.println("\nNew product added successfully.");
    }

    // Create the SearchInventory method.
    public SearchInventory() {
        this.inventory = new ArrayList<>();
    }

    // Create the getInventory method.
    public ArrayList<Product> getInventory() {
        // Read data from products.csv file
        csvFile = "products.csv";

        // Create the variables.
        String line;
        String delimiter = "\\|";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Split the items from products.csv.
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(delimiter);
                if (parts.length == 3) {
                    // Set the values from parts.
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    // Add the items to the array.
                    inventory.add(new Product(id,name,price));
                }
            }
            // Print error if it runs into an error.
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventory;
    }

    // Create the listAllProducts method.
    public void listAllProducts() {
        getInventory();

        // Sort the products in the array.
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        // Print the products.
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    // Create the lookupByID method.
    public Product lookupByID(int id) {
        // Lookup product by the ID.
        for (Product product : inventory) {
            if (product.getId() == id) {
                return product;
            }
        }

        // Return if nothing was found.
        return null;
    }

    // Create the findByPriceRange method.
    public ArrayList<Product> findByPriceRange(double minPrice, double maxPrice) {
        // Create a new array to hold the products that meets price range.
        productsInPriceRange = new ArrayList<>();

        // Add products to productsInPriceRange if product fits price range.
        for (Product product : inventory) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                productsInPriceRange.add(product);
            }
        }

        return productsInPriceRange;
    }

    // Create the addNewProduct method.
    public void addNewProduct(Product product) {
        // Add the product to the array.
        inventory.add(product);
    }
}
