
public class EmployeeWages {
    // Constants used across various Use Cases
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int NUM_OF_WORKING_DAYS = 20;
    public static final int MAX_HRS_IN_MONTH = 100;
    public static void main(String[] args) {
        System.out.println("--- UC 1: Employee Attendance ---");
        checkAttendance();
        System.out.println("\n--- UC 2: Daily Wage ---");
        calculateDailyWage();
        System.out.println("\n--- UC 3: Part-Time Wage ---");
        calculatePartTimeWage();
        System.out.println("\n--- UC 4: Switch Case Implementation ---");
        calculateWageWithSwitch();
        System.out.println("\n--- UC 5: Monthly Wage Calculation ---");
        calculateMonthlyWage();
        System.out.println("\n--- UC 6: Wage with Hours/Days Limit ---");
        calculateWageTillCondition();
    }
    /**
     * UC 1: Check Employee is Present or Absent.
     * Uses Math.random to simulate a 50/50 chance of presence.
     */
    public static void checkAttendance() {
        int isFullTime = 1;
        double empCheck = Math.floor(Math.random() * 10) % 2;
        if (empCheck == isFullTime) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }
    /**
     * UC 2: Calculate Daily Employee Wage.
     * Formula: Wage = Hours (8) * Rate Per Hour (20).
     */
    public static void calculateDailyWage() {
        int empHrs = 0;
        double empCheck = Math.floor(Math.random() * 10) % 2;
        if (empCheck == 1) {
            empHrs = 8;
        } else {
            empHrs = 0;
        }
        int empWage = empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Daily Wage: " + empWage);
    }
    /**
     * UC 3: Add Part time Employee & Wage.
     * Adds logic to check for Part-time (4 hrs) vs Full-time (8 hrs).
     */
    public static void calculatePartTimeWage() {
        int empHrs = 0;
        double empCheck = Math.floor(Math.random() * 10) % 3;
        if (empCheck == IS_PART_TIME) {
            empHrs = 4;
        } else if (empCheck == IS_FULL_TIME) {
            empHrs = 8;
        } else {
            empHrs = 0;
        }
        int empWage = empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Part-time/Full-time Wage: " + empWage);
    }
    /**
     * UC 4: Solving using Case Statement.
     * Refactors the conditional logic into a Switch-Case block.
     */
    public static void calculateWageWithSwitch() {
        int empHrs = 0;
        int empCheck = (int) Math.floor(Math.random() * 10) % 3;
        empHrs = switch (empCheck) {
            case IS_PART_TIME -> 4;
            case IS_FULL_TIME -> 8;
            default -> 0;
        };
        int empWage = empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Wage using Switch Case: " + empWage);
    }
    /**
     * UC 5: Calculating Wages for a Month.
     * Iterates through 20 working days to find the total monthly salary.
     */
    public static void calculateMonthlyWage() {
        int totalEmpWage = 0;
        for (int day = 0; day < NUM_OF_WORKING_DAYS; day++) {
            int empHrs = 0;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            empHrs = switch (empCheck) {
                case IS_PART_TIME -> 4;
                case IS_FULL_TIME -> 8;
                default -> 0;
            };
            totalEmpWage += (empHrs * EMP_RATE_PER_HOUR);
        }
        System.out.println("Total Monthly Wage (20 days): " + totalEmpWage);
    }
    /**
     * UC 6: Calculate Wages till a condition is reached.
     * Limits: 100 total working hours OR 20 total days.
     */
    public static void calculateWageTillCondition() {
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
            totalWorkingDays++;
            int empHrs = 0;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            empHrs = switch (empCheck) {
                case IS_PART_TIME -> 4;
                case IS_FULL_TIME -> 8;
                default -> 0;
            };
            totalEmpHrs += empHrs;
        }
        int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
        System.out.println("Total Wage (Till 100 hrs/20 days): " + totalEmpWage);
        System.out.println("Total Hours Worked: " + totalEmpHrs);
        System.out.println("Total Days Worked: " + totalWorkingDays);
    }
}