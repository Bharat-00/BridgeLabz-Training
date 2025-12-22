import java.util.Scanner;
public class ReverseNumberUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();
        int temp = number;
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        int[] digits = new int[count];
        int index = 0;
        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }
        int[] reverse = new int[count];
        for (int i = 0; i < count; i++) {
            reverse[i] = digits[i];
        }
        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i]);
        }
    }
}
