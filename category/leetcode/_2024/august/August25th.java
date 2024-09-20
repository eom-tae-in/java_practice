package category.leetcode._2024.august;

import java.util.ArrayList;
import java.util.List;

public class August25th {

    public List<Integer> postorderTraversal(final TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);

        return ans;
    }

    private void postorder(final TreeNode root, final List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}


class TreeNode {
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
