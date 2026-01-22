package category.leetcode._2026.january;

import java.util.ArrayList;
import java.util.List;

public class January22nd {

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        for (int num : nums) {
            list.add(num);
        }

        while (hasDecreasing(list)) {
            int minValue = Integer.MAX_VALUE;
            int minIdx = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) + list.get(i + 1) < minValue) {
                    minValue = list.get(i) + list.get(i + 1);
                    minIdx = i;
                }
            }

            list.set(minIdx, minValue);
            list.remove(minIdx + 1);
            answer++;
        }

        return answer;
    }

    private boolean hasDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return true;
            }
        }

        return false;
    }
}
