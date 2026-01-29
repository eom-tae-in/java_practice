package category.leetcode._2026.january;

import java.util.Arrays;

public class January29th {

    private static final int INF = Integer.MAX_VALUE / 4;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        int n = original.length;

        for (int i = 0; i < n; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] < INF) {
                    for (int j = 0; j < 26; j++) {
                        if (dist[k][j] < INF) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }

        int strLen = source.length();
        long answer = 0;

        for (int i = 0; i < strLen; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if (dist[from][to] == INF) {
                return -1;
            }

            answer += dist[from][to];
        }

        return answer;
    }
}
