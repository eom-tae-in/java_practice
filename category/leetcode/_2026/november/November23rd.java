package category.leetcode._2026.november;

public class November23rd {

    static class ProductOfNumbers {

        private final int[] prefix = new int[40_001];
        private int size;

        public ProductOfNumbers() {
            prefix[0] = 1;
        }

        public void add(int num) {
            if (num == 0) {
                size = 0;
                return;
            }

            prefix[size + 1] = prefix[size] * num;
            size++;
        }

        public int getProduct(int k) {
            if (k > size) {
                return 0;
            }

            return prefix[size] / prefix[size - k];
        }
    }
}
