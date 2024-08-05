package category.leetcode._2024.August;

import java.util.HashMap;
import java.util.Map;

public class August5th {

    public String kthDistinct(final String[] arr, final int k) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.merge(str, 1, Integer::sum);
        }
        for (String str : arr) {
            if (map.get(str) == 1) {
                count++;
                if (count == k) {
                    return str;
                }
            }
        }

        return "";
    }
}
