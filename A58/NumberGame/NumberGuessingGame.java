import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        boolean guessedCorrectly = false;
        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                guessedCorrectly = true;
            }
        }

        scanner.close();
    }
}
