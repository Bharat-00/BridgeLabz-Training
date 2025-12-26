import java.util.Scanner;
public class CalendarDisplay {
    // Array to store month names
    static String[] months = {
        "January", "February", "March", "April",
        "May", "June", "July", "August",
        "September", "October", "November", "December"
    };
    // Array to store number of days in each month (non-leap year)
    static int[] daysInMonth = {
        31, 28, 31, 30,
        31, 30, 31, 31,
        30, 31, 30, 31
    };
    // Method to check leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    // Method to get number of days in a month
    public static int getDays(int month, int year) {
        if (month == 1 && isLeapYear(year)) {
            return 29; // February in leap year
        }
        return daysInMonth[month];
    }
    // Method to get first day of the month using Gregorian calendar algorithm
    // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    public static int getFirstDay(int month, int year) {
        int m = month + 1;
        int y0 = year - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;
        return d0;
    }
    // Method to display calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("\n    " + months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDay = getFirstDay(month, year);
        int totalDays = getDays(month, year);
        // Print initial spaces for indentation
        for (int i = 0; i < firstDay; i++) {
            System.out.printf("%4s", "");
        }
        // Print days of the month
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%4d", day);
            // Move to next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input month and year
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        // Convert month to 0-based index
        month = month - 1;
        // Display calendar
        displayCalendar(month, year);
    }
}
