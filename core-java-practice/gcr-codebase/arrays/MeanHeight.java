import java.util.Scanner;
public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter heights of 11 students:");
        double[] heights = new double[11];
        double sum = 0.0;
        for (int i = 0; i < 11; i++) {
            heights[i] = sc.nextDouble();
        }
        for (int i = 0; i < 11; i++) {
            sum += heights[i];
        }
        double mean = sum / 11;
        System.out.println("Mean Height = " + mean);
    }
}
