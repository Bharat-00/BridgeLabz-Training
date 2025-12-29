import java.util.Scanner;
public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int voteCountCandidate1 = 0;
        int voteCountCandidate2 = 0;
        int voteCountCandidate3 = 0;
        System.out.println("🗳️ Election Booth Manager Started");
        System.out.println("Enter -1 as age to close the booth");
        while (true) {
            System.out.print("\nEnter voter's age: ");
            int age = scanner.nextInt();
            // Exit condition
            if (age == -1) {
                System.out.println("Election Booth Closed.");
                break;
            }
            // Check voting eligibility
            if (age < 18) {
                System.out.println("Not eligible to vote.");
                continue;
            }
            // Record vote
            System.out.print("Enter your vote (1 / 2 / 3): ");
            int vote = scanner.nextInt();
            if (vote == 1) {
                voteCountCandidate1++;
                System.out.println("Vote recorded for Candidate 1");
            } else if (vote == 2) {
                voteCountCandidate2++;
                System.out.println("Vote recorded for Candidate 2");
            } else if (vote == 3) {
                voteCountCandidate3++;
                System.out.println("Vote recorded for Candidate 3");
            } else {
                System.out.println("Invalid vote! Vote not counted.");
            }
        }
        // Display final results
        System.out.println("\n📊 Final Election Results:");
        System.out.println("Candidate 1 Votes: " + voteCountCandidate1);
        System.out.println("Candidate 2 Votes: " + voteCountCandidate2);
        System.out.println("Candidate 3 Votes: " + voteCountCandidate3);
    }
}
