package com.pluralsight;

public class Room {
    private int numOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numOfBeds, double price, boolean occupied, boolean dirty) {
        this.numOfBeds = numOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public Room(int numOfBeds, boolean b, boolean occupied, String king) {
        this.numOfBeds = 0;
        this.price = 0;
        this.occupied = false;
        this.dirty = false;

    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isAvailable(){
        if (!dirty && !occupied){
            return true;
        }
        else return false;
    }
    public void checkIn(){
        occupied = false;
        cleanRoom();
    }
    public void cleanRoom(){
        dirty = false;
    }
}
