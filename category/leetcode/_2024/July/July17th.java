package category.leetcode._2024.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class July17th {

    public List<TreeNode> delNodes(final TreeNode root, final int[] to_delete) {
        Set<Integer> deleteNodes = Arrays.stream(to_delete)
                .boxed()
                .collect(Collectors.toSet());
        List<TreeNode> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        dfs(root, deleteNodes, answer);
        if (!deleteNodes.contains(root.val)) {
            answer.add(root);
        }

        return answer;
    }

    private TreeNode dfs(final TreeNode root, final Set<Integer> deleteNodes, final List<TreeNode> answer) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left, deleteNodes, answer);
        TreeNode right = dfs(root.right, deleteNodes, answer);
        if (deleteNodes.contains(root.val)) {
            if (left != null) {
                answer.add(left);
            }
            if (right != null) {
                answer.add(right);
            }
            return null;
        }
        root.left = left;
        root.right = right;

        return root;
    }
}
