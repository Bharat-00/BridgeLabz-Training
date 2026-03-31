// Program to demonstrate University Student Management System
// Concepts used: static, this, final, instanceof
// Student class definition
class Student {
    // Static variables
    static String universityName = "Global University";
    static int totalStudents = 0;
    // Instance variables
    private final int rollNumber;   // final variable (cannot be changed)
    private final String name;
    private String grade;
    // Constructor using 'this' keyword
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;           // increment total students
    }
    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
        System.out.println("University Name: " + universityName);
    }
    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
    // Method to update grade
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated to: " + grade);
    }
}
// Main class
public class UniversityStudentManagement {
    public static void main(String[] args) {
        // Creating Student objects
        Student student1 = new Student(101, "Hemashree", "A");
        Student student2 = new Student(102, "Sharmila", "B");
        // Display total students using static method
        Student.displayTotalStudents();
        // Checking instanceof before displaying details
        if (student1 instanceof Student) {
            student1.displayStudentDetails();
        }
        System.out.println();
        if (student2 instanceof Student) {
            System.out.println("University Name: " + Student.universityName);
            System.out.println("Roll Number: 102");
            System.out.println("Name: Sharmila");
            System.out.println("Grade: B");
            // Updating grade
            student2.updateGrade("A");
            // Displaying updated details
            System.out.println("University Name: " + Student.universityName);
            System.out.println("Roll Number: 102");
            System.out.println("Name: Sharmila");
            System.out.println("Grade: A");
        }
    }
}
