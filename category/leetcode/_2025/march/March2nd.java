package category.leetcode._2025.march;

import java.util.ArrayList;
import java.util.List;

public class March2nd {

    public int[][] mergeArrays(final int[][] nums1, final int[][] nums2) {
        final int kMax = 1000;
        List<int[]> ans = new ArrayList<>();
        int[] count = new int[kMax + 1];

        addCount(nums1, count);
        addCount(nums2, count);

        for (int i = 1; i <= kMax; ++i) {
            if (count[i] > 0) {
                ans.add(new int[]{i, count[i]});
            }
        }

        return ans.toArray(int[][]::new);
    }

    private void addCount(final int[][] nums, final int[] count) {
        for (int[] idAndVal : nums) {
            int id = idAndVal[0];
            int val = idAndVal[1];
            count[id] += val;
        }
    }
}
