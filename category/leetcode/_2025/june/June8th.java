package category.leetcode._2025.june;

import java.util.ArrayList;
import java.util.List;

public class June8th {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(i, n, answer);
        }

        return answer;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }

        result.add(current);

        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i;

            if (next > n) {
                return;
            }

            dfs(next, n, result);
        }
    }
}
