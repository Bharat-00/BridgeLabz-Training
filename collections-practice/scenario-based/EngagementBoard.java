import java.util.*;
// POJO class
class CreatorStats {
    public String creatorName;
    public double[] weeklyLikes;
    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }
}
// Main Logic Class
public class EngagementBoard {
    // Already provided in template (assumed)
    public static List<CreatorStats> EngagementBoard = new ArrayList<>();
    // Register creator record
    public static void RegisterCreator(CreatorStats record) {
        EngagementBoard.add(record);
    }
    // Get creators whose weekly likes meet threshold
    public static Dictionary<String, List<CreatorStats>> GetTopPostCount(
            List<CreatorStats> list, double likeThreshold) {
        Dictionary<String, List<CreatorStats>> result = new Hashtable<>();
        List<CreatorStats> qualified = new ArrayList<>();
        for (CreatorStats cs : list) {
            boolean meetsThreshold = false;
            for (double likes : cs.weeklyLikes) {
                if (likes >= likeThreshold) {
                    meetsThreshold = true;
                    break;
                }
            }
            if (meetsThreshold) {
                qualified.add(cs);
            }
        }
        if (!qualified.isEmpty()) {
            result.put("TopPerformingPosts", qualified);
        }
        return result;
    }
    // Calculate average weekly likes
    public static double CalculateAverageLikes(List<CreatorStats> list) {
        double total = 0;
        int count = 0;
        for (CreatorStats cs : list) {
            for (double likes : cs.weeklyLikes) {
                total += likes;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }
    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Register Creator");
        System.out.println("2. Get Top Post Count");
        System.out.println("3. Calculate Average Likes");
        int choice = sc.nextInt();
        if (choice == 1) {
            sc.nextLine();
            System.out.println("Enter Creator Name:");
            String name = sc.nextLine();
            double[] likes = new double[4];
            System.out.println("Enter Weekly Likes for 4 weeks:");
            for (int i = 0; i < 4; i++) {
                likes[i] = sc.nextDouble();
            }
            RegisterCreator(new CreatorStats(name, likes));
            System.out.println("Creator registered successfully");
        } else if (choice == 2) {
            System.out.println("Enter Like Threshold:");
            double threshold = sc.nextDouble();
            Dictionary<String, List<CreatorStats>> result =
                    GetTopPostCount(EngagementBoard, threshold);
            if (result.isEmpty()) {
                System.out.println("No creators meet the threshold");
            } else {
                for (CreatorStats cs : result.get("TopPerformingPosts")) {
                    System.out.println(cs.creatorName);
                }
            }
        } else if (choice == 3) {
            double avg = CalculateAverageLikes(EngagementBoard);
            System.out.println("Overall average weekly likes: " + avg);

        }
    }
}
