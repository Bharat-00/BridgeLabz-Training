import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class EmployeeSalaryApplication {
    public static void main(String[] args) {
        // Employee list
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", "IT", 60000),
                new Employee("Neha", "HR", 50000),
                new Employee("Ravi", "IT", 70000),
                new Employee("Ananya", "HR", 55000)
        );
        // Calculates average salary per department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + " Average Salary: " + avg));
    }
}
class Employee {
    private String name;
    private String department;
    private double salary;
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
}
