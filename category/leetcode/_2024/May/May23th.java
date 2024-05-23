package category.leetcode._2024.May;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class May23th {

    public int beautifulSubsets(final int[] nums, final int k) {
        int maxNum = 1000;
        int[] numCount = new int[maxNum + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int num : nums) {
            numCount[num]++;
            map.putIfAbsent(num % k, new TreeSet<>());
            map.get(num % k).add(num);
        }

        int skip = 0;
        int pick = 0;
        int prevNum = Integer.MIN_VALUE;

        for (Set<Integer> sameRemainderNums : map.values()) {
            for (int num : sameRemainderNums) {
                int subsetSize = (1 << numCount[num]) - 1;
                int prevSkip = skip;
                skip += pick;
                pick = subsetSize * (1 + prevSkip + (num - prevNum == k ? 0 : pick));
                prevNum = num;
            }
        }

        return skip + pick;
    }
}
