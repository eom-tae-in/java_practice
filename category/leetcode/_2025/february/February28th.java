package category.leetcode._2025.february;

public class February28th {

    public String shortestCommonSupersequence(final String str1, final String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int str1Index = 0;
        int str2Index = 0;

        for (char ch : getLCS(str1, str2).toCharArray()) {
            while (str1.charAt(str1Index) != ch) {
                stringBuilder.append(str1.charAt(str1Index++));
            }

            while (str2.charAt(str2Index) != ch) {
                stringBuilder.append(str2.charAt(str2Index++));
            }

            stringBuilder.append(ch);
            str1Index++;
            str2Index++;
        }

        return stringBuilder.append(str1.substring(str1Index))
                .append(str2.substring(str2Index))
                .toString();
    }

    private String getLCS(final String str1, final String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();
        int[][] dp = new int[str1Length + 1][str2Length + 1];

        for (int i = 1; i <= str1Length; i++) {
            for (int j = 1; j <= str2Length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int str1Index = str1Length;
        int str2Index = str2Length;
        StringBuilder stringBuilder = new StringBuilder();

        while (str1Index > 0 && str2Index > 0) {
            if (str1.charAt(str1Index - 1) == str2.charAt(str2Index - 1)) {
                stringBuilder.append(str1.charAt(str1Index - 1));
                str1Index--;
                str2Index--;
            } else if (dp[str1Index - 1][str2Index] > dp[str1Index][str2Index - 1]) {
                str1Index--;
            } else {
                str2Index--;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
