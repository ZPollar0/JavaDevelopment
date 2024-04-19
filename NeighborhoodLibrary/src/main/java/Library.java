package com.pluralsight;
import java.util.Scanner;

class Book {
    // Create the variables, as private.
    private int id = 0;
    private String isbn = "";
    private String title = "";
    private boolean isCheckedOut = false;
    private String checkedOutTo = "";

    // Create the constrcutor.
    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    // Create the setter and getters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Create the checkOut method.
    public void checkOut(String name) {
        // If user wants to checkout a book, set book's isCheckedOut to true and set checkedOutTo to user's name.
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("Book is now checked out to " + name);
            // If the book is already checked out, print error.
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    // Create the checkIn method.
    public void checkIn() {
        // If user wants to check in a book, set the book's isCheckedOut to false and clear checkedOutTo.
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("Book now checked in.");
            // If book has already been checked in, print error.
        } else {
            System.out.println("Book is already checked in.");
        }
    }
}

public class Library {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the array that holds 20 books.
    static Book[] bookInventory = new Book[20];

    // Create the variables.
    static int userChoice;
    static String ifCheckOut;
    static String ifCheckIn;
    static int checkOutBook;
    static int checkInBook;

    public static void main(String[] args) {
        // Call the preloadBooks method.
        preloadBooks();

        // Call the userChoice method.
        userChoice();
    }

    // Create the preloadBooks method.
    public static void preloadBooks() {
        // Preload books into the array.
        bookInventory[0] = new Book(1, "9780679734772", "The Ancient Magus' Bride Vol. 12", true, "Karen Hill");
        bookInventory[1] = new Book(2, "0307743527", "Soul Eater Vol. 14", true, "Francois Parker");
        bookInventory[2] = new Book(3, "9781400078776", "Moby Dick", false, "");
        bookInventory[3] = new Book(4, "9780307387899", "Fruits Basket Vol. 8", true, "Karen Hill");
        bookInventory[4] = new Book(5, "1603093834", "Bakemonogatari pt.2", false, "");
        bookInventory[5] = new Book(6, "0345534832", "Lord of the Flies", true, "Carl Jenkins");
        bookInventory[6] = new Book(7, "0143123165", "The Hate You Give", true, "Carmen Smith");
        bookInventory[7] = new Book(8, "9780141196909", "Bones Vol. 5", false, "");
        bookInventory[8] = new Book(9, "0143107631", "Mushoku Tensei Vol. 12", true, "Zamir Pollard");
        bookInventory[9] = new Book(10, "037571457X", "Macbeth", false, "");
        bookInventory[10] = new Book(11, "067001690X", "The Very Hungry Caterpillar", true, "Chase Franco");
        bookInventory[11] = new Book(12, "014312854X", "No, David!", false, "");
        bookInventory[12] = new Book(13, "1101907878", "The Giver", false, "");
        bookInventory[13] = new Book(14, "0452284236", "1984", false, "");
        bookInventory[14] = new Book(15, "0142437255", "The Creation of Igneous Rocks ", true, "Sam Parks");
        bookInventory[15] = new Book(16, "0307264882", "My Teen Romance", false, "");
        bookInventory[16] = new Book(17, "0143124323", "The Secret Life of Bees", false, "");
        bookInventory[17] = new Book(18, "0307474518", "Space and Why It's Scary", false, "");
        bookInventory[18] = new Book(19, "0452298032", "The Great Gatsby", false, "");
        bookInventory[19] = new Book(20, "0593311892", "The Little Prince", false, "");
    }

    // Create the userInputs method.
    public static void userChoice() {
        // Ask the user that they want to do.
        System.out.println("What would you like to do?:");
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit");
        userChoice = scanner.nextInt();
        scanner.nextLine();

        // Read the user input and execute the appropiate method.
        switch (userChoice) {
            case 1:
                showAvailableBooks();
                break;
            case 2:
                showCheckedOutBooks();
                break;
            case 3:
                return;
        }
    }

    // Create showAvailableBooks method.
    public static void showAvailableBooks() {
        System.out.println("Available Books:");

        // Read the array for all the books that are not checked out and print them.
        for (Book book : bookInventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println("Title: " + book.getTitle() + " - " + "ID: " + book.getId() + " - " + "ISBN: " + book.getIsbn());
            }
        }

        // Ask user if they want to check out a book.
        System.out.println("\nDo you want to check out a book? (Yes/No): ");
        ifCheckOut = scanner.nextLine();

        // If user wants to check out a book.
        if (ifCheckOut.equalsIgnoreCase("yes")) {
            checkOutBook();
            // If user doesn't wantot check out a book.
        } else if (ifCheckOut.equalsIgnoreCase("no")) {
            userChoice();
        }
    }

    // Create showCheckedOutBooks method.
    public static void showCheckedOutBooks() {
        System.out.println("Currently Checked Out Books:");

        // Read the array for all the books that are checked out and print them.
        for (Book book: bookInventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println("Title: " + book.getTitle() + " - " + "ID: " + book.getId() + " - " + "ISBN: " + book.getIsbn() + " - " + "Checked out to: " + book.getCheckedOutTo());
            }
        }

        // Ask the user what would they like to do.
        System.out.println("What would you like to do?");
        System.out.println("C - Check In A Book.");
        System.out.println("X - Go Back to Home Screen.");
        ifCheckIn = scanner.nextLine();

        // Read the user input and execute the appropiate method.
        switch (ifCheckIn) {
            case "C":
                checkInBook();
                break;
            case "X":
                userChoice();
                break;
        }
    }

    // Create checkOutBook method.
    public static void checkOutBook() {
        // Ask the user for the ID of the book they want to check out.
        System.out.print("Please enter the ID of the book you want to check out: ");
        checkOutBook = scanner.nextInt();
        scanner.nextLine();

        // Create the variable.
        boolean found = false;

        // Look for the book in the array using the entered ID.
        for (Book book : bookInventory) {
            if (book != null && book.getId() == checkOutBook && !book.isCheckedOut()) {
                System.out.print("Please enter your name: ");
                String name = scanner.nextLine();

                book.checkOut(name);
                found = true;
                break;
            }
        }
    }

    // Create checkInBook method.
    public static void checkInBook() {
        // Ask the user for the ID of the book they want to check in.
        System.out.print("Please enter the ID of the book you want to check in: ");
        checkInBook = scanner.nextInt();

        // Create the variable.
        boolean found = false;

        // Look for the book in the array using the entered ID.
        for (Book book : bookInventory) {
            if (book != null && book.getId() == checkInBook && book.isCheckedOut()) {
                book.checkIn();
                found = true;
                break;
            }
        }
    }
}