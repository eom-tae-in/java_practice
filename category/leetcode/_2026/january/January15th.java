package category.leetcode._2026.january;

import java.util.Arrays;

public class January15th {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = getLength(m, vBars);
        int w = getLength(n, hBars);
        int minSide = Math.min(h, w);

        return minSide * minSide;
    }

    private int getLength(int x, int[] bars) {
        int len = bars.length;

        if (x == len) {
            return len + 1;
        }

        Arrays.sort(bars);
        int currLen = 1;
        int maxLen = 1;

        for (int i = 0; i < len - 1; i++) {
            if (bars[i] + 1 == bars[i + 1]) {
                currLen++;
            } else {
                currLen = 1;
            }

            maxLen = Math.max(currLen, maxLen);
        }

        return maxLen + 1;
    }
}
