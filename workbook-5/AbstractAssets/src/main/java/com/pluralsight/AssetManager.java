
package com.pluralsight;
import java.util.ArrayList;

public class AssetManager {
    public static void main(String[] args) {
        // Initalize the array.
        ArrayList<Assets> assets = new ArrayList<>();

        // Add assets to the array.
        assets.add(new House("House", "2024-01-01", 300000, "123 Main Street", 1, 2000, 5000));
        assets.add(new House("Another House", "2024-02-02", 500000, "123 Another Main Street", 2, 1500, 10000));
        assets.add(new Vehicle("Car", "2024-03-03", 35000, "Mistubishi Lancer Evolution Final Edition", 2015, 80000));
        assets.add(new Vehicle("Another Car", "2024-04-04", 25000, "BMW M3 GTR", 2015, 60000));

        // Print the assets.
        for (Assets asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            System.out.println("Value: $" + asset.getValue());

            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
            }

            System.out.println();
        }
    }
}
