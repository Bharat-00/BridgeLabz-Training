import java.util.Arrays;
public class LinearBinarySearchChallenge {
    // Linear Search: First Missing Positive Integer
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 1];
        for (int num : arr) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return n + 1;
    }
    // Binary Search for target index
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;
        // Linear Search result
        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missing);
        // Sort array for Binary Search
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        // Binary Search result
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
