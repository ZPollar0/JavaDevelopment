package com.pluralsight;

public class PriceApp {

    public static void main(String args[]){
        int count = 11;
        float unitPrice = 7.12f; //this is an error without the f
        float taxRate = 0.825f;
        float totalCost;
        totalCost = (count * unitPrice) * (1 + taxRate);
        System.out.println(totalCost);
    }
}
