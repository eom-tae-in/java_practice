package category.leetcode._2024.July;

import java.util.HashMap;
import java.util.Map;

public class July15th {

    public TreeNode createBinaryTree(final int[][] descriptions) {
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] description : descriptions) {
            int parentValue = description[0];
            int childValue = description[1];
            TreeNode parent = map.getOrDefault(parentValue, new TreeNode(description[0]));
            TreeNode child = map.getOrDefault(childValue, new TreeNode(description[1]));
            map.put(parentValue, parent);
            map.put(childValue, child);
            childToParent.put(child, parent);

            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        TreeNode node = childToParent.keySet().iterator().next();
        while (childToParent.containsKey(node)) {
            node = childToParent.get(node);
        }

        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(final int val, final TreeNode left, final TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
