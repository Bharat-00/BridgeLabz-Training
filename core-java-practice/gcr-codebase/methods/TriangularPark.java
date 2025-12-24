import java.util.Scanner;
public class TriangularPark {
    // Method to calculate number of rounds
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter; // 5 km = 5000 meters
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking sides of triangle
        System.out.print("Enter side 1 (in meters): ");
        double a = sc.nextDouble();
        System.out.print("Enter side 2 (in meters): ");
        double b = sc.nextDouble();
        System.out.print("Enter side 3 (in meters): ");
        double c = sc.nextDouble();
        // Displaying result
        System.out.println("Number of rounds needed to complete 5 km: " +
                calculateRounds(a, b, c));
    }
}
