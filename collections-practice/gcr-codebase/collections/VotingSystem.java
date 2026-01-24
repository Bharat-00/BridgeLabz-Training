import java.util.*;
class VotingSystem {
    // Stores votes (Candidate -> Votes)
    private HashMap<String, Integer> voteCount = new HashMap<>();
    // Maintains order in which votes are cast
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    // Add a vote
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }
    // Display results sorted by candidate name
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        System.out.println("Voting Results (Sorted): " + sortedResults);
    }
    // Display vote order
    public void displayVoteOrder() {
        System.out.println("Vote Order: " + voteOrder);
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.displayVoteOrder();
        system.displaySortedResults();
    }
}
