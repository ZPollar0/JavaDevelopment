
package com.pluralsight;

class Vehicle extends Assets {
    // Create the variables, as private.
    private String makeModel;
    private int year;
    private int odometer;

    // Create the contructor.
    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // Create the getters and setters.
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    @Override
    public double getValue() {
        int currentYear = 2024; // Assuming current year is 2024
        double value;
        int age = currentYear - year;
        if (age <= 3) {
            value = getOriginalCost() * Math.pow(0.97, age);
        } else if (age <= 6) {
            value = getOriginalCost() * Math.pow(0.94, age);
        } else if (age <= 10) {
            value = getOriginalCost() * Math.pow(0.92, age);
        } else {
            value = 1000.00;
        }
        if (odometer > 100000 && !makeModel.toLowerCase().contains("honda") && !makeModel.toLowerCase().contains("toyota")) {
            value *= 0.75;
        }
        return value;
    }
}
