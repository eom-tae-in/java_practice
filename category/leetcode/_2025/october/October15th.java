package category.leetcode._2025.october;

import java.util.List;

public class October15th {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int answer = 0;
        int increasing = 1;
        int prevIncreasing = 0;

        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                increasing++;
            } else {
                prevIncreasing = increasing;
                increasing = 1;
            }

            answer = Math.max(answer, increasing / 2);
            answer = Math.max(answer, Math.min(prevIncreasing, increasing));
        }

        return answer;
    }
}
