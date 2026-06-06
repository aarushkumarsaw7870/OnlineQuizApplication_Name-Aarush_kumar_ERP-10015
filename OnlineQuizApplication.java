import java.util.Scanner;

class Question {
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctAnswer;

    public Question(String question, String optionA, String optionB,
                    String optionC, String optionD, String correctAnswer) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        System.out.println("a) " + optionA);
        System.out.println("b) " + optionB);
        System.out.println("c) " + optionC);
        System.out.println("d) " + optionD);
    }
}

class QuizManager {
    Question[] questions;
    int score = 0;

    public QuizManager() {
        questions = new Question[] {
            new Question(
                "Q1. What is Java?",
                "Programming Language",
                "Operating System",
                "Database",
                "Browser",
                "a"
            ),
            new Question(
                "Q2. What does OOP stand for?",
                "Object Oriented Programming",
                "Online Object Program",
                "Open Operating Platform",
                "Object Option Program",
                "a"
            ),
            new Question(
                "Q3. Which keyword is used to create an object in Java?",
                "class",
                "new",
                "void",
                "static",
                "b"
            ),
            new Question(
                "Q4. Which class is used to take input from user?",
                "System",
                "String",
                "Scanner",
                "Input",
                "c"
            ),
            new Question(
                "Q5. Which method is used to compare strings?",
                "compare()",
                "equals()",
                "check()",
                "match()",
                "b"
            )
        };
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== ONLINE QUIZ APPLICATION =====");

        for (Question q : questions) {
            q.displayQuestion();

            System.out.print("Enter your answer (a/b/c/d): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase(q.correctAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is "
                        + q.correctAnswer + "\n");
            }
        }

        System.out.println("===== QUIZ COMPLETED =====");
        System.out.println("Final Score: " + score + "/" + questions.length);

        double percentage = (score * 100.0) / questions.length;
        System.out.println("Percentage: " + percentage + "%");

        sc.close();
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        QuizManager quiz = new QuizManager();
        quiz.startQuiz();
    }
}