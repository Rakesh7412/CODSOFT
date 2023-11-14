package QuizApp;

import java.util.Scanner;

public class QuizApplication {
    private static final int QUESTION_COUNT = 3; // Number of questions
    private static final int TIME_PER_QUESTION_SECONDS = 10; // Time per question in seconds
    private static final String[] QUESTIONS = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "Who painted the Mona Lisa?"
    };
    private static final String[][] OPTIONS = {
        {"Paris", "Rome", "Berlin", "London"},
        {"Mars", "Jupiter", "Saturn", "Neptune"},
        {"Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"}
    };
    private static final int[] CORRECT_ANSWERS = {0, 0, 0}; // Index of correct answers

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < QUESTION_COUNT; i++) {
            System.out.println("Question " + (i + 1) + ": " + QUESTIONS[i]);
            for (int j = 0; j < OPTIONS[i].length; j++) {
                System.out.println((j + 1) + ". " + OPTIONS[i][j]);
            }

            System.out.print("Your answer (1-" + OPTIONS[i].length + "): ");
            int selectedOption = 0;
            long startTime = System.currentTimeMillis();

            // Input validation for answer selection
            while (true) {
                try {
                    selectedOption = Integer.parseInt(scanner.nextLine());
                    if (selectedOption >= 1 && selectedOption <= OPTIONS[i].length) {
                        break;
                    } else {
                        System.out.print("Please enter a valid option: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Enter a number: ");
                }
            }

            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000; // Time taken in seconds

            if (timeTaken > TIME_PER_QUESTION_SECONDS) {
                System.out.println("Time's up!");
            } else {
                int selectedAnswerIndex = selectedOption - 1;
                if (selectedAnswerIndex == CORRECT_ANSWERS[i]) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            }

            System.out.println(); // Empty line for readability
        }

        System.out.println("Quiz ended!");
        System.out.println("Your score: " + score + "/" + QUESTION_COUNT);

        scanner.close();
    }
}


