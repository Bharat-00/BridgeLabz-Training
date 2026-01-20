import java.util.Arrays;
import java.util.Random;
public class BubbleAndMergeSort {
    // ---------- BUBBLE SORT ----------
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: stop if already sorted
            if (!swapped) {
                break;
            }
        }
    }
    // ---------- MERGE SORT ----------
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }
    // ---------- QUICK SORT ----------
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        int datasetSize = 10_000; // Change to 1_000 or 1_000_000 as needed
        int[] originalData = new int[datasetSize];
        Random random = new Random();
        for (int i = 0; i < datasetSize; i++) {
            originalData[i] = random.nextInt(datasetSize);
        }
        // Create copies so each algorithm sorts the same data
        int[] bubbleData = Arrays.copyOf(originalData, datasetSize);
        int[] mergeData = Arrays.copyOf(originalData, datasetSize);
        int[] quickData = Arrays.copyOf(originalData, datasetSize);
        // ---------- BUBBLE SORT TIMING ----------
        long bubbleStart = System.nanoTime();
        bubbleSort(bubbleData);
        long bubbleEnd = System.nanoTime();
        long bubbleTime = bubbleEnd - bubbleStart;
        // ---------- MERGE SORT TIMING ----------
        long mergeStart = System.nanoTime();
        mergeSort(mergeData, 0, mergeData.length - 1);
        long mergeEnd = System.nanoTime();
        long mergeTime = mergeEnd - mergeStart;
        // ---------- QUICK SORT TIMING ----------
        long quickStart = System.nanoTime();
        quickSort(quickData, 0, quickData.length - 1);
        long quickEnd = System.nanoTime();
        long quickTime = quickEnd - quickStart;
        // ---------- OUTPUT ----------
        System.out.println("Dataset Size: " + datasetSize);
        System.out.println();
        System.out.println("Bubble Sort Time: " + bubbleTime + " ns");
        System.out.println("Merge Sort Time : " + mergeTime + " ns");
        System.out.println("Quick Sort Time : " + quickTime + " ns");
    }
}
