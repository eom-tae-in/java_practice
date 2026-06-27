package category.leetcode._2026.june;

import java.util.HashMap;
import java.util.Map;

public class June27th {

    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge((long) num, 1, Integer::sum);
        }

        int oneCount = map.getOrDefault(1L, 0);
        int answer = (oneCount & 1) == 1 ? oneCount : oneCount - 1;

        for (long key : map.keySet()) {
            if (key == 1L) {
                continue;
            }

            long curr = key;
            int cnt = 0;

            while (map.containsKey(curr) && map.get(curr) > 1) {
                cnt += 2;
                curr *= curr;
            }

            if (map.containsKey(curr)) {
                cnt += 1;
            } else {
                cnt -= 1;
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
