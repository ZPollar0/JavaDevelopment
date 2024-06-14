package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

class Sandwich {
    // Create variables, as private.
    private List<Meat> meats;
    private List<Cheese> cheeses;
    private List<Toppings> toppings;
    private List<Sauce> sauces;
    private List<Side> sides;
    private boolean toasted;
    private String breadType;
    private int size;
    private double extraMeatCost;
    private double extraCheeseCost;

    // Create the constructors.
    public Sandwich(String breadType, int size) {
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.toasted = false;
        this.breadType = breadType;
        this.size = size;
    }

    // Create setters and getters.
    public void addMeat(Meat meat) {
        meats.add(meat);
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public int getSize() {
        return size;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public boolean hasExtraMeat() {
        for (Meat meat : meats) {
            if (meat.isExtra()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasExtraCheese() {
        for (Cheese cheese : cheeses) {
            if (cheese.isExtra()) {
                return true;
            }
        }
        return false;
    }

    public double getExtraMeatCost() {
        return extraMeatCost;
    }

    public double getExtraCheeseCost() {
        return extraCheeseCost;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("\nBread: ").append(breadType).append("\nSize: ").append(size).append(" inches");

        // Add meat details.
        description.append("\nMeats: ");
        for (Meat meat : meats) {
            description.append(meat.getName()).append("");
        }

        // Add extra meat.
        if (hasExtraMeat()) {
            description.append("\nExtra Meat, ");
        }

        // Add cheese details.
        description.append("\nCheeses: ");
        for (Cheese cheese : cheeses) {
            description.append(cheese.getName()).append("");
        }

        // Add extra cheese.
        if (hasExtraCheese()) {
            description.append("\nExtra Cheese, ");
        }

        // Add topping details.
        description.append("\nToppings: ");
        for (Toppings topping : toppings) {
            description.append(topping.getName()).append(", ");
        }

        // Add sauce details.
        description.append("\nSauces: ");
        for (Sauce sauce : sauces) {
            description.append(sauce.getName()).append("");
        }

        return description.toString();
    }

    public double getPrice() {
        double totalPrice = 0.0;

        // Add the prices of meats.
        for (Meat meat : meats) {
            totalPrice += meat.getPrice(size);
        }

        // Add the prices of cheeses.
        for (Cheese cheese : cheeses) {
            totalPrice += cheese.getPrice(size);
        }

        // Add extra meat cost.
        if (hasExtraMeat()) {
            totalPrice += extraMeatCost;
        }

        // Add extra cheese cost.
        if (hasExtraCheese()) {
            totalPrice += extraCheeseCost;
        }

        return totalPrice;
    }

    // Create removeTopping method.
    public void removeTopping(String toppingName) {
        for (int i = 0; i < toppings.size(); i++) {
            Toppings topping = toppings.get(i);
            if (topping.getName().equalsIgnoreCase(toppingName)) {
                toppings.remove(i);
                return;
            }
        }
    }
}