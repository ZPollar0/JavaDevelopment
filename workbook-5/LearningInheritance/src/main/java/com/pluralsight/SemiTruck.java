package com.pluralsight;

public class SemiTruck extends Vehicle {
    public SemiTruck(String color, int cargoCapacity, int fuelCapacity) {
        super(color, 2, cargoCapacity, fuelCapacity); // Assuming SemiTruck has 2 passengers capacity
    }
}