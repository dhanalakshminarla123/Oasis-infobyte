
import java.util.Scanner;
class Numberguess {
    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int)(100 * Math.random());
        int guess;
        int attempts = 0;

        System.out.println("Choose a Number between 1 to 100.");
        while (true) {
            System.out.println("Guess the number:");
            guess = sc.nextInt();
            attempts++;

            if (number == guess) {
                System.out.println("Hurray! It's correct...!!!");
                break;
            } else if (number > guess) {
                System.out.println("The number is greater than " + guess);
            } else if (number < guess) {
                System.out.println("The number is less than " + guess);
            }
        }
        System.out.println("It took you " + attempts + " attempts.");
    }
    public static void main(String[] args) {
        guessingNumberGame();
    }
}
