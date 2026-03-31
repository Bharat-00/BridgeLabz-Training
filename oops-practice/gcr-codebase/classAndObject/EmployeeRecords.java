// Main Class
public class EmployeeRecords {
    public int employeeID;       // Accessible everywhere
    protected String department; // Accessible to subclasses
    private double salary;       // Accessible ONLY inside Employee
    public EmployeeRecords(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    // Public method to modify private salary
    public void setSalary(double newSalary) {
        if(newSalary > 0) {
            this.salary = newSalary;
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Invalid salary amount.");
        }
    }
    // Public getter for display purposes
    public double getSalary() {
        return salary;
    }
    public static void main(String[] args) {
        System.out.println("--- Problem 4: Employee Records ---");   
        Manager mgr = new Manager(101, "Sales", 75000);
        mgr.showDetails();
        // Updating private salary via public method
        mgr.setSalary(80000);
        System.out.println("Updated Salary: $" + mgr.getSalary());
    }
}
// Subclass
class Manager extends EmployeeRecords {   
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
    public void showDetails() {
        System.out.println("Manager Details:");   
        // Accessing public variable directly
        System.out.println("ID: " + employeeID);
        // Accessing protected variable directly (Allowed in subclass)
        System.out.println("Department: " + department);
        // Accessing private variable via getter
        System.out.println("Salary: $" + getSalary());
    }
}