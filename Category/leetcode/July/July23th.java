package Category.leetcode.July;

import java.util.ArrayList;
import java.util.List;

public class July23th {
    class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(final int val) {
            this.val = val;
        }

        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<TreeNode> allPossibleFBT(final int n) {
            List<TreeNode>[] treeNodes = new ArrayList[n + 1];
            return DFS(treeNodes, n);
        }

        private List<TreeNode> DFS(final List<TreeNode>[] treeNodes, final int n) {

            if (treeNodes[n] != null) {
                return treeNodes[n];
            }
            List<TreeNode> treeNode = new ArrayList<>();
            if (n == 1) {
                treeNode.add(new TreeNode(0));
                return treeNode;
            }
            if (n % 2 == 0) {
                return treeNode;
            }

            for (int i = 2; i < n; i += 2) {
                List<TreeNode> leftNodes = DFS(treeNodes, i - 1);
                List<TreeNode> rightNodes = DFS(treeNodes, n - i);
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        treeNode.add(new TreeNode(0, leftNode, rightNode));
                    }
                }
            }
            return treeNodes[n] = treeNode;
        }
    }
}
