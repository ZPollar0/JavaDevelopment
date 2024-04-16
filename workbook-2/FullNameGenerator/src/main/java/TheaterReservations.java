package com.pluralsight;
import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullName, showDate, ticketNum;
        System.out.println("Please enter your full name.");
        fullName = scanner.nextLine();
        System.out.println("What date will you be coming? (MM/dd/yyyy");
        showDate = scanner.nextLine();
        System.out.println("How many tickets will you be purchasing?");
        ticketNum = scanner.nextLine();


    }
}
