import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = random.nextInt(MAX_NUMBER) + 1;

        System.out.println("Welcome to the Random Number Guessing Game!");
        System.out.println("You have three choices!");
        System.out.println("1) Repeat until you guess correctly! (Enter 1)");
        System.out.println("2) Limit the number of attempts you have to guess the number! (Enter 2)");
        System.out.println("3) Add the option for multiple rounds! (Enter 3)");
        System.out.println("I have selected a number between 1 and " + MAX_NUMBER + ". Try to guess it!");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                playUntilCorrect(numberToGuess, scanner);
                break;
            case 2:
                playWithLimitedAttempts(numberToGuess, scanner);
                break;
            case 3:
                playMultipleRounds(numberToGuess, scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting the game.");
                break;
        }

        scanner.close();
    }

    private static void playUntilCorrect(int numberToGuess, Scanner scanner) {
        boolean guessedCorrectly = false;
        while (!guessedCorrectly) {
            int userGuess = getUserGuess(scanner);
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                guessedCorrectly = true;
            }
        }
    }

    private static void playWithLimitedAttempts(int numberToGuess, Scanner scanner) {
        System.out.println("How many attempts will you give?");
        int attempts = scanner.nextInt();
        int score = 0;
        for (int i = 0; i < attempts; i++) {
            int userGuess = getUserGuess(scanner);
            if (userGuess == numberToGuess) {
                score++;
            }
        }
        System.out.println("Your score: " + score);
    }

    private static void playMultipleRounds(int numberToGuess, Scanner scanner) {
        boolean isPlayGame = true;
        int score = 0;
        while (isPlayGame) {
            int userGuess = getUserGuess(scanner);
            if (userGuess == numberToGuess) {
                score++;
            }
            System.out.println("Do you want to play again? If yes, enter 1 otherwise enter 0");
            isPlayGame = scanner.nextInt() == 1;
        }
        System.out.println("Your score is: " + score);
    }

    private static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }
}