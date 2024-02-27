package category.leetcode._2024.february;

public class February27th {

    private int answer = 0;

    public int diameterOfBinaryTree(final TreeNode root) {
        dfs(root);
        return answer;
    }

    private int dfs(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        answer = Math.max(answer, l + r);
        return 1 + Math.max(l, r);
    }
}
