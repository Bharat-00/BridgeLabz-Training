import java.util.Scanner;
public class MultipleCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Accept array size
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] array = new int[size];
            // Accept array elements
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            // Accept index
            System.out.print("Enter index to retrieve value: ");
            int index = scanner.nextInt();
            // Retrieve and print value
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred!");
        }
        scanner.close();
    }
}
