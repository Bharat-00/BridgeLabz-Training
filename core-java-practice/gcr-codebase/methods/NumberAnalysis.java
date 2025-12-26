import java.util.Scanner;
public class NumberAnalysis {
    public static boolean isPositive(int n) {
        return n > 0;
    }
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    public static int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            if (isPositive(arr[i])) {
                System.out.println(isEven(arr[i]) ? "Positive Even" : "Positive Odd");
            } else {
                System.out.println("Negative");
            }
        }
        int result = compare(arr[0], arr[arr.length - 1]);
        System.out.println(result == 0 ? "First and Last are Equal"
                : result > 0 ? "First is Greater" : "Last is Greater");
    }
}
