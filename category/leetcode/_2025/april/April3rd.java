package category.leetcode._2025.april;

public class April3rd {

    public long maximumTripletValue(final int[] nums) {
        long maxDiff = 0;
        long maxNum = 0;
        long answer = 0;

        for (int num : nums) {
            answer = Math.max(answer, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxNum - num);
            maxNum = Math.max(maxNum, num);
        }

        return answer;
    }
}
