package category.leetcode._2025.december;

public class December10th {

    public int countPermutations(int[] complexity) {
        int required = complexity[0];
        long answer = 1;
        int count = 1;
        int mod = 1_000_000_007;

        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= required) {
                return 0;
            }

            answer = (answer * count++) % mod;
        }

        return (int) answer;
    }
}
