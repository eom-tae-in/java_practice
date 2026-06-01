package category.leetcode._2026.june;

import java.util.Arrays;

public class June1st {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int answer = 0;
        int idx = cost.length - 1;

        while (idx > 1) {
            answer += cost[idx--];
            answer += cost[idx--];
            idx--;
        }

        while (idx >= 0) {
            answer += cost[idx--];
        }

        return answer;
    }
}
