package category.leetcode._2026.may;

import java.util.ArrayList;
import java.util.List;

public class May11th {

    public int[] separateDigits(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int num : nums) {
            for (char c : String.valueOf(num).toCharArray()) {
                answer.add(c - '0');
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
