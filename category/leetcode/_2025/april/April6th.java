package category.leetcode._2025.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class April6th {

    public List<Integer> largestDivisibleSubset(final int[] nums) {
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();
        int[] sizeEndsAt = new int[n];
        int[] prevIndex = new int[n];
        int maxSize = 0;
        int index = -1;
        Arrays.fill(sizeEndsAt, 1);
        Arrays.fill(prevIndex, -1);
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && sizeEndsAt[i] < sizeEndsAt[j] + 1) {
                    sizeEndsAt[i] = sizeEndsAt[j] + 1;
                    prevIndex[i] = j;
                }
            }

            if (maxSize < sizeEndsAt[i]) {
                maxSize = sizeEndsAt[i];
                index = i;
            }
        }

        while (index != -1) {
            answer.add(nums[index]);
            index = prevIndex[index];
        }

        return answer;
    }
}
