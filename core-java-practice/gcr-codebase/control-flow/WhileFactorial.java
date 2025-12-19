import java.util.Scanner;
public class WhileFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer to calculate its factorial:");
        int num = sc.nextInt();
        if (num > 0) {
            int factorial = 1;
            int i = 1;
            while (i <= num) {
                factorial = factorial * i;
                i++;
            }
            System.out.println("Factorial of " + num + " is " + factorial);
        } else {
            System.out.println("please enter a valid positive integer");
        }
    }
}
