package category.leetcode._2025.february;

import java.util.ArrayList;
import java.util.List;

public class February14th {

    private static class ProductOfNumbers {

        private List<Integer> nums;

        public ProductOfNumbers() {
            nums = new ArrayList<>(List.of(1));
        }

        public void add(final int num) {
            if (num == 0) {
                nums = new ArrayList<>(List.of(1));
            } else {
                nums.add(nums.get(nums.size() - 1) * num);
            }
        }

        public int getProduct(final int k) {
            int size = nums.size();
            return k >= size ? 0 : nums.get(size - 1) / nums.get(size - 1 - k);
        }
    }
}
