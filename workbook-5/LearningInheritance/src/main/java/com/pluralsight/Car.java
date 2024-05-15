
package com.pluralsight;

public class Car extends Vehicle {
    public Car(String color, int numberOfPassengers, int fuelCapacity) {
        super(color, numberOfPassengers, 0, fuelCapacity); // Assuming Car has no cargo
    }
}
