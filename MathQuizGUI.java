import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MathQuizGUI extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JLabel resultLabel;
    private int correctAnswer, score = 0, questionCount = 0;

    public MathQuizGUI() {
        setTitle("Math Quiz");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        questionLabel = new JLabel();
        add(questionLabel);

        answerField = new JTextField(10);
        add(answerField);

        submitButton = new JButton("Submit");
        add(submitButton);

        resultLabel = new JLabel();
        add(resultLabel);

        generateQuestion();

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        setVisible(true);
    }

    private void generateQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        char[] operators = {'+', '-', '*'};
        char operator = operators[random.nextInt(3)];

        correctAnswer = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> 0;
        };

        questionLabel.setText("What is " + num1 + " " + operator + " " + num2 + "?");
        answerField.setText("");
    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(answerField.getText());
            if (userAnswer == correctAnswer) {
                score++;
                resultLabel.setText("Correct! 🎉");
            } else {
                resultLabel.setText("Wrong! Answer: " + correctAnswer);
            }

            questionCount++;
            if (questionCount < 5) {
                generateQuestion();
            } else {
                JOptionPane.showMessageDialog(this, "Quiz Over! Your Score: " + score + "/5");
                System.exit(0);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new MathQuizGUI();
    }
}
