package category.leetcode._2025.july;

import java.util.HashMap;
import java.util.Map;

public class July6th {

    class FindSumPairs {

        private final int[] nums1;
        private final int[] nums2;
        private final Map<Integer, Integer> map;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            map = new HashMap<>();

            for (int num2 : nums2) {
                map.merge(num2, 1, Integer::sum);
            }
        }

        public void add(int index, int val) {
            map.merge(nums2[index], -1, Integer::sum);
            nums2[index] += val;
            map.merge(nums2[index], 1, Integer::sum);
        }

        public int count(int tot) {
            int count = 0;

            for (int num1 : nums1) {
                count += map.getOrDefault(tot - num1, 0);
            }

            return count;
        }
    }
}
