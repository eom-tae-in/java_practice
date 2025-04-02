package category.leetcode._2025.april;

public class April2nd {

    public long maximumTripletValue(final int[] nums) {
        long answer = 0;
        int maxDiff = 0;
        int maxNum = 0;

        for (int num : nums) {
            answer = Math.max(answer, (long) maxDiff * num);
            maxDiff = Math.max(maxDiff, maxNum - num);
            maxNum = Math.max(maxNum, num);
        }

        return answer;
    }
}
