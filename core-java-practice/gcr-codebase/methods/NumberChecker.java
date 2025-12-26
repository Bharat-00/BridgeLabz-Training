public class NumberChecker {
    // Count digits
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }
    // Store digits in array
    public static int[] getDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    // Duck number check
    public static boolean isDuck(int[] digits) {
        for (int d : digits)
            if (d != 0) return true;
        return false;
    }
    // Armstrong number check
    public static boolean isArmstrong(int number) {
        int[] digits = getDigits(number);
        int power = digits.length;
        int sum = 0;
        for (int d : digits)
            sum += Math.pow(d, power);
        return sum == number;
    }
    // Largest & second largest digit
    public static int[] largestTwo(int[] digits) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max1) {
                max2 = max1;
                max1 = d;
            } else if (d > max2 && d != max1) {
                max2 = d;
            }
        }
        return new int[]{max1, max2};
    }
    // Smallest & second smallest digit
    public static int[] smallestTwo(int[] digits) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min1) {
                min2 = min1;
                min1 = d;
            } else if (d < min2 && d != min1) {
                min2 = d;
            }
        }
        return new int[]{min1, min2};
    }
    public static void main(String[] args) {
        int number = 153;
        int[] digits = getDigits(number);
        System.out.println("Duck Number: " + isDuck(digits));
        System.out.println("Armstrong Number: " + isArmstrong(number));
        int[] large = largestTwo(digits);
        int[] small = smallestTwo(digits);
        System.out.println("Largest: " + large[0] + ", Second Largest: " + large[1]);
        System.out.println("Smallest: " + small[0] + ", Second Smallest: " + small[1]);
    }
}
