package category.leetcode._2026.february;

import java.util.HashSet;
import java.util.Set;

public class February10th {

    public int longestBalanced(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 1) {
                    odd.add(nums[j]);
                } else {
                    even.add(nums[j]);
                }

                if (odd.size() == even.size()) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        return answer;
    }
}
