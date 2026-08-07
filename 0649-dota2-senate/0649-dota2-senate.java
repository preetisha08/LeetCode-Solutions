import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Store indices of each party
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {
                // Radiant bans Dire senator
                radiant.offer(rIndex + n);
            } else {
                // Dire bans Radiant senator
                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}