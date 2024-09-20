package category.leetcode._2024.july;

public class July18th {

    private int answer = 0;

    public int countPairs(final TreeNode root, final int distance) {
        dfs(root, distance);
        return answer;
    }

    private int[] dfs(final TreeNode root, final int distance) {
        int[] d = new int[distance + 1];
        if (root == null) {
            return d;
        }

        if (root.left == null && root.right == null) {
            d[0] = 1;
            return d;
        }

        int[] dl = dfs(root.left, distance);
        int[] dr = dfs(root.right, distance);
        for (int i = 0; i < distance; i++) {
            for (int j = 0; j < distance; j++) {
                if (i + j + 2 <= distance) {
                    answer += dl[i] * dr[j];
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < distance - 2; i++) {
            d[i + 1] = dl[i] + dr[i];
        }

        return d;
    }
}
