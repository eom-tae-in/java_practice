package category.leetcode._2024.July;

import java.util.ArrayDeque;
import java.util.Deque;

public class July12th {

    public int maximumGain(final String s, final int x, final int y) {
        return (x > y) ? calculateMaxScore(s, "ab", x, "ba", y) : calculateMaxScore(s, "ba", y, "ab", x);
    }

    private int calculateMaxScore(final String s, final String max, final int maxNum, final String min,
                                  final int minNum) {
        Deque<Character> maxDeque = new ArrayDeque<>();
        Deque<Character> minDeque = new ArrayDeque<>();
        char maxCh1 = max.charAt(0);
        char maxCh2 = max.charAt(1);
        char minCh1 = min.charAt(0);
        char minCh2 = min.charAt(1);
        int score = 0;
        for (char ch : s.toCharArray()) {
            if (!maxDeque.isEmpty() && maxDeque.peekLast() == maxCh1 && ch == maxCh2) {
                maxDeque.pollLast();
                score += maxNum;
            } else {
                maxDeque.offerLast(ch);
            }
        }

        for (char ch : maxDeque) {
            if (!minDeque.isEmpty() && minDeque.peekLast() == minCh1 && ch == minCh2) {
                minDeque.pollLast();
                score += minNum;
            } else {
                minDeque.offerLast(ch);
            }
        }

        return score;
    }
}
