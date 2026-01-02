package category.leetcode._2026.january;

import java.util.HashSet;
import java.util.Set;

public class January2nd {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }

        return -1;
    }
}
