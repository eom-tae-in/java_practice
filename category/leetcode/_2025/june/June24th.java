package category.leetcode._2025.june;

import java.util.ArrayList;
import java.util.List;

public class June24th {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> answer = new ArrayList<>();
        int numsLength = nums.length;
        int r = 0;

        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == key) {
                int l = Math.max(r, i - k);
                r = Math.min(numsLength - 1, i + k) + 1;

                for (int j = l; j < r; j++) {
                    answer.add(j);
                }
            }
        }

        return answer;
    }
}
