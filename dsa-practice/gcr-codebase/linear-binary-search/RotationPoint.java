public class RotationPoint {
    public static int findRotationIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // index of smallest element (rotation point)
    }
    public static void main(String[] args) {
        int[] arr = {6, 7, 9, 1, 2, 3, 4};
        int index = findRotationIndex(arr);
        System.out.println("Rotation Index: " + index);
        System.out.println("Smallest Element: " + arr[index]);
    }
}
