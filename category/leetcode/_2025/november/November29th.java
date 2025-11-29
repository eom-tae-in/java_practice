package category.leetcode._2025.november;

public class November29th {

    public int minOperations(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum % k;
    }
}
