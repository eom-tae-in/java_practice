package category.leetcode._2024.july;

import java.util.Arrays;

public class July27th {

    public long minimumCost(final String source, final String target, final char[] original, final char[] changed,
                            final int[] cost) {
        int[][] graph = new int[26][26];
        Arrays.stream(graph)
                .forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        for (int i = 0; i < original.length; i++) {
            graph[original[i] - 'a'][changed[i] - 'a'] = Math.min(graph[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (graph[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (graph[k][j] < Integer.MAX_VALUE) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                char s = source.charAt(i);
                char t = target.charAt(i);
                if (graph[s - 'a'][t - 'a'] == Integer.MAX_VALUE) {
                    return -1;
                }
                answer += graph[s - 'a'][t - 'a'];
            }
        }

        return answer;
    }
}
