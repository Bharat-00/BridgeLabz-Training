public class NumberChecker3 {
    // Method to count number of digits in a number
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
    // Method to extract digits of a number into an array
    public static int[] getDigits(int number) {
        number = Math.abs(number);
        int n = countDigits(number);
        int[] digits = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    // Method to reverse the digits array
    public static int[] reverseDigits(int[] digits) {
        int[] rev = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            rev[i] = digits[digits.length - 1 - i];
        }
        return rev;
    }
    // Method to check whether a number is palindrome
    public static boolean isPalindrome(int number) {
        int[] digits = getDigits(number);
        int[] rev = reverseDigits(digits);
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != rev[i]) {
                return false;
            }
        }
        return true;
    }
    // Test the program
    public static void main(String[] args) {
        int number = 121;
        System.out.println("Number: " + number);
        System.out.println("Is Palindrome: " + isPalindrome(number));
    }
}
