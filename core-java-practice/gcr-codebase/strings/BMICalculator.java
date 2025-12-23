import java.util.Scanner;
public class BMICalculator {
    // Method to calculate BMI and Status
    public static String[][] calculateBMIStatus(double[][] data) {
        String[][] bmiData = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;
            String status;
            if (bmi < 18.5)
                status = "Underweight";
            else if (bmi < 25)
                status = "Normal";
            else if (bmi < 30)
                status = "Overweight";
            else
                status = "Obese";
            bmiData[i][0] = String.valueOf(heightCm);
            bmiData[i][1] = String.valueOf(weight);
            bmiData[i][2] = String.valueOf(bmi);
            bmiData[i][3] = status;
        }
        return bmiData;
    }
    // Method to process height & weight and return final 2D String array
    public static String[][] processBMI(double[][] data) {
        return calculateBMIStatus(data);
    }
    // Method to display result in tabular format
    public static void displayResult(String[][] result) {
        System.out.println("\nBMI Report");
        System.out.println("--------------------------------------------------------");
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.println((i + 1) + "\t" +
                    result[i][0] + "\t\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t" +
                    result[i][3]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }
        String[][] result = processBMI(data);
        displayResult(result);
    }
}
