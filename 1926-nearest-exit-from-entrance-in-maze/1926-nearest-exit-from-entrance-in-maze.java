import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{entrance[0], entrance[1], 0});

        // Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int steps = current[2];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow < 0 || newRow >= m ||
                    newCol < 0 || newCol >= n) {
                    continue;
                }

                // Wall or already visited
                if (maze[newRow][newCol] == '+') {
                    continue;
                }

                // Check if this is an exit
                if (newRow == 0 || newRow == m - 1 ||
                    newCol == 0 || newCol == n - 1) {

                    return steps + 1;
                }

                // Mark visited and add to queue
                maze[newRow][newCol] = '+';

                queue.offer(new int[]{
                    newRow,
                    newCol,
                    steps + 1
                });
            }
        }

        return -1;
    }
}