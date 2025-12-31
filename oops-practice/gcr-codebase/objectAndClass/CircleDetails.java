// Program to compute area and circumference of a circle
// Circle class definition
class Circle {
    // Instance variable
    private final double radius;
    // Constructor to initialize radius
    public Circle(double radius) {
        this.radius = radius;
    }
    // Method to calculate area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    // Method to calculate circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    // Method to display results
    public void displayDetails() {
        System.out.printf("Area of circle: %.4f%n", calculateArea());
        System.out.printf("Circumference of circle: %.4f%n", calculateCircumference());
    }
}
// Main class
public class CircleDetails {
    public static void main(String[] args) {
        // Creating Circle object with radius = 2.5
        Circle circle = new Circle(2.5);
        // Displaying area and circumference
        circle.displayDetails();
    }
}
