import java.util.Scanner;
public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amar's age and height:");
        int amarAge = sc.nextInt();
        double amarHeight = sc.nextDouble();
        System.out.println("Enter Akbar's age and height:");
        int akbarAge = sc.nextInt();
        double akbarHeight = sc.nextDouble();
        System.out.println("Enter Anthony's age and height:");
        int anthonyAge = sc.nextInt();
        double anthonyHeight = sc.nextDouble();
        // Finding youngest
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            System.out.println("Youngest friend is Amar");
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            System.out.println("Youngest friend is Akbar");
        } else {
            System.out.println("Youngest friend is Anthony");
        }
        // Finding tallest
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            System.out.println("Tallest friend is Amar");
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            System.out.println("Tallest friend is Akbar");
        } else {
            System.out.println("Tallest friend is Anthony");
        }
    }
}
