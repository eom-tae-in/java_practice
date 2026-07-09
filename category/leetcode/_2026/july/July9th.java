package category.leetcode._2026.july;

public class July9th {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int componentId = 0;
        component[0] = componentId;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                componentId++;
            }

            component[i] = componentId;
        }

        boolean[] answer = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = component[u] == component[v];
        }

        return answer;
    }
}
