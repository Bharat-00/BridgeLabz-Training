class Solution {
    // Helper method to calculate sum of squares of digits
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = getNext(slow);           // move one step
            fast = getNext(getNext(fast));  // move two steps
        } while (slow != fast);
        return slow == 1;
    }
}
