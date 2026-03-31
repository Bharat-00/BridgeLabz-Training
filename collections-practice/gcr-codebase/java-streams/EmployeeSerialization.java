import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public void display() {
        System.out.println(
                "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Salary: " + salary
        );
    }
}
public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Alice", "HR", 45000));
        employeeList.add(new Employee(2, "Bob", "IT", 60000));
        employeeList.add(new Employee(3, "Carol", "Finance", 55000));
        // Serialization
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("employees.dat"));
            oos.writeObject(employeeList);
            oos.close();
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization.");
        }
        // Deserialization
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("employees.dat"));
            List<Employee> savedEmployees =
                    (List<Employee>) ois.readObject();

            ois.close();
            System.out.println("\nDeserialized Employee Details:");
            for (Employee emp : savedEmployees) {
                emp.display();
            }
        } catch (IOException e) {
            System.out.println("Error during deserialization.");
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
        }
    }
}
