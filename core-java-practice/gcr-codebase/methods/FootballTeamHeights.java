import java.util.Random;
public class FootballTeamHeights {
    // Method to find sum of heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights)
            sum += h;
        return sum;
    }
    // Method to find mean height
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }
    // Method to find shortest height
    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int h : heights)
            min = Math.min(min, h);
        return min;
    }
    // Method to find tallest height
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights)
            max = Math.max(max, h);
        return max;
    }
    public static void main(String[] args) {
        int[] heights = new int[11];
        Random r = new Random();
        // Generate random heights (150–250 cm)
        for (int i = 0; i < heights.length; i++) {
            heights[i] = r.nextInt(101) + 150;
            System.out.println("Player " + (i + 1) + " Height: " + heights[i] + " cm");
        }
        System.out.println("\nShortest Height: " + findShortest(heights));
        System.out.println("Tallest Height: " + findTallest(heights));
        System.out.println("Mean Height: " + findMean(heights));
    }
}
