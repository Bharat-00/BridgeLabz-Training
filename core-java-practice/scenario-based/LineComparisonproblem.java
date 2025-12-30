import java.util.*;
public class LineComparisonproblem {
    // UC1 Function to calculate length of lines.
    static double lengthOfline1(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
    static double lengthOfline2(double a1, double b1, double a2, double b2) {
        return Math.sqrt(Math.pow((a2 - a1), 2) + Math.pow((b2 - b1), 2));
    }
    // UC2 equality of two lines.
    static boolean areLinesEqual(Double line1Length, Double line2Length) {
        return line1Length.equals(line2Length);
    }
    // UC3 Comparing two lines.
    static boolean compareLines(double line1Length, double line2Length) {
        return Double.compare(line1Length, line2Length) == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation");
        System.out.println("Enter coordinates of line 1 (x1, y1, x2, y2): ");
        double x1 = sc.nextDouble();    
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double line1Length = lengthOfline1(x1, y1, x2, y2);
        System.out.println("Length of Line 1: " + line1Length);
        System.out.println("Enter coordinates of line 2 (a1, b1, a2, b2): ");
        double a1 = sc.nextDouble();        
        double b1 = sc.nextDouble();
        double a2 = sc.nextDouble();
        double b2 = sc.nextDouble();
        double line2Length = lengthOfline2(a1, b1, a2, b2);
        System.out.println("Length of Line 2: " + line2Length);
        // Check equality of two lines
        if (areLinesEqual(line1Length, line2Length)) {
            System.out.println("The two lines are equal in length.");
        } else {
            System.out.println("The two lines are not equal in length.");
        }
        // Compare two lines
        if (compareLines(line1Length, line2Length)) {
            System.out.println("Both lines are equal.");
        } else if (line1Length > line2Length) {
            System.out.println("Line 1 is longer than Line 2.");
        } else {
            System.out.println("Line 2 is longer than Line 1.");

        

    }
}
