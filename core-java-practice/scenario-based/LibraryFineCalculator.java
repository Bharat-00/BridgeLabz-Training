import java.util.Scanner;
public class LibraryFineCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalFine = 0;
        System.out.println("📚 Rohan’s Library Fine Calculator");
        for (int book = 1; book <= 5; book++) {
            System.out.print("\nEnter due day for Book " + book + ": ");
            int dueDate = scanner.nextInt();
            System.out.print("Enter return day for Book " + book + ": ");
            int returnDate = scanner.nextInt();
            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * 5;
                totalFine += fine;
                System.out.println("Late by " + lateDays + " days. Fine: ₹" + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }
        System.out.println("\nTotal Fine for all books: ₹" + totalFine);
    }
}
