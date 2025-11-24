package category.leetcode._2025.november;

import java.util.ArrayList;
import java.util.List;

public class November24th {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int curr = 0;

        for (int num : nums) {
            curr = (curr * 2 + num) % 5;
            answer.add(curr == 0);
        }

        return answer;
    }
}
