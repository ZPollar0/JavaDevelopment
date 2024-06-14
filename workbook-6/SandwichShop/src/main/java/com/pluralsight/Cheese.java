package com.pluralsight;

public class Cheese {
    //Private Variables
    private String name;
    private boolean premium;
    private boolean extra;
    private double fourInchPrice;
    private double eightInchPrice;
    private double twelveInchPrice;
    private String cheeseType;

    //Constructors
    public Cheese(String name, boolean premium, double fourInchPrice, double eightInchPrice, double twelveInchPrice) {
        this.name = name;
        this.premium = premium;
        this.fourInchPrice = fourInchPrice;
        this.eightInchPrice = eightInchPrice;
        this.twelveInchPrice = twelveInchPrice;
    }
    public Cheese(String cheeseType) {
        this.cheeseType = cheeseType;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return premium;
    }

    public String getCheeseType() {
        return cheeseType;
    }
    public double getPrice(int size) {
        switch (size) {
            case 4:
                return fourInchPrice;
            case 8:
                return eightInchPrice;
            case 12:
                return twelveInchPrice;
            default:
                throw new IllegalArgumentException("Invalid size: " + size);
        }
    }

    public boolean isExtra() {
        return extra;
    }
}