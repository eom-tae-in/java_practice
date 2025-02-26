package category.leetcode._2025.february;

public class February26th {

    public int maxAbsoluteSum(final int[] nums) {
        int maxValue = 0;
        int max = 0;
        int minValue = 0;
        int min = 0;

        for (int num : nums) {
            max += num;
            min += num;

            if (max < 0) {
                max = 0;
            }

            if (min > 0) {
                min = 0;
            }

            maxValue = Math.max(maxValue, max);
            minValue = Math.min(minValue, min);
        }

        return Math.max(maxValue, -minValue);
    }
}
