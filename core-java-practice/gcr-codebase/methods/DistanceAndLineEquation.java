import java.util.Scanner;
public class DistanceAndLineEquation {
    /*
     * Method to calculate Euclidean distance between two points
     * Formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
     */
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = Math.pow(x2 - x1, 2);
        double dy = Math.pow(y2 - y1, 2);
        return Math.sqrt(dx + dy);
    }
    /*
     * Method to find slope and y-intercept of a line
     * Equation: y = m*x + b
     * Returns array where:
     * index 0 → slope (m)
     * index 1 → y-intercept (b)
     */
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];
        // Calculate slope
        double m = (y2 - y1) / (x2 - x1);
        // Calculate y-intercept
        double b = y1 - (m * x1);
        result[0] = m;
        result[1] = b;
        return result;
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input for first point
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        // Taking input for second point
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();
        // Calculate distance
        double distance = calculateDistance(x1, y1, x2, y2);
        // Calculate slope and y-intercept
        double[] line = findLineEquation(x1, y1, x2, y2);
        // Display results
        System.out.println("\n--- RESULTS ---");
        System.out.println("Euclidean Distance between the two points = " + distance);
        System.out.println("Slope (m) of the line = " + line[0]);
        System.out.println("Y-Intercept (b) of the line = " + line[1]);
        System.out.println("Equation of the line: y = " + line[0] + "x + " + line[1]);
    }
}
