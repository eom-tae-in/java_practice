package category.leetcode._2024.december;

public class December9th {

    public boolean[] isArraySpecial(final int[] nums, final int[][] queries) {
        int paritySum = 0;
        int numsLength = nums.length;
        int[] parities = new int[numsLength];
        int queriesLength = queries.length;
        boolean[] answers = new boolean[queriesLength];
        int prevResult = nums[0] % 2;
        parities[0] = 0;

        for (int i = 1; i < numsLength; i++) {
            int currentResult = nums[i] % 2;

            if (prevResult == currentResult) {
                paritySum++;
            }

            parities[i] = paritySum;
            prevResult = currentResult;
        }

        for (int i = 0; i < queriesLength; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];

            if (parities[startIndex] == parities[endIndex]) {
                answers[i] = true;
            }
        }

        return answers;
    }
}
