public class FirstNegativeSearch {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // index of first negative number
            }
        }
        return -1; // no negative number found
    }
    public static void main(String[] args) {
        int[] numbers = {5, 10, 3, -2, -8};
        int result = findFirstNegative(numbers);
        System.out.println(result);
    }
}
