package category.leetcode._2025.february;

import java.util.HashMap;
import java.util.Map;

public class February23rd {

    public TreeNode constructFromPrePost(final int[] pre, final int[] post) {
        Map<Integer, Integer> postToIndex = new HashMap<>();

        for (int i = 0; i < post.length; ++i) {
            postToIndex.put(post[i], i);
        }

        return build(pre, 0, pre.length - 1, post, 0, post.length - 1, postToIndex);
    }

    private TreeNode build(
            final int[] pre,
            final int preStart,
            final int preEnd,
            final int[] post,
            final int postStart,
            final int postEnd,
            final Map<Integer, Integer> postToIndex
    ) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        int rootVal = pre[preStart];
        int leftRootVal = pre[preStart + 1];
        int leftRootPostIndex = postToIndex.get(leftRootVal);
        int leftSize = leftRootPostIndex - postStart + 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(pre, preStart + 1, preStart + leftSize, post, postStart, leftRootPostIndex, postToIndex);
        root.right = build(pre, preStart + leftSize + 1, preEnd, post, leftRootPostIndex + 1, postEnd - 1, postToIndex);

        return root;
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
