import java.util.Scanner;
public class CalendarDisplay {
    // Array to store month names
    static String[] months = {
        "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    // Array to store days in each month (non-leap year)
    static int[] daysInMonth = {
        0, 31, 28, 31, 30, 31, 30, 
        31, 31, 30, 31, 30, 31
    };
    // Method to check for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    // Method to get number of days in a month
    public static int getNumberOfDays(int month, int year) {
        if (month == 2) { // February
            return isLeapYear(year) ? 29 : 28;
        }
        return daysInMonth[month];
    }
    // Method to get the first day of the month (0=Sun, 1=Mon, ..., 6=Sat)
    public static int getFirstDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7; // 1 = day 1 of month
        return d0;
    }
    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("    " + months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDay = getFirstDay(month, year);
        int numberOfDays = getNumberOfDays(month, year);
        // Print spaces for the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        // Print all days of the month
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println(); // Move to next line after Saturday
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        displayCalendar(month, year);
    }
}
