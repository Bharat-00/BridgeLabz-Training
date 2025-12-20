import java.util.Scanner;
public class TheCoffeeCounterChronicles{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to The Coffee Counter Chronicles!");
        final double GST_RATE = 0.05;
        while (true) { 
            System.out.println("Enter coffee type (Espresso / Latte / Cappuccino) or type 'exit' to stop:");
            String coffeeType = sc.nextLine();
            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for visiting The Coffee Counter Chronicles!");
                break;
            }
            System.out.println("Enter quantity: ");
            int quantity=sc.nextInt();
            double pricePerCup;
            switch (coffeeType.toLowerCase()) {
                case "espresso" -> pricePerCup = 70.00;
                case "latte" -> pricePerCup = 100.00;
                case "cappuccino" -> pricePerCup = 120.00;
                default -> {
                    System.out.println("Invalid coffee type. Please try again.");
                    sc.nextLine(); 
                    continue;
                }
            }
            double billAmount = pricePerCup * quantity;
            double gstAmount = billAmount * GST_RATE;
            double finalAmount = billAmount + gstAmount;
            System.out.println("Bill Amount: Rs. " + billAmount);
            System.out.println("GST (5%): Rs. " + gstAmount);
            System.out.println("Total Payable: Rs. " + finalAmount);
            System.out.println("--------------------------------");
        }

    }
}