package category.leetcode._2025.may;

public class May20th {

    public boolean isZeroArray(final int[] nums, final int[][] queries) {
        int numsLength = nums.length;
        int[] line = new int[numsLength + 1];
        int decrement = 0;

        for (int[] query : queries) {
            line[query[0]]++;
            line[query[1] + 1]--;
        }

        for (int i = 0; i < numsLength; i++) {
            decrement += line[i];

            if (decrement < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
