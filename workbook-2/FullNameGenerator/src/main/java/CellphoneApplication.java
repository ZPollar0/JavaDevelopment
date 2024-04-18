package com.pluralsight;
import java.util.Scanner;

public class Cellphone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone cp1 = new CellPhone();
        System.out.println("What is the serial number? ");
        long sn = scanner.nextLong();
        cp.set
        System.out.println("What model is the phone? ");
        String model = scanner.nextLine();
        System.out.println("Who is the carrier? ");
        String carrier = scanner.nextLine();
        System.out.println("What is the phone number? ");
        String phoneNum = scanner.nextLine();
        System.out.println("Who is the owner of the phone? ");
        String owner = scanner.nextLine();
        cp1.setOwner(owner);

    }
    public static void display(CellPhone phone){
        String details = phone.getOwner() + " owns this phone "+ phone.getPhoneNumber()+" and their carrier is "+phone.getCarrier()+

    }
}
