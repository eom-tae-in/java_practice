package category.leetcode.october;

import java.util.Arrays;

public class October30th {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> Integer.bitCount(a) == Integer.bitCount(a) ? a - b
                        : Integer.bitCount(a) - Integer.bitCount(b))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
