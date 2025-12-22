package category.leetcode._2025.december;

import java.util.Arrays;

public class December22nd {

    public int minDeletionSize(String[] strs) {
        int k = strs[0].length();
        int[] dp = new int[k];
        Arrays.fill(dp, 1);

        for (int i = 1; i < k; ++i) {
            for (int j = 0; j < i; ++j) {
                if (isSorted(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return k - Arrays.stream(dp).max().getAsInt();
    }

    private boolean isSorted(String[] strs, int j, int i) {
        for (String s : strs) {
            if (s.charAt(j) > s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
