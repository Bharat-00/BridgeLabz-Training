import java.util.Scanner;
public class FitnessChallengeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pushUpsPerDay = new int[7];
        int totalPushUps = 0;
        int activeDays = 0;
        System.out.println("🏋️ Sandeep’s Fitness Challenge (7 Days)");
        // Input push-ups for each day
        for (int day = 0; day < 7; day++) {
            System.out.print("Enter push-ups for Day " + (day + 1) + ": ");
            pushUpsPerDay[day] = scanner.nextInt();
        }
        // Calculate total and average using for-each
        for (int pushUps : pushUpsPerDay) {
            if (pushUps == 0) {
                continue; // Skip rest day
            }
            totalPushUps += pushUps;
            activeDays++;
        }
        double average = (activeDays > 0) ? (double) totalPushUps / activeDays : 0;
        System.out.println("\nTotal Push-ups (excluding rest days): " + totalPushUps);
        System.out.println("Average Push-ups per active day: " + average);
    }
}
