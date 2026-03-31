import java.util.*;
public class ArrayHashSetAndTreeSet {
    // Linear Search in Array (O(N))
    public static boolean arraySearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
    // HashSet Search (O(1) average)
    public static boolean hashSetSearch(HashSet<Integer> set, int target) {
        return set.contains(target);
    }
    // TreeSet Search (O(log N))
    public static boolean treeSetSearch(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }
    // Measure Array Search Time
    public static long measureArraySearch(int[] arr, int target) {
        long start = System.nanoTime();
        arraySearch(arr, target);
        long end = System.nanoTime();
        return end - start;
    }
    // Measure HashSet Search Time
    public static long measureHashSetSearch(HashSet<Integer> set, int target) {
        long start = System.nanoTime();
        hashSetSearch(set, target);
        long end = System.nanoTime();
        return end - start;
    }
    // Measure TreeSet Search Time
    public static long measureTreeSetSearch(TreeSet<Integer> set, int target) {
        long start = System.nanoTime();
        treeSetSearch(set, target);
        long end = System.nanoTime();
        return end - start;
    }
    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size - 1;
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        // Populate data structures
        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        System.out.println("Search Performance Comparison");
        System.out.println("Dataset Size = " + size);
        System.out.println("--------------------------------");
        long arrayTime = measureArraySearch(array, target);
        long hashSetTime = measureHashSetSearch(hashSet, target);
        long treeSetTime = measureTreeSetSearch(treeSet, target);
        System.out.println("Execution Time (in nanoseconds)");
        System.out.println("Array Search   (O(N))      : " + arrayTime + " ns");
        System.out.println("HashSet Search (O(1))      : " + hashSetTime + " ns");
        System.out.println("TreeSet Search (O(log N))  : " + treeSetTime + " ns");
    }
}
