package category.leetcode._2026.august;

import java.util.ArrayList;
import java.util.List;

public class August4th {

    public List<Integer> findMissingElements(int[] nums) {
        int[] count = new int[101];
        int min = 101;
        int max = 0;

        for (int num : nums) {
            count[num]++;

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int num = min + 1; num < max; num++) {
            if (count[num] == 0) {
                answer.add(num);
            }
        }

        return answer;
    }
}
