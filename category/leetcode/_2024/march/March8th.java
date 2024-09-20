package category.leetcode._2024.march;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class March8th {

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(
                        num -> num,
                        num -> 1,
                        Integer::sum
                ));

        Collection<Integer> values = map.values();
        int maxCount = values.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return values.stream()
                .filter(value -> value == maxCount)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
