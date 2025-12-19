import java.util.Scanner;
public class WhileFactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer to find its factors:");
        int number = sc.nextInt();
        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            int i = 1;
            while (i < number) {
                if (number % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        } else {
            System.out.println("Please enter a positive integer");
        }
    }
    
}
