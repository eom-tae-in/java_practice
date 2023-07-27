package Category.leetcode;

public class July27rd {
    public long maxRunTime(final int n, final int[] batteries) {
        long start = 0;
        long end = 0;
        long ans = 0;

        for (int battery : batteries) {
            end += battery;
        }

        while (start <= end) {
            long mid = (start + end) >> 1;
            if (isPossibleToRun(n, batteries, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossibleToRun(final int n, final int[] batteries, final long average) {
        long sum = 0;
        for (int battery : batteries) {
            sum += Math.min(battery, average);
        }
        return (n * average) <= sum;
    }
}
