package com.pluralsight;
import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullName;
        String nameArray[];

        System.out.println("Please enter your name.");
        fullName = scanner.nextLine();
        fullName =fullName.trim();
        nameArray =fullName.split(" ");

        if (nameArray.length==2){

        }

    }
}
