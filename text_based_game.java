import java.util.Random;
import java.util.Scanner;

public class text_based_game {
    private static final int MAX_ATTEMPTS = 8;
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;
    private static final String WELCOME_MESSAGE = "Welcome to the Number Guessing Game!";
    private static final String INSTRUCTIONS = "Try to guess the number I'm thinking of between 1 and 100. You have 8 attempts!";
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
            gameEngine();
            truthyValues = getYesNoInput("Would you like to play again? (y/n): ");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private void gameEngine(){
        int numberToBeGuessed = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attemptsLeft = MAX_ATTEMPTS;
        boolean numberGuessedCorrectly = false;
        // it checks if the user has guessed the number correctly. if not it will give the user 5 attempts to guess the number.
        while(attemptsLeft > 0 && !numberGuessedCorrectly) {
            System.out.print("Enter your guess number: ");
            int userGuessedNumber = scanner.nextInt();

            // it checks if the user has entered a number between 1 and 100. if not it will ask the user to enter a number between 1 and 100.
            if (userGuessedNumber < MIN_NUMBER || userGuessedNumber > MAX_NUMBER) {
                System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                continue;
            }

            if(attemptsLeft <=3){
                if(userGuessedNumber < numberToBeGuessed) {
                    char[] numberSlice = String.valueOf(numberToBeGuessed).toCharArray();
                    System.out.println(numberSlice[0] + "*");
                    System.out.println("Your guess is too low!");
                } else if (userGuessedNumber > numberToBeGuessed) {
                    System.out.println("Your guess is too high!");
                }
            }
          
            if (userGuessedNumber == numberToBeGuessed) {
                numberGuessedCorrectly = true;
                System.out.println(CONGRATULATIONS);
            } else {
                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Wrong guess! You have " + attemptsLeft + " attempts left.");
                } else {
                    System.out.println(GAME_OVER + numberToBeGuessed);
                }
            }
        }
    }

    
    private boolean getYesNoInput(String prompt) {
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
    
    public static void main(String[] args) {
        text_based_game game = new text_based_game();
        game.startGame();
    }
}
