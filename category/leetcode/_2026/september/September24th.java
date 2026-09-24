package category.leetcode._2026.september;

public class September24th {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = getDigitsSum(num);

            if (i == sum) {
                return i;
            }
        }

        return -1;
    }

    private int getDigitsSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
