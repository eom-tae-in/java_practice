package category.leetcode._2023.september;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class September20th {

    public int minOperations(int[] nums, int x) {
        int sum = IntStream.of(nums).sum() - x;
        int arrayLength = nums.length;
        if (sum == 0) {
            return arrayLength;
        }
        int maxLength = maxSubArrayLength(nums, sum);
        return maxLength == -1 ? -1 : arrayLength - maxLength;
    }

    private int maxSubArrayLength(int[] nums, int sum) {
        int prefix = 0;
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int target = prefix - sum;
            if (map.containsKey(target)) {
                result = Math.max(result, i - map.get(target));
            }
            map.put(prefix, i);
        }
        return result;
    }
}
