package category.leetcode._2024.March;

import java.util.ArrayList;
import java.util.List;

public class March25th {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
            if (nums[Math.abs(num) - 1] > 0) {
                answer.add(Math.abs(num));
            }
        }

        return answer;
    }
}
