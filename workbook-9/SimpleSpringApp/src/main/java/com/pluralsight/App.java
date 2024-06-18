package com.pluralsight;

import com.pluralsight.dao.SimpleProductDAO;
import com.pluralsight.model.Product;
import com.pluralsight.model.Student;
import com.pluralsight.service.RegistrationService;
import com.pluralsight.service.StudentAlreadyRegisteredException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws StudentAlreadyRegisteredException {
        // Open beans.xml where in this file there is a directive
        // called component-scan Spring scans the files in the
        // package declared looking for annotations like
        // @Component and @Autowired. Spring will then do the
        // wiring for you.

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        // Pluck out the Registration Service from Spring. Think
        // of your application like black box and you are asking
        // for a component of a certain type.
        // RegistrationService will already have the
        // DataAccessObject injected into it by the time
        // you receive this reference
       /* RegistrationService registrationService = ctx.getBean(RegistrationService.class);
        Long studentID = registrationService.registerStudent(
                new Student("Alan", "Turing", "Computer Science"));
        System.out.println("Student Registered with ID: " + studentID);
        Long studentID2 = registrationService.registerStudent(
                new Student("Johannes", "Kepler", "Astronomy"));
        System.out.println("Student Registered with ID: " +studentID2);*/

        SimpleProductDAO simpleProductDAO = ctx.getBean(SimpleProductDAO.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. List Products");
        System.out.println("2. Add Products");
        System.out.println("3. Delete Product");
        System.out.println("4. Update Product");
        System.out.println("5. Search for Product");
        System.out.println("0. Exit");
        int option = scanner.nextInt();
        while (option != 0){
            switch (option){
                case 1:
                    System.out.println(simpleProductDAO.getAll());
                    break;
                case 2:
                    System.out.print("Product ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Product price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(id, name, category, price);
                    simpleProductDAO.add(product);
                    System.out.println(simpleProductDAO.getAll());
                    break;
                case 3:
                    System.out.print("What is the id of the product you would like to delete? ");
                    int id2 = scanner.nextInt();
                    simpleProductDAO.delete(id2);
                    break;
                case 4:
                    Product product1 = new Product(2, "ketchup","Groceries",5.99);
                    simpleProductDAO.update(product1);
                    System.out.println(simpleProductDAO.getAll());
                    break;
                case 5:
                    System.out.print("What is the id of the product you would like to search for? ");
                    int id3 = scanner.nextInt();
                    System.out.println(simpleProductDAO.search(id3));
                    break;
            }
            System.out.println("Do you want to go again? 1, 2, 3, 4, 5 or 0 to exit");
            option = scanner.nextInt();
        }

    }
}