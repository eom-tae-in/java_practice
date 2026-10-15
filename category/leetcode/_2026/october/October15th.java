package category.leetcode._2026.october;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class October15th {

    public int sumCounts(List<Integer> nums) {
        int answer = 0;
        int n = nums.size();

        for (int start = 0; start < n; start++) {
            Set<Integer> distinct = new HashSet<>();

            for (int end = start; end < n; end++) {
                distinct.add(nums.get(end));

                int count = distinct.size();
                answer += count * count;
            }
        }

        return answer;
    }
}
