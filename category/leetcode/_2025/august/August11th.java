package category.leetcode._2025.august;

import java.util.ArrayList;
import java.util.List;

public class August11th {

    public int[] productQueries(int n, int[][] queries) {
        int mod = 1_000_000_007;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            if ((n >> i & 1) == 1) {
                list.add(1 << i);
            }
        }

        int queriesLength = queries.length;
        int[] answer = new int[queriesLength];

        for (int i = 0; i < queriesLength; i++) {
            long current = 1;
            int start = queries[i][0];
            int end = queries[i][1];

            for (int j = start; j <= end; j++) {
                current = (current * list.get(j)) % mod;
            }

            answer[i] = (int) current;
        }

        return answer;
    }
}
