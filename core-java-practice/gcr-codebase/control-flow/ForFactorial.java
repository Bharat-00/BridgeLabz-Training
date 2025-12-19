import java.util.Scanner;
public class ForFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int num = sc.nextInt();
        if (num >= 1) {
            int factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }
            System.out.println("Factorial of " + num + " is " + factorial);
        } else {
            System.out.println("The number " + num + " is not a natural number");
        }
    }
}
