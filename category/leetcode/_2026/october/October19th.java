package category.leetcode._2026.october;

import java.util.ArrayList;
import java.util.List;

public class October19th {

    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0;
        int count = 0;

        for (int num : nums) {
            if (num < target) {
                less++;
            } else if (num == target) {
                count++;
            }
        }

        List<Integer> answer = new ArrayList<>(count);

        for (int i = less; i < less + count; i++) {
            answer.add(i);
        }

        return answer;
    }
}
