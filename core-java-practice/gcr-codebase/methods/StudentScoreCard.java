import java.util.Scanner;
public class StudentScoreCard {
    /*
     * Method to generate random 2-digit PCM scores for students
     * Returns a 2D array:
     * Column 0 → Physics
     * Column 1 → Chemistry
     * Column 2 → Maths
     */
    public static int[][] generatePCMScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = 10 + (int) (Math.random() * 90); // Physics
            scores[i][1] = 10 + (int) (Math.random() * 90); // Chemistry
            scores[i][2] = 10 + (int) (Math.random() * 90); // Maths
        }
        return scores;
    }
    /*
     * Method to calculate total, average and percentage
     * Returns a 2D array:
     * Column 0 → Total
     * Column 1 → Average
     * Column 2 → Percentage
     */
    public static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            // Round off to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }
    /*
     * Method to calculate grade based on percentage
     */
    public static String calculateGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }
    /*
     * Method to display scorecard in tabular format
     */
    public static void displayScoreCard(int[][] scores, double[][] result) {
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("Stu\tPhysics\tChem\tMaths\tTotal\tAvg\t%\tGrade");
        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            String grade = calculateGrade(result[i][2]);
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\t%s%n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    grade);
        }
        System.out.println("-------------------------------------------------------------------");
    }
    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input for number of students
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();
        // Generate scores
        int[][] scores = generatePCMScores(students);
        // Calculate results
        double[][] results = calculateResults(scores);
        // Display scorecard
        displayScoreCard(scores, results);
    }
}
