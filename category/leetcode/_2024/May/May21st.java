package category.leetcode._2024.May;

import java.util.ArrayList;
import java.util.List;

public class May21st {

    public List<List<Integer>> subsets(final int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        int subsetCount = 1 << n;

        for (int i = 0; i < subsetCount; i++) {
            List<Integer> currentSubset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentSubset.add(nums[j]);
                }
            }
            answer.add(currentSubset);
        }

        return answer;
    }
}
