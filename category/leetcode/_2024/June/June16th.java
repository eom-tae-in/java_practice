package category.leetcode._2024.June;

public class June16th {

    public int minPatches(final int[] nums, final int n) {
        int answer = 0;
        int index = 0;
        long minimumNum = 1;
        while (minimumNum <= n) {
            if (index < nums.length && nums[index] <= minimumNum) {
                minimumNum += nums[index++];
            } else {
                minimumNum += minimumNum;
                answer++;
            }
        }

        return answer;
    }
}
