package com.pluralsight;

import java.util.Scanner;
public class FullNameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName, middleName, lastName, suffix, fullName;
        System.out.println("Enter your first name.");
        firstName = scanner.nextLine();
        firstName = firstName.trim();
        System.out.println("Enter your middle name. If none, type N/A.");
        middleName = scanner.nextLine();
        middleName = middleName.trim();
        System.out.println("Enter your last name.");
        lastName = scanner.nextLine();
        lastName = lastName.trim();
        System.out.println("Suffix? If none, type N/A.");
        suffix = scanner.nextLine();
        suffix = suffix.trim();

        fullName = firstName + middleName + lastName;

        if (middleName.equalsIgnoreCase("N/A")) {
            fullName = firstName + " " + lastName;
        }  else {
            fullName = firstName+ " "+middleName+ " "+ lastName;

        }
        if (suffix.equalsIgnoreCase("N/A")){
            fullName = fullName+ ". "+suffix;
        }

        {
            System.out.println(fullName);
        }


    }
}
