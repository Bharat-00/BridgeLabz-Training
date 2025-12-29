import java.time.LocalDate;
import java.util.Scanner;
public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input first date
        System.out.print("Enter first date (yyyy-mm-dd): ");
        LocalDate firstDate = LocalDate.parse(scanner.nextLine());
        // Input second date
        System.out.print("Enter second date (yyyy-mm-dd): ");
        LocalDate secondDate = LocalDate.parse(scanner.nextLine());
        // Compare dates
        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is BEFORE the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is AFTER the second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are the SAME.");
        }
    }
}
