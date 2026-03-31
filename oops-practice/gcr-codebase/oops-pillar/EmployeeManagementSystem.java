import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class Employee implements Department {
    // Encapsulated fields
    private final int employeeId;
    private final String name;
    protected double baseSalary;
    private String department;
    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    // Abstract method
    public abstract double calculateSalary();
    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : ₹" + calculateSalary());
        System.out.println("----------------------------------");
    }
    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    // Interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    @Override
    public String getDepartmentDetails() {
        return department;
    }
}
/* -------------------- FULL TIME EMPLOYEE -------------------- */
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String name, double fixedSalary) {
        super(employeeId, name, fixedSalary);
    }
    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
/* -------------------- PART TIME EMPLOYEE -------------------- */
class PartTimeEmployee extends Employee {
    private final int hoursWorked;
    private final double hourlyRate;
    public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
        super(employeeId, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new FullTimeEmployee(101, "Amit Sharma", 50000);
        emp1.assignDepartment("IT");
        Employee emp2 = new PartTimeEmployee(102, "Neha Verma", 80, 500);
        emp2.assignDepartment("HR");
        employees.add(emp1);
        employees.add(emp2);
        System.out.println("===== Employee Details =====");
        // Polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
