package category.leetcode._2024.august;

import java.util.ArrayList;
import java.util.List;

public class August18th {

    public int nthUglyNumber(final int n) {
        List<Integer> uglyNums = new ArrayList<>();
        uglyNums.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (uglyNums.size() < n) {
            int next2 = uglyNums.get(i2) * 2;
            int next3 = uglyNums.get(i3) * 3;
            int next5 = uglyNums.get(i5) * 5;
            int next = Math.min(next2, Math.min(next3, next5));
            if (next == next2) {
                ++i2;
            }
            if (next == next3) {
                ++i3;
            }
            if (next == next5) {
                ++i5;
            }
            uglyNums.add(next);
        }

        return uglyNums.get(uglyNums.size() - 1);
    }
}
