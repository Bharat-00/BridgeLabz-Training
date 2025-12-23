import java.util.Random;
import java.util.Scanner;
public class VotingEligibility {
    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90); // generates age between 0 and 89
        }
        return ages;
    }
    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }
    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + Boolean.parseBoolean(data[i][1]));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        // Generate random ages
        int[] ages = generateAges(n);
        // Check voting eligibility
        String[][] votingStatus = checkVotingEligibility(ages);
        // Display result
        displayTable(votingStatus);
    }
}
