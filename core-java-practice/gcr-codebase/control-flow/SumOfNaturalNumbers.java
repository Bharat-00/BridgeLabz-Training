import java.util.Scanner;
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        if (num >= 1) {
            int originalNum = num;   
            int sumWhile = 0;
            // Using while loop
            while (num >= 1) {
                sumWhile += num;
                num--;
            }
            // Using formula
            int sumFormula = originalNum * (originalNum + 1) / 2;
            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using formula: " + sumFormula);
            if (sumWhile == sumFormula) {
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("Results differ between methods.");
            }
        } else {
            System.out.println("The number " + num + " is not a natural number.");
        }
    }
}
