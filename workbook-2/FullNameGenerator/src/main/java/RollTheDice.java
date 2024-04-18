package workbook_2;
import java.util.Random;

// Create Dice class.
class Dice {
    public int roll() {
        // Generate a number between 1 and 6.
        return (int) (Math.random() * 6) + 1;
    }
}

public class RollTheDice {
    // Initalize dice.
    static Dice dice = new Dice();

    // Create the variables.
     int roll1;
     int roll2;
     int totalTwo = 0;
     int totalFour = 0;
     int totalSix = 0;
     int totalSeven = 0;

    public static void main(String[] args) {
        // Calls the diceRolls method.
        diceRolls();

        // Calls the printRolls method.
        printRolls();
    }

    // Create the diceRolls method.
    public static void diceRolls() {
        // Roll the dice 20 times.
        for (int i = 0; i < 20; i++) {
            // Rolls the dices.
            roll1 = dice.roll();
            roll2 = dice.roll();

            // Print each roll and the total of each roll.
            System.out.println("Roll " + (i + 1) + ": " + roll1 + " - " + roll2 + " Sum: " + (roll1 + roll2));

            // Calculates the dice total and keeps count of 2, 4, 6, and 7.
            int diceTotal = roll1 + roll2;
            switch (diceTotal) {
                case 2:
                    totalTwo++;
                    break;
                case 4:
                    totalFour++;
                    break;
                case 6:
                    totalSix++;
                    break;
                case 7:
                    totalSeven++;
                    break;
                default:
                    break;
            }
        }
    }

    // Create the printRolls method.
    public static void printRolls() {
        // Print the outcome of the rolls.
        System.out.println("Number of times 2 is rolled: " + totalTwo);
        System.out.println("Number of times 4 is rolled: " + totalFour);
        System.out.println("Number of times 6 is rolled: " + totalSix);
        System.out.println("Number of times 7 is rolled: " + totalSeven);
    }
}