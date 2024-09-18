package category.leetcode._2024.september;

import java.util.Arrays;
import java.util.stream.Collectors;

public class September18th {

    public String largestNumber(final int[] nums) {
        final String str = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""));

        return str.startsWith("00") ? "0" : str;
    }
}
