import java.util.Scanner;
public class Trigonometry {
    // Method to calculate sin, cos and tan
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[]{
                Math.sin(radians),
                Math.cos(radians),
                Math.tan(radians)
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        // Calling method
        double[] result = calculateTrigonometricFunctions(angle);
        // Displaying result
        System.out.println("Sin value: " + result[0]);
        System.out.println("Cos value: " + result[1]);
        System.out.println("Tan value: " + result[2]);
    }
}
