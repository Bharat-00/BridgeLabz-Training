import java.util.Scanner;
public class NumberGuessingGame {
    // Generate a random guess within range
    static int generateGuess(int low, int high) {
        return low + (high - low) / 2;
    }
    // Get user feedback
    static char getFeedback(Scanner scanner) {
        System.out.print("Enter feedback (H = High, L = Low, C = Correct): ");
        return scanner.next().charAt(0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        char feedback;
        System.out.println("Think of a number between 1 and 100.");
        OUTER:
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Computer guesses: " + guess);
            feedback = getFeedback(scanner);
            switch (feedback) {
                case 'C', 'c' -> {
                    System.out.println("Computer guessed the correct number!");
                    break OUTER;
                }
                case 'H', 'h' -> high = guess - 1;
                case 'L', 'l' -> low = guess + 1;
                default -> {
                }
            }
        }
    }
}
