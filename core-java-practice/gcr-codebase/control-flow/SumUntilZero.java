import java.util.Scanner;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            double number = sc.nextDouble();
            if (number == 0) {
                break;
            }
            total += number;
        }
        System.out.println("The sum of the entered numbers is: " + total);
    }
    
}
