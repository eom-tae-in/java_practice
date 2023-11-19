package category.leetcode.november;

public class November2nd {

    private int answer = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return answer;
    }

    private Node dfs(TreeNode node) {
        if (node == null) {
            return new Node(0, 0);
        }

        Node left = dfs(node.left);
        Node right = dfs(node.right);
        int count = 1 + left.getCount() + right.getCount();
        int sum = node.val + left.getSum() + right.getSum();

        if (sum / count == node.val) {
            answer++;
        }

        return new Node(count, sum);
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

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {
    private final int count;
    private final int sum;

    public Node(int count, int sum) {
        this.count = count;
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public int getSum() {
        return sum;
    }
}
