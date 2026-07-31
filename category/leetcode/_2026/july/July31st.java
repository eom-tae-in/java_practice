package category.leetcode._2026.july;

import java.util.Arrays;

public class July31st {

    public int minimumPushes(String word) {
        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        Arrays.sort(count);
        int order = 1;
        int remainder = 0;
        int answer = 0;

        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }

            if (remainder == 8) {
                order++;
                remainder = 0;
            }

            answer += order * count[i];
            remainder++;
        }

        return answer;
    }
}
