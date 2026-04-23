package category.leetcode._2026.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class April23rd {

    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> positionsByValue = new HashMap<>();

        for (int i = 0; i < n; i++) {
            positionsByValue.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] answer = new long[n];

        for (List<Integer> positions : positionsByValue.values()) {
            int size = positions.size();

            if (size == 1) {
                continue;
            }

            long totalPositionSum = 0;

            for (int pos : positions) {
                totalPositionSum += pos;
            }

            int firstPos = positions.get(0);
            long currentDistanceSum = totalPositionSum - (long) size * firstPos;
            answer[firstPos] = currentDistanceSum;

            for (int i = 1; i < size; i++) {
                int prevPos = positions.get(i - 1);
                int currPos = positions.get(i);
                int diff = currPos - prevPos;
                int rightCount = size - i;
                currentDistanceSum += (long) i * diff;
                currentDistanceSum -= (long) rightCount * diff;
                answer[currPos] = currentDistanceSum;
            }
        }

        return answer;
    }
}
