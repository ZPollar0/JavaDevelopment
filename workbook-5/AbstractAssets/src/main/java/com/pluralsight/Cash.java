
package com.pluralsight;

public class Cash extends Assets {
    // Create the constructor.
    public Cash(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    // Create the override getValue() method.
    @Override
    public double getValue() {
        return getOriginalCost();
    }
}
