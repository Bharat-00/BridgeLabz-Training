import java.util.Scanner;
public class StudentGradeCalculator {
    // Method to generate random 2-digit PCM scores
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = (int)(Math.random() * 90) + 10; // Physics
            scores[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int)(Math.random() * 90) + 10; // Maths
        }
        return scores;
    }
    // Method to calculate total, average and percentage
    public static double[][] calculateResult(int[][] scores) {
        int students = scores.length;
        double[][] result = new double[students][3];
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }
    // Method to calculate grade based on percentage
    public static String[] calculateGrade(double[][] result) {
        String[] grade = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            double p = result[i][2];
            if (p >= 80) grade[i] = "A";
            else if (p >= 70) grade[i] = "B";
            else if (p >= 60) grade[i] = "C";
            else if (p >= 50) grade[i] = "D";
            else if (p >= 40) grade[i] = "E";
            else grade[i] = "R";
        }
        return grade;
    }
    // Method to display scorecard
    public static void displayScorecard(int[][] scores, double[][] result, String[] grade) {
        System.out.println("\nScorecard");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAverage\t\tPercent\tGrade");
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t" +
                    scores[i][2] + "\t" +
                    (int) result[i][0] + "\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t" +
                    grade[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();
        int[][] scores = generateScores(students);
        double[][] result = calculateResult(scores);
        String[] grade = calculateGrade(result);
        displayScorecard(scores, result, grade);
    }
}
