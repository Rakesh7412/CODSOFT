package Number_Game_Project;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	 public static void main(String[] args) {
	        playNumberGuessingGame();
	    }

	    private static void playNumberGuessingGame() {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        int minRange = 1;
	        int maxRange = 100;
	        int numberOfAttempts = 10;
	        int userScore = 100;

	        System.out.println("Welcome to the Number Guessing Game!Task No 1 Codsoft Java internship Challenge:");

	        do {
	            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
	            int attemptsLeft = numberOfAttempts;

	            System.out.println("Guess the number between " + minRange + " and " + maxRange);

	            while (attemptsLeft > 0) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();

	                if (userGuess == generatedNumber) {
//	                	userScore += attemptsLeft;
	                	System.out.println("Congratulations! You guessed the correct number!");
	              
	                    System.out.println("Your Score is:"+userScore);
	                    
	                    break;
	                } else if (userGuess < generatedNumber) {
	                    System.out.println("Too low! Attempts left: " + --attemptsLeft);
	                    userScore-=10;
	                    	
	                } else {
	                    System.out.println("Too high! Attempts left: " + --attemptsLeft);
	                    userScore-=10;
	                }
	            }

	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgain = scanner.next();

	            if ("no".equalsIgnoreCase(playAgain)) {
	            	System.out.println("Thanks for playing Your total score is: " + userScore);
	                break;
	            }

	        } while (true);

	        System.out.println("Game over. Your total score is: " + userScore);
	        scanner.close();
	    }
}

