package category.leetcode._2026.august;

import java.util.ArrayList;
import java.util.List;

public class August20th {

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> primary = new ArrayList<>();
        List<Integer> secondary = new ArrayList<>();
        int idx = 0;
        int primaryLast = nums[idx++];
        primary.add(primaryLast);
        int secondaryLast = nums[idx++];
        secondary.add(secondaryLast);

        while (idx < n) {
            if (primaryLast < secondaryLast) {
                secondaryLast = nums[idx++];
                secondary.add(secondaryLast);
            } else if (primaryLast > secondaryLast) {
                primaryLast = nums[idx++];
                primary.add(primaryLast);
            }
        }

        int[] answer = new int[n];
        idx = 0;

        for (int num : primary) {
            answer[idx++] = num;
        }

        for (int num : secondary) {
            answer[idx++] = num;
        }

        return answer;
    }
}
