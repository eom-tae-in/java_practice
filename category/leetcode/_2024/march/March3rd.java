package category.leetcode._2024.march;

import java.util.Arrays;

public class March3rd {

    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0;
        int j = tokens.length - 1;
        int score = 0;
        int answer = 0;
        Arrays.sort(tokens);

        while (i <= j && (power >= tokens[i] || score > 0)) {
            while (i <= j && power >= tokens[i]) {
                // Play the smallest face up.
                power -= tokens[i++];
                ++score;
            }
            answer = Math.max(answer, score);
            if (i <= j && score > 0) {
                // Play the largest face down.
                power += tokens[j--];
                --score;
            }
        }

        return answer;
    }
}
