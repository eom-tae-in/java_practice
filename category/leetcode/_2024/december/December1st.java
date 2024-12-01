package category.leetcode._2024.december;

import java.util.HashSet;
import java.util.Set;

public class December1st {

    public boolean checkIfExist(final int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int a : arr) {
            if (seen.contains(a * 2) || a % 2 == 0 && seen.contains(a / 2)) {
                return true;
            }
            seen.add(a);
        }

        return false;
    }
}
