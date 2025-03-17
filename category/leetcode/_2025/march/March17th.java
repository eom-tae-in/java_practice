package category.leetcode._2025.march;

public class March17th {

    public boolean divideArray(final int[] nums) {
        int[] numsCount = new int[501];
        int count = 0;

        for (int num : nums) {
            if (++numsCount[num] == 2) {
                count += 2;
                numsCount[num] = 0;
            }
        }

        return count == nums.length;
    }
}
