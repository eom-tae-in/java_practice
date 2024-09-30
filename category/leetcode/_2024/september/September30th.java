package category.leetcode._2024.september;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class September30th {

    private static class CustomStack {
        private final int maxSize;
        private final Deque<Integer> stack = new ArrayDeque<>();
        private final List<Integer> pendingIncrements = new ArrayList<>();

        public CustomStack(final int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(final int x) {
            if (stack.size() == maxSize) {
                return;
            }
            stack.push(x);
            pendingIncrements.add(0);
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            final int i = stack.size() - 1;
            final int pendingIncrement = pendingIncrements.get(i);
            pendingIncrements.remove(i);
            if (i > 0) {
                pendingIncrements.set(i - 1, pendingIncrements.get(i - 1) + pendingIncrement);
            }

            return stack.pop() + pendingIncrement;
        }

        public void increment(final int k, final int val) {
            if (stack.isEmpty()) {
                return;
            }
            final int i = Math.min(k - 1, stack.size() - 1);
            pendingIncrements.set(i, pendingIncrements.get(i) + val);
        }
    }
}
