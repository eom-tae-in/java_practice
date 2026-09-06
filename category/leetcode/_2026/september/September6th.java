package category.leetcode._2026.september;

public class September6th {

    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;

        for (char source : s.toCharArray()) {
            for (int j = t.length(); j >= 1; j--) {
                if (source == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[t.length()];
    }
}
