package com.pluralsight;

public class Chips {
    private String brand;
    private double price;

    //Constructor
    public Chips(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
    //Create Getters
    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}
