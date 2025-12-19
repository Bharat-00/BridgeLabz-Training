import java.util.Scanner;
public class WhilePowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer and its power:");
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;
        int counter = 0;
        while (counter < power) {
            result = result * number;
            counter++;
        }
        System.out.println(number + " raised to the power " + power + " is " + result);
    }
    
}
