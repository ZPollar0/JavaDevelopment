package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    // Create variables, as private.
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private List<Side> sides;

    // Create the constructor.
    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    // Create setters.
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public List<Side> getSides() {
        return sides;
    }

    // Create clearOrder method.
    public void clearOrder() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
        sides.clear();
    }
}