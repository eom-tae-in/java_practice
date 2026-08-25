package category.leetcode._2026.august;

public class August25th {

    private static final int MAX = 100;

    public int missingMultiple(int[] nums, int k) {
        int[] count = new int[MAX + 1];

        for (int num : nums) {
            count[num]++;
        }

        int curr = k;

        while (curr <= MAX) {
            if (count[curr] == 0) {
                return curr;
            }

            curr += k;
        }

        return curr;
    }
}
