import java.util.Scanner;
public class BMIProgram {
    public static void calculateBMI(double[][] data) {
        for (double[] data1 : data) {
            double heightMeters = data1[1] / 100;
            data1[2] = data1[0] / (heightMeters * heightMeters);
        }
    }
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }
        calculateBMI(data);
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) +
                    " BMI: " + data[i][2] +
                    " Status: " + getBMIStatus(data[i][2]));
        }
    }
}
