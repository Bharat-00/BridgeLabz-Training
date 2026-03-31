// Main Class
public class universityStudentManagement {
    public int rollNumber;    // Accessible everywhere
    protected String name;    // Accessible in package & subclasses
    private double CGPA;      // Accessible ONLY inside Student class
    public universityStudentManagement(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    // Public method to access private CGPA
    public double getCGPA() {
        return CGPA;
    }
    // Public method to modify private CGPA
    public void setCGPA(double newCGPA) {
        this.CGPA = newCGPA;
    }
    public static void main(String[] args) {
        System.out.println("--- Access Modifier Problem 1: University ---");
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Sarah", 3.8);
        pgStudent.displayInfo();       
        // Modifying private variable via public method
        pgStudent.setCGPA(3.9);
        System.out.println("Updated CGPA via setter: " + pgStudent.getCGPA());
    }
}
// Subclass
class PostgraduateStudent extends universityStudentManagement {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    public void displayInfo() {
        // Accessing public variable
        System.out.println("Roll No: " + rollNumber); 
        // Accessing protected variable directly (Allowed in subclass)
        System.out.println("Name: " + name);
        // System.out.println(CGPA); // ERROR: Cannot access private variable directly
        // Must use getter
        System.out.println("CGPA: " + getCGPA());
    }
}