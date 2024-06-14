package com.pluralsight;

public class Meat {
    //Private Variables
    private String name;
    private double fourInchPrice;
    private double eightInchPrice;
    private double twelveInchPrice;
    private boolean premium;
    private boolean extra;


    //Constructor
    public Meat(String name, double fourInchPrice, double eightInchPrice, double twelveInchPrice, boolean premium) {
        this.name = name;
        this.fourInchPrice = fourInchPrice;
        this.eightInchPrice = eightInchPrice;
        this.twelveInchPrice = twelveInchPrice;
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isExtra() {
        return extra;
    }
    public double getPrice(int size) {
        return switch (size) {
            case 4 -> fourInchPrice;
            case 8 -> eightInchPrice;
            case 12 -> twelveInchPrice;
            default -> throw new IllegalArgumentException("Size not found. Please select a size.");
        };
    }
}
