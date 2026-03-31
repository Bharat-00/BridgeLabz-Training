// CircleArea.java
class Circle {
    // Attribute
    double radius;
    // Constructor to initialize radius
    Circle(double radius) {
        this.radius = radius;
    }
    // Method to calculate area
    double calculateArea() {
        return 3.14 * radius * radius;
    }
    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * 3.14 * radius;
    }
    // Method to display area and circumference
    void display() {
        System.out.printf("Area of circle: %.4f\n", calculateArea());
        System.out.printf("Circumference of circle: %.4f\n", calculateCircumference());
    }
}
public class CircleArea {
    public static void main(String[] args) {
        // Creating Circle object with radius 2.5
        Circle c = new Circle(2.5);
        // Display area and circumference
        c.display();
    }
}
