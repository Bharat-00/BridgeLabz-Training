import java.util.Scanner;
public class MetroSmartCardFareDeduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial smart card balance: ₹");
        int balance = scanner.nextInt();
        System.out.println("🚇 Delhi Metro Smart Card System Started");
        while (balance > 0) {
            System.out.print("\nEnter travel distance in km (0 to exit): ");
            int distance = scanner.nextInt();
            // Exit condition
            if (distance == 0) {
                System.out.println("User exited the metro system.");
                break;
            }
            // Calculate fare using ternary operator
            int fare = (distance <= 5) ? 20 : 40;
            // Check balance
            if (balance < fare) {
                System.out.println("Insufficient balance! Journey not allowed.");
                break;
            }
            // Deduct fare
            balance -= fare;
            System.out.println("Fare deducted: ₹" + fare);
            System.out.println("Remaining balance: ₹" + balance);
        }
        System.out.println("\n🚇 Metro Smart Card Session Ended");
    }
}
