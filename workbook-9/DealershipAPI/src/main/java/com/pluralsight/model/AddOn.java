package com.pluralsight.model;

public class AddOn {
    // Initialize the variables.
    private String name;
    private double price;

    // Create the constructor.
    public AddOn(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Create the getters.
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}