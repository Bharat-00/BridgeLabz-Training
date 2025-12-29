import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take date input from user
        System.out.print("Enter a date (yyyy-mm-dd): ");
        LocalDate inputDate = LocalDate.parse(scanner.nextLine());
        // Add 7 days, 1 month, and 2 years
        LocalDate modifiedDate = inputDate
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2);
        // Subtract 3 weeks
        modifiedDate = modifiedDate.minusWeeks(3);
        // Display results
        System.out.println("Original Date: " + inputDate);
        System.out.println("Date after adding and subtracting values: " + modifiedDate);
    }
}
