package category.leetcode._2024.october;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class October28th {

    public int longestSquareStreak(final int[] nums) {
        Arrays.sort(nums);
        Set<Integer> numsSet = new HashSet<>();
        Set<Integer> prevNums = new HashSet<>();
        int n = nums.length;
        int answer = 0;
        int maxValue = nums[n - 1];

        for (int num : nums) {
            numsSet.add(num);
        }

        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            int current = nums[i];
            while ((long) current * current <= maxValue) {
                current *= current;
                if (prevNums.contains(current) || !numsSet.contains(current)) {
                    break;
                }
                prevNums.add(current);
                count++;
            }
            answer = Math.max(answer, count);
        }

        return answer < 2 ? -1 : answer;
    }
}
