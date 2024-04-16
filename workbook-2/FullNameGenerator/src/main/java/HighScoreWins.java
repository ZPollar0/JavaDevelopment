package workbook_2;
import java.util.Scanner;

public class HighScoreWins {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static String gameScore;
    static String winner;

    public static void main(String[] args) {
        // Call the enterGameScore method.
        enterGameScore();

        // Call the parseGameScore method.
        parseGameScore();

        // Call the printWinner method.
        printWinner();
    }

    // Ask the user to enter the game score.
    public static void enterGameScore() {
        System.out.print("Please enter a game score (TeamA:TeamB|AScore:BScore): ");
        gameScore = scanner.nextLine();
    }

    // Parse the game score.
    public static void parseGameScore() {
        // Split the gameScore into two parts, teamPart and scorePart.
        String[] gameParts = gameScore.split("\\|");
        String teamPart = gameParts[0];
        String scorePart = gameParts[1];

        // Seperate the teamPart into homeName and visitorName.
        String[] teamName = teamPart.split(":");
        String homeName = teamName[0];
        String visitorName = teamName[1];

        // Seperate the scorePart into homeScore and visitorScore.
        String[] teamScore = scorePart.split(":");
        int homeScore = Integer.parseInt(teamScore[0]);
        int visitorScore = Integer.parseInt(teamScore[1]);

        // Compare the scores and figure out the winner.
        winner = (homeScore > visitorScore) ? homeName : visitorName;
    }

    // Print the winner.
    public static void printWinner() {
        System.out.println("Winner: " + winner);
    }
}