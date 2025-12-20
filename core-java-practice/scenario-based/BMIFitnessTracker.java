import java.util.Scanner;
public class BMIFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the BMI Fitness Tracker!");
        while (true) {
            System.out.println("Enter your weight in kg (or type 'exit' to quit):");
            String weightInput = sc.nextLine();

            if (weightInput.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the BMI Fitness Tracker!");
                break;
            }
            try {
                double weight = Double.parseDouble(weightInput);

                System.out.println("Enter your height in meters:");
                double height = Double.parseDouble(sc.nextLine());

                if (weight <= 0 || height <= 0) {
                    System.out.println("Height and weight must be positive numbers.");
                    continue;
                }

                double bmi = weight / (height * height);
                System.out.printf("Your BMI is: %.2f%n", bmi);

                if (bmi < 18.5) {
                    System.out.println("Category: Underweight");
                } else if (bmi < 25) {
                    System.out.println("Category: Normal weight");
                } else if (bmi < 30) {
                    System.out.println("Category: Overweight");
                } else {
                    System.out.println("Category: Obesity");
                }
                System.out.println("--------------------------------");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values only.");
            }
        }
    }
}
