public class MatrixAdvancedOperations {
    /* Method to create a random matrix */
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = 1 + (int) (Math.random() * 9);
        return matrix;
    }
    /* Method to find transpose of a matrix */
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }
    /* Determinant of 2x2 matrix */
    public static int determinant2x2(int[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }
    /* Determinant of 3x3 matrix */
    public static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }
    /* Inverse of 2x2 matrix */
    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double) det;
        inv[0][1] = -m[0][1] / (double) det;
        inv[1][0] = -m[1][0] / (double) det;
        inv[1][1] = m[0][0] / (double) det;
        return inv;
    }
    /* Inverse of 3x3 matrix */
    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) return null;
        double[][] inv = new double[3][3];
        inv[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / (double)det;
        inv[0][1] = (m[0][2]*m[2][1] - m[0][1]*m[2][2]) / (double)det;
        inv[0][2] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / (double)det;
        inv[1][0] = (m[1][2]*m[2][0] - m[1][0]*m[2][2]) / (double)det;
        inv[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / (double)det;
        inv[1][2] = (m[0][2]*m[1][0] - m[0][0]*m[1][2]) / (double)det;
        inv[2][0] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / (double)det;
        inv[2][1] = (m[0][1]*m[2][0] - m[0][0]*m[2][1]) / (double)det;
        inv[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / (double)det;
        return inv;
    }
    /* Method to display int matrix */
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }
    /* Method to display double matrix */
    public static void displayDoubleMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%.2f\t", val);
            System.out.println();
        }
    }
    /* Main Method */
    public static void main(String[] args) {
        System.out.println("2x2 MATRIX OPERATIONS");
        int[][] matrix2 = createRandomMatrix(2, 2);
        displayMatrix(matrix2);
        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(matrix2));
        System.out.println("Determinant: " + determinant2x2(matrix2));
        double[][] inv2 = inverse2x2(matrix2);
        if (inv2 != null) {
            System.out.println("Inverse:");
            displayDoubleMatrix(inv2);
        } else {
            System.out.println("Inverse not possible");
        }
        System.out.println("\n3x3 MATRIX OPERATIONS");
        int[][] matrix3 = createRandomMatrix(3, 3);
        displayMatrix(matrix3);
        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(matrix3));
        System.out.println("Determinant: " + determinant3x3(matrix3));
        double[][] inv3 = inverse3x3(matrix3);
        if (inv3 != null) {
            System.out.println("Inverse:");
            displayDoubleMatrix(inv3);
        } else {
            System.out.println("Inverse not possible");
        }
    }
}
