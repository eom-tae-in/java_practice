package category.leetcode._2025.december;

import java.util.HashMap;
import java.util.Map;

public class December2nd {

    private static final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] point : points) {
            map.merge(point[1], 1, Integer::sum);
        }

        long answer = 0;
        long sum = 0;

        for (int cnt : map.values()) {
            long curr = cnt * (cnt - 1L) / 2;
            answer += sum * curr;
            sum += curr;
        }

        return (int) (answer % MOD);
    }
}
