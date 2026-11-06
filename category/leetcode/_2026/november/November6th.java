package category.leetcode._2026.november;

import java.util.Arrays;
import java.util.Comparator;

public class November6th {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));
        int[] answer = new int[m];
        int[] count = new int[n + 1];
        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] query : sortedQueries) {
            int time = query[0];
            int originalIndex = query[1];

            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];

                if (count[server]++ == 0) {
                    activeServers++;
                }

                right++;
            }

            while (left < right && logs[left][1] < time - x) {
                int server = logs[left][0];

                if (--count[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            answer[originalIndex] = n - activeServers;
        }

        return answer;
    }
}
