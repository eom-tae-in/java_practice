package category.leetcode._2024.december;

public class December10th {

    public int maximumLength(final String s) {
        final int n = s.length();
        int ans = -1;
        int runningLen = 0;
        char prevLetter = '@';
        int[][] counts = new int[26][n + 1];

        for (char c : s.toCharArray()) {
            if (c == prevLetter) {
                ++counts[c - 'a'][++runningLen];
            } else {
                runningLen = 1;
                ++counts[c - 'a'][runningLen];
                prevLetter = c;
            }
        }

        for (int[] count : counts) {
            ans = Math.max(ans, getMaxFreq(count, n));
        }

        return ans;
    }

    private int getMaxFreq(final int[] count, final int maxFreq) {
        int times = 0;

        for (int freq = maxFreq; freq >= 1; freq--) {
            times += count[freq];

            if (times >= 3) {
                return freq;
            }
        }

        return -1;
    }
}
