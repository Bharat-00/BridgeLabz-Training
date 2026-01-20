public class BinaryAndLinearSearch {
    // ---------- LINEAR SEARCH ----------
    // Returns index of target if found, else -1
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
    // ---------- BINARY SEARCH ----------
    // Returns index of target if found, else -1
    public static int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        int datasetSize = 1_000_000;
        int[] data = new int[datasetSize];
        // Fill dataset with sorted values
        for (int i = 0; i < datasetSize; i++) {
            data[i] = i + 1;
        }
        int target = datasetSize; // Worst-case target
        // ---------- LINEAR SEARCH TIMING ----------
        long linearStartTime = System.nanoTime();
        int linearResult = linearSearch(data, target);
        long linearEndTime = System.nanoTime();
        long linearTimeTaken = linearEndTime - linearStartTime;
        // ---------- BINARY SEARCH TIMING ----------
        // Data already sorted
        long binaryStartTime = System.nanoTime();
        int binaryResult = binarySearch(data, target);
        long binaryEndTime = System.nanoTime();
        long binaryTimeTaken = binaryEndTime - binaryStartTime;
        // ---------- OUTPUT ----------
        System.out.println("Dataset Size: " + datasetSize);
        System.out.println();
        System.out.println("Linear Search Result:");
        System.out.println("Index Found: " + linearResult);
        System.out.println("Time Taken: " + linearTimeTaken + " ns");
        System.out.println();
        System.out.println("Binary Search Result:");
        System.out.println("Index Found: " + binaryResult);
        System.out.println("Time Taken: " + binaryTimeTaken + " ns");
    }
}
