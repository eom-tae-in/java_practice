package category.leetcode._2025.july;

public class July29th {

    public int[] smallestSubarrays(int[] nums) {
        int numsLength = nums.length;
        int[] distance = new int[numsLength];

        for (int i = 0; i < numsLength; i++) {
            distance[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | nums[i]) == nums[j]) {
                    break;
                }

                nums[j] |= nums[i];
                distance[j] = i - j + 1;
            }
        }

        return distance;
    }
}
