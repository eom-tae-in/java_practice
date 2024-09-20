package category.leetcode._2024.may;

public class May18th {

    private int answer = 0;

    public int distributeCoins(final TreeNode root) {
        dfs(root);
        return answer;
    }

    private int dfs(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        answer += Math.abs(left) + Math.abs(right);
        return (root.val - 1) + left + right;
    }
}
