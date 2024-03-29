package category.leetcode._2024.March;

import java.util.Arrays;

public class March29th {

    public long countSubarrays(int[] nums, int k) {
        long answer = 0;
        int count = 0;
        int maxNumber = Arrays.stream(nums)
                .max()
                .getAsInt();

        for (int l = 0, r = 0; r < nums.length; ++r) {
            if (nums[r] == maxNumber)
                ++count;
            while (count == k)
                if (nums[l++] == maxNumber)
                    --count;
            answer += l;
        }

        return answer;
    }
}
