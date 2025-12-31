// Program to Display Employee Details
// Employee class definition
class Employee {
    // Instance variables
    private final String name;
    private final int id;
    private final double salary;
    // Constructor to initialize employee details
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary + ".");
    }
}
// Main class
public class EmployeeDetails {
    public static void main(String[] args) {
        // Creating Employee object
        Employee employee = new Employee("Rohan", 1, 500000);
        // Displaying employee details
        employee.displayDetails();
    }
}
