import java.util.Scanner;
public class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of feet:");
        double feet = sc.nextDouble();
        double yards = feet / 3;
        double miles = feet / 5280;
        System.out.println("The number of yards is " + yards + " and the number of miles is " + miles);
    }
}