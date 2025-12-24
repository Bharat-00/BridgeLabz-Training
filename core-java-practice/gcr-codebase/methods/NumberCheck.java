import java.util.Scanner;
public class NumberCheck {
    // Method to check number type
    public static int checkNumber(int n) {
        if (n > 0)
            return 1;     // Positive
        else if (n < 0)
            return -1;    // Negative
        else
            return 0;     // Zero
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        // Displaying result
        System.out.println("Result: " + checkNumber(number));
    }
}
