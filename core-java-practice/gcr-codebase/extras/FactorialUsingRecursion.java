import java.util.Scanner;
public class FactorialUsingRecursion {
    static long calculateFactorial(int number) {
        if (number == 0)
            return 1;
        return number * calculateFactorial(number - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        long factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
