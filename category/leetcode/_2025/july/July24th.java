package category.leetcode._2025.july;

import java.util.ArrayList;
import java.util.List;

public class July24th {

    public int minimumScore(int[] nums, int[][] edges) {
        int numsLength = nums.length;
        List<Integer>[] graph = new List[numsLength];

        for (int i = 0; i < numsLength; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] in = new int[numsLength];
        int[] out = new int[numsLength];
        int[] sum = new int[numsLength];
        int[] count = {0};

        dfs(0, -1, in, out, sum, count, nums, graph);
        int answer = Integer.MAX_VALUE;
        int total = sum[0];

        for (int i = 1; i < numsLength; i++) {
            for (int j = i + 1; j < numsLength; j++) {
                if (in[i] < in[j] && out[i] > in[j]) {
                    answer = Math.min(answer, calc(total ^ sum[i], sum[i] ^ sum[j], sum[j]));
                } else if (in[j] < in[i] && out[j] > in[i]) {
                    answer = Math.min(answer, calc(total ^ sum[j], sum[j] ^ sum[i], sum[i]));
                } else {
                    answer = Math.min(answer, calc(total ^ sum[i] ^ sum[j], sum[i], sum[j]));
                }
            }
        }

        return answer;
    }

    private int calc(int primary, int secondary, int third) {
        return Math.max(primary, Math.max(secondary, third)) - Math.min(primary, Math.min(secondary, third));
    }

    private void dfs(
            int current,
            int prev,
            int[] in,
            int[] out,
            int[] sum,
            int[] count,
            int[] nums,
            List<Integer>[] graph
    ) {
        sum[current] = nums[current];
        in[current] = count[0]++;

        for (int next : graph[current]) {
            if (next == prev) {
                continue;
            }

            dfs(next, current, in, out, sum, count, nums, graph);
            sum[current] ^= sum[next];
        }

        out[current] = count[0];
    }
}
