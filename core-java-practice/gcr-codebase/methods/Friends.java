import java.util.Scanner;
public class Friends {
    public static int findYoungest(int[] ages) {
        int min = ages[0];
        for (int age : ages)
            min = Math.min(min, age);
        return min;
    }
    public static double findTallest(double[] heights) {
        double max = heights[0];
        for (double h : heights)
            max = Math.max(max, h);
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }
        System.out.println("Youngest age: " + findYoungest(ages));
        System.out.println("Tallest height: " + findTallest(heights));
    }
}
