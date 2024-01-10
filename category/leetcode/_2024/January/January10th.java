package category.leetcode._2024.January;

public class January10th {

    private int answer;

    public int amountOfTime(final TreeNode treeNode, final int start) {
        dfs(treeNode, start);
        return answer;
    }

    private int dfs(final TreeNode node, final int start) {
        if (node == null) {
            return 0;
        }

        final int leftLength = dfs(node.left, start);
        final int rightLength = dfs(node.right, start);

        if (node.val == start) {
            answer = Math.max(leftLength, rightLength);
            return -1;
        }

        if (leftLength >= 0 && rightLength >= 0) {
            return Math.max(leftLength, rightLength) + 1;
        } else {
            answer = Math.max(answer, Math.abs(leftLength - rightLength));
            return Math.min(leftLength, rightLength) - 1;
        }
    }
}
