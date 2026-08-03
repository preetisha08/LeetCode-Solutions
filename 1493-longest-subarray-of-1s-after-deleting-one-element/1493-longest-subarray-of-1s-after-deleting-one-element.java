class Solution {
    public int longestSubarray(int[] nums) {

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeros++;
            }

            // More than one zero, shrink window
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Delete one element from the window
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}