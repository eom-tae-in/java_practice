package category.leetcode._2024.december;

import java.util.PriorityQueue;
import java.util.Queue;

public class December17th {

    public String repeatLimitedString(final String s, final int repeatLimit) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[][] charCount = new int[26][2];

        for (char ch : s.toCharArray()) {
            charCount[ch - 'a'][0] = ch - 'a';
            charCount[ch - 'a'][1]++;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i][1] > 0) {
                queue.offer(charCount[i]);
            }
        }

        int prev = Integer.MIN_VALUE;
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == prev) {
                if (queue.isEmpty()) {
                    break;
                }

                int[] next = queue.poll();
                stringBuilder.append((char) (next[0] + 'a'));

                if (--next[1] > 0) {
                    queue.offer(next);
                }

                queue.offer(current);
                prev = next[0];
            } else {
                int loopCount = Math.min(current[1], repeatLimit);
                stringBuilder.append(String.valueOf((char) (current[0] + 'a'))
                        .repeat(loopCount));

                if (current[1] > loopCount) {
                    current[1] -= loopCount;
                    queue.offer(current);
                }

                prev = current[0];
            }
        }

        return stringBuilder.toString();
    }
}

