package category.leetcode._2025.july;

import java.util.HashSet;
import java.util.Set;

public class July31st {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int arrLength = arr.length;

        for (int i = 0; i < arrLength; i++) {
            set.add(arr[i]);

            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] | arr[j]) == arr[j]) {
                    break;
                }

                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }

        return set.size();
    }
}
