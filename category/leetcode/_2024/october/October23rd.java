package category.leetcode._2024.october;

import java.util.ArrayList;
import java.util.List;

public class October23rd {

    public TreeNode replaceValueInTree(final TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        dfs(root, 0, levelSums);

        return replace(root, 0, new TreeNode(0), levelSums);
    }

    private void dfs(final TreeNode root, final int level, final List<Integer> levelSums) {
        if (root == null) {
            return;
        }
        if (levelSums.size() == level) {
            levelSums.add(0);
        }
        levelSums.set(level, levelSums.get(level) + root.val);
        dfs(root.left, level + 1, levelSums);
        dfs(root.right, level + 1, levelSums);
    }

    private TreeNode replace(final TreeNode root, final int level, final TreeNode curr, final List<Integer> levelSums) {
        int nextLevel = level + 1;
        int nextLevelCousinsSum = nextLevel >= levelSums.size() ? 0 : levelSums.get(nextLevel) -
                (root.left == null ? 0 : root.left.val) -
                (root.right == null ? 0 : root.right.val);

        if (root.left != null) {
            curr.left = new TreeNode(nextLevelCousinsSum);
            replace(root.left, level + 1, curr.left, levelSums);
        }

        if (root.right != null) {
            curr.right = new TreeNode(nextLevelCousinsSum);
            replace(root.right, level + 1, curr.right, levelSums);
        }

        return curr;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(final int val) {
            this.val = val;
        }

        TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
