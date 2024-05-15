
package com.pluralsight;
import java.util.ArrayList;

public class AssetManager {
    public static void main(String[] args) {
        // Initalize the array.
        ArrayList<Asset> assets = new ArrayList<>();

        // Add assets to the array.
        assets.add(new House("Home", "2018-05-02", 355078, "347 Sally May Rd", 1, 16000, 6000));
        assets.add(new House("Beach Home", "2023-11-20", 244091, "111 Palm Beach Cir", 2, 9000, 2000));
        assets.add(new Vehicle("Car", "2020-01-05", 75000, "Mercedes Benz 2019", 2019, 14000));
        assets.add(new Vehicle("Wife's Car", "2024-01-09", 25000, "Kia K5 EX", 2024, 34000));

        // Print the assets.
        for (Asset asset : assets) {
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
