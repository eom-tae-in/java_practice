package category.leetcode._2024.november;

public class November26th {

    public int findChampion(final int n, final int[][] edges) {
        int answer = -1;
        int count = 0;
        int[] inDegrees = new int[n];

        for (int[] edge : edges) {
            final int v = edge[1];
            ++inDegrees[v];
        }

        for (int i = 0; i < n; ++i)
            if (inDegrees[i] == 0) {
                ++count;
                answer = i;
            }

        return count > 1 ? -1 : answer;
    }
}
