public class NumberChecker2 {
    // Count digits (handles 0 and negative numbers)
    public static int countDigits(int number) {
        number = Math.abs(number);
        if (number == 0) return 1;
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    // Return digits array (most-significant digit at index 0)
    public static int[] getDigits(int number) {
        number = Math.abs(number);
        int n = countDigits(number);
        int[] digits = new int[n];
        // fill from right to left
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    // Sum of digits from digits array
    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }
    // Sum of squares of digits
    public static double sumSquares(int[] digits) {
        double sum = 0;
        for (int d : digits)
            sum += Math.pow(d, 2);
        return sum;
    }
    // Harshad check (also handles negative number input)
    public static boolean isHarshad(int number) {
        int[] digits = getDigits(number);
        int sum = sumDigits(digits);
        if (sum == 0) return false; // avoid division by zero; 0 is not considered Harshad here
        return Math.abs(number) % sum == 0;
    }
    // Frequency table: 10 rows, each row [digit, frequency]
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i; // first column = digit
        for (int d : digits) {
            if (d >= 0 && d <= 9) freq[d][1]++;
        }
        return freq;
    }
    // Simple test
    public static void main(String[] args) {
        int number = 1729; // sample
        int[] digits = getDigits(number);
        System.out.println("Digits of " + number + ":");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.println("Sum of digits: " + sumDigits(digits));
        System.out.println("Sum of squares: " + sumSquares(digits));
        System.out.println("Is Harshad: " + isHarshad(number));
        int[][] freq = digitFrequency(digits);
        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d -> %d\n", freq[i][0], freq[i][1]);
        }
    }
}
