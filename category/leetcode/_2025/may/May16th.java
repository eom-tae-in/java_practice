package category.leetcode._2025.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class May16th {

    public List<String> getWordsInLongestSubsequence(final String[] words, final int[] groups) {
        List<String> answer = new ArrayList<>();
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        dp[0] = 1;
        Arrays.fill(prev, -1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] == groups[j]) {
                    continue;
                }

                if (words[i].length() != words[j].length()) {
                    continue;
                }

                if (calculateHammingDistance(words[i], words[j]) != 1) {
                    continue;
                }

                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxIndex = calculateMaxIndex(dp);

        while (maxIndex != -1) {
            answer.add(words[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(answer);
        return answer;
    }

    private int calculateHammingDistance(final String primary, final String secondary) {
        int loopCount = primary.length();
        int hammingDistance = 0;

        for (int i = 0; i < loopCount; i++) {
            if (primary.charAt(i) != secondary.charAt(i)) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

    private int calculateMaxIndex(final int[] dp) {
        int maxIndex = 0;

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
