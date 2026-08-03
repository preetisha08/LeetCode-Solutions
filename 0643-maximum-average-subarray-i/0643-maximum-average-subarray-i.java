class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int windowSum = 0;

        // Calculate first window sum
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}