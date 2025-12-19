import java.util.Scanner;
public class EmployeeBonus2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee's salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter employee's years of service: ");
        int yearsOfService = sc.nextInt();
        if(yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("Bonus amount is zero.");
        }
    }
}
