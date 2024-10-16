package category.leetcode._2024.october;

import java.util.PriorityQueue;

public class October16th {

    public String longestDiverseString(final int a, final int b, final int c) {
        StringBuilder stringBuilder = new StringBuilder();
        PriorityQueue<CharInfo> queue = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) {
            queue.offer(new CharInfo('a', a));
        }

        if (b > 0) {
            queue.offer(new CharInfo('b', b));
        }

        if (c > 0) {
            queue.offer(new CharInfo('c', c));
        }

        while (!queue.isEmpty()) {
            CharInfo primary = queue.poll();
            if (isSecondaryCharUseCase(stringBuilder, primary.ch)) {
                if (queue.isEmpty()) {
                    break;
                }
                CharInfo secondary = queue.poll();
                stringBuilder.append(secondary.ch);
                if (secondary.count - 1 > 0) {
                    queue.offer(new CharInfo(secondary.ch, secondary.count - 1));
                }
                queue.offer(new CharInfo(primary.ch, primary.count));
            } else {
                stringBuilder.append(primary.ch);
                if (primary.count - 1 > 0) {
                    queue.offer(new CharInfo(primary.ch, primary.count - 1));
                }
            }
        }

        return stringBuilder.toString();
    }

    private static boolean isSecondaryCharUseCase(final StringBuilder stringBuilder, final char ch) {
        return stringBuilder.length() >= 2 &&
                stringBuilder.charAt(stringBuilder.length() - 1) == ch &&
                stringBuilder.charAt(stringBuilder.length() - 2) == ch;
    }

    private record CharInfo(
            char ch,
            int count
    ) {
    }
}
