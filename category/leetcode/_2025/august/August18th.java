package category.leetcode._2025.august;

import java.util.ArrayList;
import java.util.List;

public class August18th {

    public boolean judgePoint24(int[] nums) {
        List<Double> doubleNums = new ArrayList<>();

        for (final int num : nums) {
            doubleNums.add((double) num);
        }

        return dfs(doubleNums);
    }

    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < 0.001;
        }

        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                for (double num : generate(nums.get(i), nums.get(j))) {
                    List<Double> nextRound = new ArrayList<>(List.of(num));

                    for (int k = 0; k < nums.size(); ++k) {
                        if (k == i || k == j) {
                            continue;
                        }

                        nextRound.add(nums.get(k));
                    }

                    if (dfs(nextRound)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private double[] generate(double a, double b) {
        return new double[]{a * b, a / b, b / a, a + b, a - b, b - a};
    }
}
