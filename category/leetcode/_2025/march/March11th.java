package category.leetcode._2025.march;

import java.util.Arrays;

public class March11th {

    public int numberOfSubstrings(final String s) {
        int[] charsCount = new int[3];
        Arrays.fill(charsCount, -1);
        int answer = 0;
        int index = 0;

        for (char ch : s.toCharArray()) {
            charsCount[ch - 'a'] = index++;

            if (charsCount[0] != -1 && charsCount[1] != -1 && charsCount[2] != -1) {
                answer += Math.min(charsCount[0], Math.min(charsCount[1], charsCount[2])) + 1;
            }
        }

        return answer;
    }
}
