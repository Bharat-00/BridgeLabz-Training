// Program to demonstrate Employee Management System concepts
// Concepts used: static, this, final, instanceof
// Employee class definition
class Employee {
    // Static variables
    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;
    // Instance variables
    private final String name;
    private final int id;          // final variable (cannot be changed)
    private final String designation;
    // Constructor using 'this' keyword
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;          // increment employee count
    }
    // Static method to display total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Company Name: " + companyName);
    }
    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Company Name: " + companyName);
    }
}
// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating Employee objects
        Employee emp1 = new Employee("Thamarai", 101, "Software Engineer");
        Employee emp2 = new Employee("Rohan", 102, "Project Manager");
        // Display total employees using static method
        Employee.displayTotalEmployees();
        // Checking instanceof before displaying employee details
        if (emp1 instanceof Employee) {
            emp1.displayEmployeeDetails();
        }
        if (emp2 instanceof Employee) {
            emp2.displayEmployeeDetails();
        }
    }
}
