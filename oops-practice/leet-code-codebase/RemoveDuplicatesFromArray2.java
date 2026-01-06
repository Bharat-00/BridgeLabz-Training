class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; // index for placing valid elements
        for (int i = 0; i < nums.length; i++) {
            // Keep first two elements OR allow element if it differs from nums[k-2]
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
