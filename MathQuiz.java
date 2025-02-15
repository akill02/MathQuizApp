import java.util.Random;
import java.util.Scanner;

public class MathQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalQuestions = 5;
        int correctAnswers = 0;

        System.out.println("Welcome to the Math Quiz!");
        
        for (int i = 1; i <= totalQuestions; i++) {
            int num1 = random.nextInt(10) + 1; // Generate numbers between 1 and 10
            int num2 = random.nextInt(10) + 1;
            char[] operators = {'+', '-', '*'};
            char operator = operators[random.nextInt(3)];

            int correctAnswer = calculate(num1, num2, operator);

            System.out.printf("Question %d: %d %c %d = ?\n", i, num1, operator, num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct! 🎉");
                correctAnswers++;
            } else {
                System.out.println("Wrong! The correct answer is " + correctAnswer);
            }
        }

        System.out.println("\nQuiz Over! Your Score: " + correctAnswers + "/" + totalQuestions);
        scanner.close();
    }

    private static int calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> 0;
        };
    }
}
