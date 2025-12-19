import java.util.Scanner;
public class KmTomiles1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ditance in km:");
        double km = sc.nextDouble();
        double miles=km*0.621371;
        System.out.println("Distance in miles is:"+miles);
    }
    
}
