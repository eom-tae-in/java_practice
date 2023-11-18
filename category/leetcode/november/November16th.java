package category.leetcode.november;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class November16th {

    public static String findDifferentBinaryString(String[] nums) {
        int bitSize = nums.length;
        int maxNum = 1 << bitSize;

        Set<Integer> set = Arrays.stream(nums)
                .mapToInt(num -> Integer.parseInt(num, 2))
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 0; i < maxNum; i++) {
            if (!set.contains(i)) {
                return String.format("%" + bitSize + "s", Integer.toBinaryString(i)).replace(" ", "0");
            }
        }
        throw new IllegalArgumentException();
    }
}
