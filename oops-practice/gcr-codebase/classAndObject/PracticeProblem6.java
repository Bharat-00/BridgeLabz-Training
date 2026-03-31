public class PracticeProblem6 {
    private String customerName;
    private String carModel;
    private int rentalDays;
    // Constructor
    public PracticeProblem6(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    // Private method to encapsulate heavy logic
    private double calculateTotalCost() {
        double dailyRate;
        // Simple logic to determine rate based on model
        if (carModel.equalsIgnoreCase("Luxury")) {
            dailyRate = 250.0;
        } else if (carModel.equalsIgnoreCase("SUV")) {
            dailyRate = 100.0;
        } else {
            dailyRate = 50.0;
        }
        return dailyRate * rentalDays;
    }
    public void generateBill() {
        double total = calculateTotalCost(); // Calling the private method
        System.out.println("--- Car Rental Bill ---");
        System.out.println("Customer: " + customerName);
        System.out.println("Car: " + carModel);
        System.out.println("Days: " + rentalDays);
        System.out.println("Total Due: $" + total);
    }
    // Main method to test the code
    public static void main(String[] args) {
        System.out.println("--- Problem 6: Car Rental ---");
        PracticeProblem6 rental1 = new PracticeProblem6("Tom Cruise", "Luxury", 3);
        rental1.generateBill();
        PracticeProblem6 rental2 = new PracticeProblem6("Jerry Mouse", "Hatchback", 7);
        rental2.generateBill();
    }
}