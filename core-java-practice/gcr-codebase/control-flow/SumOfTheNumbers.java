import java.util.Scanner;
public class SumOfTheNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        double number = sc.nextDouble();
        double total=0.0;
        while(number>=0) {
            total += number;
            System.out.print("Enter a positive integer (or a zero to stop): ");
            number = sc.nextDouble();
        }
        System.out.println("The sum of the entered numbers is: " + total);
    }
    
}
