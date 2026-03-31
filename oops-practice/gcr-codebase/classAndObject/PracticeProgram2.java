public class PracticeProgram2 {
    private double radius;
    // Default Constructor using Chaining
    public PracticeProgram2() {
        // Calls the parameterized constructor with a default value of 1.0
        this(1.0); 
        System.out.println("-> Default constructor called (chained).");
    }
    // Parameterized Constructor
    public PracticeProgram2(double radius) {
        this.radius = radius;
    }
    public void displayArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Radius: " + radius + " | Area: " + String.format("%.2f", area));
    }
    // Main method to test the code
    public static void main(String[] args) {
        System.out.println("--- Problem 2: Circle Class ---");
        PracticeProgram2 c1 = new PracticeProgram2(); // Uses chaining
        c1.displayArea();
        PracticeProgram2 c2 = new PracticeProgram2(5.0); // Custom radius
        c2.displayArea();
    }
}