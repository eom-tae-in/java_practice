package category.leetcode._2024.July;

public class July30thh {

    public int minimumDeletions(final String s) {
        int dp = 0;
        int bCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                dp = Math.min(dp + 1, bCount);
            } else {
                bCount++;
            }
        }
        return dp;
    }
}
