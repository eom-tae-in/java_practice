package category.leetcode._2026.october;

import java.util.ArrayList;
import java.util.List;

public class October18th {

    private static final long MOD = 1_000_000_007L;
    private long[][] combination;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        combination = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            combination[i][0] = combination[i][i] = 1;

            for (int j = 1; j < i; j++) {
                combination[i][j] = (combination[i - 1][j - 1] + combination[i - 1][j]) % MOD;
            }
        }

        List<Integer> values = new ArrayList<>(n);
        for (int num : nums) {
            values.add(num);
        }

        return (int) ((countWays(values) - 1 + MOD) % MOD);
    }

    private long countWays(List<Integer> values) {
        if (values.size() <= 2) {
            return 1;
        }

        int root = values.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < values.size(); i++) {
            int value = values.get(i);

            if (value < root) {
                left.add(value);
            } else {
                right.add(value);
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);
        long ways = combination[values.size() - 1][left.size()];
        ways = ways * leftWays % MOD;
        ways = ways * rightWays % MOD;

        return ways;
    }
}
