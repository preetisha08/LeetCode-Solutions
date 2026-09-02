import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        int n = costs.length;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0;
        int j = n - 1;

        // Add first candidates
        while (i <= j && left.size() < candidates) {
            left.offer(costs[i]);
            i++;
        }

        // Add last candidates
        while (i <= j && right.size() < candidates) {
            right.offer(costs[j]);
            j--;
        }

        long total = 0;

        for (int session = 0; session < k; session++) {

            if (right.isEmpty() || 
                (!left.isEmpty() && left.peek() <= right.peek())) {

                total += left.poll();

                // Add next worker from the left
                if (i <= j) {
                    left.offer(costs[i]);
                    i++;
                }

            } else {

                total += right.poll();

                // Add next worker from the right
                if (i <= j) {
                    right.offer(costs[j]);
                    j--;
                }
            }
        }

        return total;
    }
}