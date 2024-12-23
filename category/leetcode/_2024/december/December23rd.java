package category.leetcode._2024.december;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class December23rd {

    public int minimumOperations(final TreeNode root) {
        int answer = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                values.add(treeNode.val);
            }

            List<Integer> valueIndices = new ArrayList<>();
            int valuesSize = values.size();

            for (int i = 0; i < valuesSize; i++) {
                valueIndices.add(i);
            }

            valueIndices.sort(Comparator.comparingInt(values::get));
            int valueIndicesSize = valueIndices.size();

            for (int i = 0; i < valueIndicesSize; i++) {
                while (valueIndices.get(i) != i) {
                    swap(valueIndices, i, valueIndices.get(i));
                    answer++;
                }
            }
        }

        return answer;
    }

    private void swap(final List<Integer> valueIndices, final int i, final int j) {
        int temp = valueIndices.get(i);
        valueIndices.set(i, valueIndices.get(j));
        valueIndices.set(j, temp);
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
