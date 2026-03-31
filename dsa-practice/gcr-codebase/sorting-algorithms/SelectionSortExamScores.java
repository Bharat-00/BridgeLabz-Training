public class SelectionSortExamScores {
    static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] examScores = {72, 88, 65, 91, 80};
        System.out.println("Before Sorting:");
        for (int score : examScores)
            System.out.print(score + " ");
        selectionSort(examScores);
        System.out.println("\nAfter Selection Sort:");
        for (int score : examScores)
            System.out.print(score + " ");
    }
}
