import java.util.Scanner;
public class GcdLcmCalculator {
    static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.println("GCD: " + calculateGCD(num1, num2));
        System.out.println("LCM: " + calculateLCM(num1, num2));
    }
}
