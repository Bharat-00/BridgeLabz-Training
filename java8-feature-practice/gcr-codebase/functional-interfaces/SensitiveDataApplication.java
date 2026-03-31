// Custom marker interface
interface SensitiveData {
}
// Class marked as sensitive
class EmployeeSalary implements SensitiveData {
    private String employeeName;
    private double salary;
    public EmployeeSalary(String employeeName, double salary) {
        this.employeeName = employeeName;
        this.salary = salary;
    }
}
public class SensitiveDataApplication {
    public static void main(String[] args) {
        EmployeeSalary salary = new EmployeeSalary("Ravi", 90000);
        // Checks custom marker interface
        if (salary instanceof SensitiveData) {
            System.out.println("Apply encryption before processing");
        }
    }
}
