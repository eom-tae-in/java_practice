package category.leetcode._2024.March;

public class March30th {

    public int subarraysWithKDistinct(final int[] nums, final int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
    }

    private int subarraysWithAtMostKDistinct(int[] nums, int k) {
        int answer = 0;
        int[] count = new int[nums.length + 1];

        for (int left = 0, right = 0; right < nums.length; ++right) {
            if (++count[nums[right]] == 1) {
                --k;
            }
            while (k == -1) {
                if (--count[nums[left++]] == 0) {
                    ++k;
                }
            }
            answer += right - left + 1;
        }

        return answer;
    }
}
