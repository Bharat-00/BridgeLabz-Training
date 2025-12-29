import java.util.Scanner;
public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of visitors: ");
        int visitors = scanner.nextInt();
        System.out.println("🎉 Diwali Mela Lucky Draw Started");
        for (int i = 1; i <= visitors; i++) {
            System.out.print("Visitor " + i + ", draw a number: ");
            int number = scanner.nextInt();
            // Invalid input check
            if (number <= 0) {
                System.out.println("Invalid number! Skipping this visitor.");
                continue; // skip to next visitor
            }
            // Check divisibility by both 3 and 5
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("🎁 Congratulations! You won a gift.");
            } else {
                System.out.println("Sorry, better luck next time.");
            }
        }
        System.out.println("🎉 Lucky Draw Ended");
    }
}
