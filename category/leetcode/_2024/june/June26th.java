package category.leetcode._2024.june;

import java.util.ArrayList;
import java.util.List;

public class June26th {

    public TreeNode balanceBST(final TreeNode root) {
        List<Integer> list = new ArrayList<>();
        orderByAsc(root, list);
        return makeBalanceTree(list, 0, list.size() - 1);
    }

    private void orderByAsc(final TreeNode node, final List<Integer> list) {
        if (node == null) {
            return;
        }
        orderByAsc(node.left, list);
        list.add(node.val);
        orderByAsc(node.right, list);
    }

    private TreeNode makeBalanceTree(final List<Integer> list, final int left, final int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return new TreeNode(list.get(mid), makeBalanceTree(list, left, mid - 1),
                makeBalanceTree(list, mid + 1, right));
    }
}
