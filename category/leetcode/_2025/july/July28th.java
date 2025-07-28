package category.leetcode._2025.july;

public class July28th {

    private int max = 0;
    private int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        backtrack(0, 0, nums);

        return count;
    }

    private void backtrack(int currentIndex, int orSum, int[] nums) {
        if (currentIndex == nums.length) {
            if (orSum > max) {
                max = orSum;
                count = 1;
            } else if (orSum == max) {
                count++;
            }

            return;
        }

        backtrack(currentIndex + 1, orSum | nums[currentIndex], nums);
        backtrack(currentIndex + 1, orSum, nums);
    }
}
