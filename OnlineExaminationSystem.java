
import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class OnlineExaminationSystem {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Question> questions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeQuestions();
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void register() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }

    static void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful!");
                takeQuiz();
                return;
            }
        }
        System.out.println("Invalid username or password!");
    }

    static void takeQuiz() {
        int score = 0;
        for (Question question : questions) {
            System.out.println(question.question);
            for (int i = 0; i < question.options.length; i++) {
                System.out.println((i + 1) + ". " + question.options[i]);
            }
            System.out.print("Enter your answer: ");
            int answer = sc.nextInt();
            if (answer == question.correctAnswer) {
                score++;
            }
        }
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    static void initializeQuestions() {
        questions.add(new Question("Who created Bitcoin?", new String[]{"Marie Curie", "Nikola Tesla", "Satoshi Nakamoto", "Faraday"}, 3));
        questions.add(new Question("What is the current inflation rate in india?", new String[]{"3.5", "5.4", "4.5", "6.5"}, 2));
        questions.add(new Question("What is the largest state in India by area?", new String[]{"Rajasthan", "Bihar", "Goa", "Gujarat"}, 1));
    }
}
