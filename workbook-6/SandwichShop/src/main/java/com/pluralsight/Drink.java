package com.pluralsight;

public class Drink {
    private String size;
    private String flavor;
    private double price;

    //Constructor
    public Drink(String size, String flavor, double price) {
        this.size = size;
        this.flavor = flavor;
        this.price = price;
    }
    //Create Getters

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }
}
