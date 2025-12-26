public class NumberChecker5 {
    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++)
            if (n % i == 0) sum += i;
        return sum == n;
    }
    public static boolean isAbundant(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++)
            if (n % i == 0) sum += i;
        return sum > n;
    }
    public static boolean isDeficient(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++)
            if (n % i == 0) sum += i;
        return sum < n;
    }
    public static boolean isStrong(int n) {
        int temp = n, sum = 0;
        while (temp > 0) {
            int d = temp % 10;
            sum += factorial(d);
            temp /= 10;
        }
        return sum == n;
    }
    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }
}
