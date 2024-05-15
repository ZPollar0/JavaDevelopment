
package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // Create and set each vehicle type.
        Moped moped = new Moped("Red", 5);
        Car car = new Car("Blue", 5, 50);
        SemiTruck semitruck = new SemiTruck("White", 1000, 200);
        HoverCraft hovercraft = new HoverCraft("Yellow", 20, 500, 1000);

        // Print out the information.
        System.out.println("Moped color: " + moped.getColor());
        System.out.println("Moped fuel capacity: " + moped.getFuelCapacity());

        System.out.println("\nCar color: " + car.getColor());
        System.out.println("Car number of passengers: " + car.getNumberOfPassengers());
        System.out.println("Car fuel capacity: " + car.getFuelCapacity());

        System.out.println("\nSemi-truck color: " + semitruck.getColor());
        System.out.println("Semi-truck cargo capacity: " + semitruck.getCargoCapacity());
        System.out.println("Semi-truck fuel capacity: " + semitruck.getFuelCapacity());

        System.out.println("\nHovercraft color: " + hovercraft.getColor());
        System.out.println("Hovercraft number of passengers: " + hovercraft.getNumberOfPassengers());
        System.out.println("Hovercraft cargo capacity: " + hovercraft.getCargoCapacity());
        System.out.println("Hovercraft fuel capacity: " + hovercraft.getFuelCapacity());
    }
}
