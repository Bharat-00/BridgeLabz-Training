public class InsertionSortEmployeeIDs {
    static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            // Move elements greater than key one position ahead
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 110, 101, 108};
        System.out.println("Before Sorting:");
        for (int id : employeeIDs)
            System.out.print(id + " ");
        insertionSort(employeeIDs);
        System.out.println("\nAfter Insertion Sort:");
        for (int id : employeeIDs)
            System.out.print(id + " ");
    }
}
