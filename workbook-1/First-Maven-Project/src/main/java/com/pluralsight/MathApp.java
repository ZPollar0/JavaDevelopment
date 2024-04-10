package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        //Create the variables
        int bobSalary = 180000;
        int garySalary = 181000;

        //Check who has a higher salary
        int highestSalary =Math.max(bobSalary, garySalary);

        //Create variables and set a price
        double carPrice = 2100.48;
        double truckPrice = 4600.92;

        //Set 7.25 as the radius
        double radius = 7.25;

        //calculate the area
        double area = Math.PI * radius * radius;

        //Print the answer
        System.out.println("The area of the circle is " + area);

        //Create new variable
        double value = 5.0;

        //find the square root of the variable
        double squareRoot = Math.sqrt(value);
        System.out.println("The square root is " + squareRoot);

        //Create new variables and set the x and y for coordinates.
        int x1 = 5, y1 = 10;
        int x2 = 85, y2 = 50;

        //Calculate the difference between the two
        int PX = x2 - x1;
        int PY = y2 - y1;

        //Square the values
        int Xsqr = PX * PX;
        int Ysqr = PY * PY;

        //Add the values of the squared values
        int sumOfSqr = Xsqr +Ysqr;

        //Calculate the distance.
        double distance = Math.sqrt(sumOfSqr);
        System.out.println("The distance from the two are " + distance);

    }
}
