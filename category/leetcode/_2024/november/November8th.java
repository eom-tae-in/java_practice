package category.leetcode._2024.november;

public class November8th {

    public int[] getMaximumXor(final int[] nums, final int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        int maxBit = (1 << maximumBit) - 1;
        int xors = 0;

        for (int i = 0; i < n; i++) {
            xors ^= nums[i];
            answer[(n - 1) - i] = xors ^ maxBit;
        }

        return answer;
    }
}
