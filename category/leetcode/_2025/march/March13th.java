package category.leetcode._2025.march;

public class March13th {

    public int minZeroArray(final int[] nums, final int[][] queries) {
        int[] line = new int[nums.length + 1];
        int decrement = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            while (decrement + line[i] < nums[i]) {
                if (k == queries.length) {
                    return -1;
                }

                int left = queries[k][0];
                int right = queries[k][1];
                int val = queries[k][2];
                k++;

                if (right < i) {
                    continue;
                }

                line[Math.max(left, i)] += val;
                line[right + 1] -= val;
            }

            decrement += line[i];
        }

        return k;
    }
}
