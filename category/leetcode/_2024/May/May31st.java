package category.leetcode._2024.May;

public class May31st {

    public int[] singleNumber(final int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }

        int value = xorSum & (-xorSum);
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & value) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}
