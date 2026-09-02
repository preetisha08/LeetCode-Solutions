import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        // Store {nums2[i], nums1[i]}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = nums1[i];
        }

        // Sort according to nums2 in descending order
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sum = 0;
        long maxScore = 0;

        for (int i = 0; i < n; i++) {

            int num2 = arr[i][0];
            int num1 = arr[i][1];

            // Add nums1 value
            minHeap.offer(num1);
            sum += num1;

            // Keep only k largest nums1 values
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // Once we have k elements
            if (minHeap.size() == k) {
                long score = sum * num2;
                maxScore = Math.max(maxScore, score);
            }
        }

        return maxScore;
    }
}