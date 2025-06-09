package category.leetcode._2025.june;

public class June9th {

    public int findKthNumber(int n, int k) {
        int answer = 1;

        for (int i = 1; i < k; ) {
            int gap = getGap(answer, answer + 1, n);

            if (i + gap <= k) {
                i += gap;
                ++answer;
            } else {
                i++;
                answer *= 10;
            }
        }

        return answer;
    }

    private int getGap(long a, long b, int n) {
        int gap = 0;

        while (a <= n) {
            gap += (int) (Math.min(n + 1, b) - a);
            a *= 10;
            b *= 10;
        }

        return gap;
    }
}
