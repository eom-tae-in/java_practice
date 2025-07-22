package category.leetcode._2025.july;

import java.util.HashSet;
import java.util.Set;

public class July22nd {

    public int maximumUniqueSubarray(int[] nums) {
        int answer = 0;
        int numsLength = nums.length;
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int left = 0, right = 0; right < numsLength; right++) {
            int current = nums[right];

            while (set.contains(current)) {
                int prev = nums[left++];
                set.remove(prev);
                sum -= prev;
            }

            set.add(current);
            sum += current;
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
