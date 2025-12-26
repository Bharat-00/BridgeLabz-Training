import java.util.Scanner;
public class MatrixOperations {
    /*
     * Method to create a random matrix
     * Values range from 1 to 9
     */
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * 9);
            }
        }
        return matrix;
    }
    /*
     * Method to add two matrices
     */
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }
    /*
     * Method to subtract two matrices
     */
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }
    /*
     * Method to multiply two matrices
     */
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    /*
     * Method to display a matrix
     */
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row)
                System.out.print(value + "\t");
            System.out.println();
        }
    }
    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input for matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        // Create random matrices
        int[][] matrixA = createRandomMatrix(rows, cols);
        int[][] matrixB = createRandomMatrix(rows, cols);
        System.out.println("\nMatrix A:");
        displayMatrix(matrixA);
        System.out.println("\nMatrix B:");
        displayMatrix(matrixB);
        // Addition
        System.out.println("\nMatrix Addition (A + B):");
        displayMatrix(addMatrices(matrixA, matrixB));
        // Subtraction
        System.out.println("\nMatrix Subtraction (A - B):");
        displayMatrix(subtractMatrices(matrixA, matrixB));
        // Multiplication (only if possible)
        if (cols == rows) {
            System.out.println("\nMatrix Multiplication (A × B):");
            displayMatrix(multiplyMatrices(matrixA, matrixB));
        } else {
            System.out.println("\nMatrix multiplication not possible for given dimensions.");
        }
    }
}
