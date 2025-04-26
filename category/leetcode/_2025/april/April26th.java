package category.leetcode._2025.april;

public class April26th {

    public long countSubarrays(final int[] nums, final int minK, final int maxK) {
        long answer = 0;
        int j = -1;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (current < minK || maxK < current) {
                j = i;
            }

            if (current == minK) {
                minIndex = i;
            }

            if (current == maxK) {
                maxIndex = i;
            }

            answer += Math.max(0, Math.min(minIndex, maxIndex) - j);
        }

        return answer;
    }
}
