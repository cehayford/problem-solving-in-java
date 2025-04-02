import java.util.Random;
import java.util.Scanner;

public class text_based_game {
    private static final int MAX_ATTEMPTS = 5;
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;
    private static final String WELCOME_MESSAGE = "Welcome to the Number Guessing Game!";
    private static final String INSTRUCTIONS = "Try to guess the number I'm thinking of between 1 and 100. You have 5 attempts!";
    private static final String CONGRATULATIONS = "Congratulations! You've guessed the number!";
    private static final String GAME_OVER = "Game Over! The number was: ";

    private final Random random;
    private final Scanner scanner;

    public text_based_game() {
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(INSTRUCTIONS);

        boolean truthyValues = true;
        while (truthyValues) {
            // function(); // Implemented the game logic here
            truthyValues = getYesNoInput("Would you like to play again? (y/n): ");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    // private void function() {
    //     int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    //     int attemptsLeft = MAX_ATTEMPTS;
    //     boolean hasGuessedCorrectly = false;

    //     while (attemptsLeft > 0 && !hasGuessedCorrectly) {
    //         System.out.print("Enter your guess: ");
    //         int userGuess = scanner.nextInt();

    //         if (userGuess < MIN_NUMBER || userGuess > MAX_NUMBER) {
    //             System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
    //             continue;
    //         }

    //         if (userGuess == numberToGuess) {
    //             hasGuessedCorrectly = true;
    //             System.out.println(CONGRATULATIONS);
    //         } else {
    //             attemptsLeft--;
    //             if (attemptsLeft > 0) {
    //                 System.out.println("Wrong guess! You have " + attemptsLeft + " attempts left.");
    //             } else {
    //                 System.out.println(GAME_OVER + numberToGuess);
    //             }
    //         }
    //     }
    // }

    private boolean getYesNoInput(String prompt) { // Fixed method to accept a prompt
        System.out.print(prompt);
        while (true) {
            String input = scanner.next().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'y' or 'n'.");
            }
        }
    }
}
