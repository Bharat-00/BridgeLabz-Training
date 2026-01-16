public class HeapSortJobSalaries {
    static void heapSort(int[] salaries) {
        int n = salaries.length;
        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(salaries, n, i);
        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }
    static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && salaries[left] > salaries[largest])
            largest = left;
        if (right < n && salaries[right] > salaries[largest])
            largest = right;
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;
            heapify(salaries, n, largest);
        }
    }
    public static void main(String[] args) {
        int[] expectedSalaries = {60000, 45000, 80000, 55000, 70000};
        System.out.println("Before Sorting:");
        for (int salary : expectedSalaries)
            System.out.print(salary + " ");
        heapSort(expectedSalaries);
        System.out.println("\nAfter Heap Sort:");
        for (int salary : expectedSalaries)
            System.out.print(salary + " ");
    }
}
