// Program to simulate student report
// Student class definition
class Student {
    // Instance variables
    private final String name;
    private final String rollNumber;
    private final int mark1;
    private final int mark2;
    private final int mark3;
    // Constructor to initialize student details
    public Student(String name, String rollNumber, int mark1, int mark2, int mark3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }
    // Method to calculate grade based on average marks
    public char calculateGrade() {
        int average = (mark1 + mark2 + mark3) / 3;

        if (average >= 75) {
            return 'A';
        } else if (average >= 60) {
            return 'B';
        } else {
            return 'C';
        }
    }
    // Method to display student details and grade
    public void displayReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
        System.out.println();
    }
}
// Main class
public class StudentReport {
    public static void main(String[] args) {
        // Creating Student objects
        Student student1 = new Student("Thamarai", "ECE001", 80, 70, 75);
        Student student2 = new Student("Kannan", "CSC002", 60, 65, 50);
        // Displaying student reports
        student1.displayReport();
        student2.displayReport();
    }
}
