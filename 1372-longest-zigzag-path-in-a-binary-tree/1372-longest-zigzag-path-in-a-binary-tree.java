class Solution {

    int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{-1, -1};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // If we move left, next move must be right
        int goLeft = left[1] + 1;

        // If we move right, next move must be left
        int goRight = right[0] + 1;

        maxLength = Math.max(maxLength, Math.max(goLeft, goRight));

        return new int[]{goLeft, goRight};
    }
}