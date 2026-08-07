import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {

                int top = stack.peek();

                if (Math.abs(top) < Math.abs(asteroid)) {
                    // Right-moving asteroid is smaller
                    stack.pop();
                } 
                else if (Math.abs(top) == Math.abs(asteroid)) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    // Current asteroid is smaller
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}