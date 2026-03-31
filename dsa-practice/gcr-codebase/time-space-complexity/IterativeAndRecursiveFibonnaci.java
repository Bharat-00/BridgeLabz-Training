public class IterativeAndRecursiveFibonnaci {
    // Recursive Fibonacci (O(2^n))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    // Iterative Fibonacci (O(n))
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    // Measure Recursive Fibonacci Time
    public static long measureRecursiveTime(int n) {
        long start = System.nanoTime();
        int result = fibonacciRecursive(n);
        long end = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + ") = " + result);
        return end - start;
    }
    // Measure Iterative Fibonacci Time
    public static long measureIterativeTime(int n) {
        long start = System.nanoTime();
        int result = fibonacciIterative(n);
        long end = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + ") = " + result);
        return end - start;
    }
    public static void main(String[] args) {
        int n = 30; // Change value to test (10, 30, 50)
        System.out.println("Fibonacci Performance Comparison");
        System.out.println("N = " + n);
        System.out.println("--------------------------------");
        long recursiveTime = measureRecursiveTime(n);
        long iterativeTime = measureIterativeTime(n);
        System.out.println("\nExecution Time (in nanoseconds)");
        System.out.println("Recursive Approach : " + recursiveTime + " ns");
        System.out.println("Iterative Approach : " + iterativeTime + " ns");
    }
}
