package category.leetcode._2026.february;

public class February7th {

    public int minimumDeletions(String s) {
        int dp = 0;
        int countB = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                dp = Math.min(dp + 1, countB);
            } else {
                countB++;
            }
        }

        return dp;
    }
}
