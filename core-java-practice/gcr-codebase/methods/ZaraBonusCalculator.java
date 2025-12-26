public class ZaraBonusCalculator {
    // Constant for number of employees
    static final int EMPLOYEES = 10;
    /*
     * Method to generate salary and years of service
     * Salary: 5-digit random number (10000–99999)
     * Years of service: random between 1–10
     * Stores values in a 2D array
     */
    public static double[][] generateEmployeeData() {
        double[][] data = new double[EMPLOYEES][2];
        for (int i = 0; i < EMPLOYEES; i++) {
            // Generate 5-digit salary
            double salary = 10000 + Math.random() * 90000;
            // Generate years of service (1 to 10)
            int years = 1 + (int) (Math.random() * 10);
            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }
    /*
     * Method to calculate bonus and new salary
     * Bonus:
     *   >5 years → 5%
     *   ≤5 years → 2%
     * Returns a 2D array with new salary and bonus
     */
    public static double[][] calculateBonus(double[][] data) {
        double[][] result = new double[EMPLOYEES][2];
        for (int i = 0; i < EMPLOYEES; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus;
            // Bonus logic
            if (years > 5)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;
            double newSalary = salary + bonus;
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }
    /*
     * Method to calculate and display total salaries and bonus
     * Displays result in tabular format
     */
    public static void displaySummary(double[][] data, double[][] result) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < EMPLOYEES; i++) {
            double oldSalary = data[i][0];
            double years = data[i][1];
            double bonus = result[i][1];
            double newSalary = result[i][0];
            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f%n",
                    (i + 1), oldSalary, years, bonus, newSalary);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.printf("TOTAL\t%.2f\t\t\t%.2f\t%.2f%n",
                totalOldSalary, totalBonus, totalNewSalary);
        System.out.println("---------------------------------------------------------------");
    }
    // Main method
    public static void main(String[] args) {
        System.out.println("ZARA COMPANY BONUS CALCULATION\n");
        // Step 1: Generate salary and service data
        double[][] employeeData = generateEmployeeData();
        // Step 2: Calculate bonus and new salary
        double[][] bonusData = calculateBonus(employeeData);
        // Step 3: Display summary in tabular format
        displaySummary(employeeData, bonusData);
    }
}
