public class CountingSortStudentAges {
    static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        // Step 1: Create count array
        int[] count = new int[maxAge - minAge + 1];
        // Step 2: Store frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }
        // Step 3: Compute cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // Step 4: Create output array
        int[] output = new int[ages.length];
        // Step 5: Place elements in correct position
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            int position = count[age - minAge] - 1;
            output[position] = age;
            count[age - minAge]--;
        }
        // Copy sorted elements back to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] studentAges = {15, 12, 18, 10, 14, 16, 12, 11};
        System.out.println("Before Sorting:");
        for (int age : studentAges)
            System.out.print(age + " ");
        countingSort(studentAges);
        System.out.println("\nAfter Counting Sort:");
        for (int age : studentAges)
            System.out.print(age + " ");
    }
}
