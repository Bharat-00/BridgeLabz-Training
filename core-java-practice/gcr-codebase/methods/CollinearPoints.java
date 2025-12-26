import java.util.Scanner;
public class CollinearPoints {
    // Method to check collinearity using slope formula
    public static boolean isCollinearUsingSlope(int x1, int y1,
                                                 int x2, int y2,
                                                 int x3, int y3) {
        // Calculate slopes AB, BC, and AC
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        double slopeAC = (double)(y3 - y1) / (x3 - x1);
        // Check if all slopes are equal
        return slopeAB == slopeBC && slopeBC == slopeAC;
    }
    // Method to check collinearity using area of triangle formula
    public static boolean isCollinearUsingArea(int x1, int y1,
                                                int x2, int y2,
                                                int x3, int y3) {
        // Calculate area using formula
        double area = 0.5 * (x1 * (y2 - y3)
                           + x2 * (y3 - y1)
                           + x3 * (y1 - y2));
        // Points are collinear if area is 0
        return area == 0;
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input for first point
        System.out.print("Enter x1 and y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        // Input for second point
        System.out.print("Enter x2 and y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        // Input for third point
        System.out.print("Enter x3 and y3: ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        // Check using slope method
        boolean slopeResult = isCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
        // Check using area method
        boolean areaResult = isCollinearUsingArea(x1, y1, x2, y2, x3, y3);
        // Display results
        System.out.println("\nUsing Slope Formula:");
        if (slopeResult)
            System.out.println("The given points are collinear.");
        else
            System.out.println("The given points are NOT collinear.");
        System.out.println("\nUsing Area of Triangle Formula:");
        if (areaResult)
            System.out.println("The given points are collinear.");
        else
            System.out.println("The given points are NOT collinear.");
    }
}
