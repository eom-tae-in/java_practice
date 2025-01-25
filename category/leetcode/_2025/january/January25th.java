package category.leetcode._2025.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class January25th {

    public int[] lexicographicallySmallestArray(final int[] nums, final int limit) {
        int[] ans = new int[nums.length];
        List<List<int[]>> numAndIndexesGroups = new ArrayList<>();

        for (int[] numAndIndex : getNumAndIndexes(nums)) {
            if (numAndIndexesGroups.isEmpty() ||
                    numAndIndex[0] - numAndIndexesGroups.get(numAndIndexesGroups.size() - 1)
                            .get(numAndIndexesGroups.get(numAndIndexesGroups.size() - 1).size() - 1)[0] > limit) {
                numAndIndexesGroups.add(new ArrayList<>(List.of(numAndIndex)));
            } else {
                numAndIndexesGroups.get(numAndIndexesGroups.size() - 1).add(numAndIndex);
            }
        }

        for (List<int[]> numAndIndexesGroup : numAndIndexesGroups) {
            List<Integer> sortedNums = new ArrayList<>();
            List<Integer> sortedIndices = new ArrayList<>();

            for (int[] pair : numAndIndexesGroup) {
                sortedNums.add(pair[0]);
                sortedIndices.add(pair[1]);
            }

            sortedIndices.sort(null);

            for (int i = 0; i < sortedNums.size(); ++i) {
                ans[sortedIndices.get(i)] = sortedNums.get(i);
            }
        }

        return ans;
    }

    private int[][] getNumAndIndexes(final int[] nums) {
        int[][] numAndIndexes = new int[nums.length][2];

        for (int i = 0; i < nums.length; ++i) {
            numAndIndexes[i][0] = nums[i];
            numAndIndexes[i][1] = i;
        }

        Arrays.sort(numAndIndexes, Comparator.comparingInt(a -> a[0]));
        return numAndIndexes;
    }
}
