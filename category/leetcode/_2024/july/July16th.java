package category.leetcode._2024.july;

public class July16th {

    private String startCase = "";
    private String destCase = "";

    public String getDirections(final TreeNode root, final int startValue, final int destValue) {
        TreeNode currentRoot = lca(root, startValue, destValue);
        dfs(currentRoot, startValue, destValue, new StringBuilder());

        return "U".repeat(startCase.length()) + destCase;
    }

    private TreeNode lca(final TreeNode root, final int startValue, final int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) {
            return root;
        }

        TreeNode left = lca(root.left, startValue, destValue);
        TreeNode right = lca(root.right, startValue, destValue);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    private void dfs(final TreeNode currentRoot, final int startValue, final int destValue,
                     final StringBuilder stringBuilder) {
        if (currentRoot == null) {
            return;
        }
        if (currentRoot.val == startValue) {
            startCase = stringBuilder.toString();
        }
        if (currentRoot.val == destValue) {
            destCase = stringBuilder.toString();
        }
        dfs(currentRoot.left, startValue, destValue, stringBuilder.append('L'));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        dfs(currentRoot.right, startValue, destValue, stringBuilder.append('R'));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
