package category.leetcode._2024.november;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class November25th {

    public int slidingPuzzle(final int[][] board) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = 2;
        final int n = 3;
        final String goal = "123450";
        StringBuilder startSb = new StringBuilder();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                startSb.append((char) ('0' + board[i][j]));
            }
        }

        String start = startSb.toString();

        if (start.equals(goal)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>(List.of(start));
        Set<String> seen = new HashSet<>(Arrays.asList(start));

        for (int step = 1; !q.isEmpty(); ++step) {
            for (int size = q.size(); size > 0; --size) {
                String s = q.poll();
                int zeroIndex = s.indexOf("0");
                int i = zeroIndex / n;
                int j = zeroIndex % n;

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x < 0 || x == m || y < 0 || y == n) {
                        continue;
                    }

                    int swappedIndex = x * n + y;
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(zeroIndex, s.charAt(swappedIndex));
                    sb.setCharAt(swappedIndex, s.charAt(zeroIndex));
                    String t = sb.toString();

                    if (t.equals(goal)) {
                        return step;
                    }

                    if (!seen.contains(t)) {
                        q.offer(t);
                        seen.add(t);
                    }
                }
            }
        }

        return -1;
    }
}
