package category.leetcode.november;

import java.util.ArrayList;
import java.util.List;

public class November1st {

    private int currentFrequency = 0;
    private int maxFrequency = 0;
    private final List<Integer> list = new ArrayList<>();
    private TreeNode pred = null;


    public int[] findMode(TreeNode root) {
        dfs(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(final TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        change(node);
        dfs(node.right);
    }

    private void change(final TreeNode node) {
        if (pred != null && node.val == pred.val) {
            currentFrequency++;
        } else {
            currentFrequency = 1;
        }

        if (currentFrequency == maxFrequency) {
            list.add(node.val);
        }

        if (currentFrequency > maxFrequency) {
            maxFrequency = currentFrequency;
            list.clear();
            list.add(node.val);
        }

        pred = node;
    }
}
