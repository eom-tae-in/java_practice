package category.leetcode._2026.january;

import java.util.List;

public class January21st {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int curr = nums.get(i);

            if (curr == 2) {
                answer[i] = -1;
            } else {
                answer[i] = curr - getTrailingOnesLeadingBit(curr);
            }
        }

        return answer;
    }

    private int getTrailingOnesLeadingBit(int num) {
        int leading = 1;

        while ((num & leading) > 0) {
            leading <<= 1;
        }

        return leading >> 1;
    }
}
