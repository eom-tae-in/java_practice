package category.leetcode._2024.april;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class April10th {

    public int[] deckRevealedIncreasing(final int[] deck) {
        final int n = deck.length;
        Arrays.sort(deck);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(deck[n - 1]);

        for (int i = n - 2; i >= 0; --i) {
            deque.addFirst(deque.getLast());
            deque.pollLast();
            deque.addFirst(deck[i]);
        }

        for (int i = 0; i < n; ++i) {
            deck[i] = deque.pollFirst();
        }

        return deck;
    }
}
