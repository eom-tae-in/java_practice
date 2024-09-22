package category.leetcode._2024.september;

public class September22nd {

    public int findKthNumber(final int n, final int k) {
        long answer = 1;
        for (int i = 1; i < k; ) {
            int gap = calculateGap(answer, answer + 1, n);
            if (i + gap <= k) {
                i += gap;
                ++answer;
            } else {
                ++i;
                answer *= 10;
            }
        }

        return (int) answer;
    }

    private int calculateGap(long a, long b, final int n) {
        int gap = 0;
        while (a <= n) {
            gap += (int) (Math.min(n + 1, b) - a);
            a *= 10;
            b *= 10;
        }

        return gap;
    }
}
