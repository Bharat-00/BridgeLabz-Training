import java.util.Scanner;
public class SumNaturalNumbers {
    // Method to calculate sum using loop
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        // Displaying result
        System.out.println("Sum of first " + n + " natural numbers is: " +
                findSum(n));
    }
}
