package category.leetcode._2025.august;

import java.util.HashMap;
import java.util.Map;

public class August8th {

    private final Map<String, Double> map = new HashMap<>();

    public double soupServings(int n) {
        return n > 5000 ? 1.0 : dfs((n + 24) / 25, (n + 24) / 25);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        } else if (a <= 0) {
            return 1.0;
        } else if (b <= 0) {
            return 0.0;
        }

        String key = a + "," + b;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        double result = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
        map.put(key, result);

        return result;
    }
}
