package com.pluralsight;
import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder billing = new StringBuilder();
        StringBuilder shipping = new StringBuilder();
        billing.append("Billing Street: \n");
        billing.append("Billing City: \n");
        billing.append("Billing State: \n");
        billing.append("Billing Zip: \n");

        String bills = billing.toString();

        shipping.append("Shipping Address: \n");
        shipping.append("Shipping City: \n");
        shipping.append("Shipping State: \n");
        shipping.append("Shipping Zip: \n");

        String ship = shipping.toString();
        System.out.println(ship);
        System.out.println(bills);
    }
}
