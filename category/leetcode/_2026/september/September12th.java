package category.leetcode._2026.september;

import java.util.Arrays;
import java.util.List;

public class September12th {

    private Interval[] intervals;
    private int[] nextIndex;
    private State[][] memo;
    private boolean[][] visited;

    public int[] maximumWeight(List<List<Integer>> intervalsInput) {
        int n = intervalsInput.size();
        intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervalsInput.get(i);
            intervals[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }

            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }

            return Integer.compare(a.originalIndex, b.originalIndex);
        });

        nextIndex = new int[n];

        for (int i = 0; i < n; i++) {
            nextIndex[i] = findNextInterval(intervals[i].end);
        }

        memo = new State[n + 1][5];
        visited = new boolean[n + 1][5];

        return solve(0, 0).indices;
    }

    private State solve(int index, int selectedCount) {
        if (index >= intervals.length || selectedCount == 4) {
            return new State(0L, new int[0]);
        }

        if (visited[index][selectedCount]) {
            return memo[index][selectedCount];
        }

        visited[index][selectedCount] = true;
        State skip = solve(index + 1, selectedCount);
        State next = solve(nextIndex[index], selectedCount + 1);
        int[] selectedIndices = new int[next.indices.length + 1];
        selectedIndices[0] = intervals[index].originalIndex;
        System.arraycopy(next.indices, 0, selectedIndices, 1, next.indices.length);
        Arrays.sort(selectedIndices);
        State take = new State(intervals[index].score + next.score, selectedIndices);
        memo[index][selectedCount] = better(take, skip);

        return memo[index][selectedCount];
    }

    private State better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return compareLexicographically(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compareLexicographically(int[] a, int[] b) {
        int length = Math.min(a.length, b.length);

        for (int i = 0; i < length; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }

    private int findNextInterval(int currentEnd) {
        int left = 0;
        int right = intervals.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (intervals[mid].start > currentEnd) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static class Interval {

        private final int start;
        private final int end;
        private final int score;
        private final int originalIndex;

        private Interval(int start, int end, int score, int originalIndex) {
            this.start = start;
            this.end = end;
            this.score = score;
            this.originalIndex = originalIndex;
        }
    }

    private static class State {

        private final long score;
        private final int[] indices;

        private State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }
}
