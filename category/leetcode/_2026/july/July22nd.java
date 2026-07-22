package category.leetcode._2026.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class July22nd {

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        List<ZeroGroup> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[n];
        Arrays.fill(zeroGroupIndex, -1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                } else {
                    zeroGroups.add(new ZeroGroup(i, 1));
                }
            }

            zeroGroupIndex[i] = zeroGroups.size() - 1;
        }

        List<Integer> answer = new ArrayList<>(queries.length);

        if (zeroGroups.size() < 2) {
            for (int i = 0; i < queries.length; i++) {
                answer.add(totalOnes);
            }

            return answer;
        }

        int[] merge = new int[zeroGroups.size() - 1];

        for (int i = 0; i + 1 < zeroGroups.size(); i++) {
            merge[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
        }

        SegmentTree segmentTree = new SegmentTree(merge);

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int bestGain = 0;
            int leftGroupIndex = zeroGroupIndex[left];
            int rightGroupIndex = zeroGroupIndex[right];
            int leftPartialLength = 0;

            if (s.charAt(left) == '0') {
                ZeroGroup group = zeroGroups.get(leftGroupIndex);
                leftPartialLength = group.start + group.length - left;
            }

            int rightPartialLength = 0;

            if (s.charAt(right) == '0') {
                ZeroGroup group = zeroGroups.get(rightGroupIndex);
                rightPartialLength = right - group.start + 1;
            }

            int firstFullZeroGroup = leftGroupIndex + 1;
            int lastFullZeroGroup = s.charAt(right) == '0' ? rightGroupIndex - 1 : rightGroupIndex;

            if (firstFullZeroGroup < lastFullZeroGroup) {
                bestGain = Math.max(bestGain, segmentTree.query(firstFullZeroGroup, lastFullZeroGroup - 1));
            }

            if (s.charAt(left) == '0') {
                int nextGroupIndex = leftGroupIndex + 1;

                if (nextGroupIndex <= lastFullZeroGroup) {
                    bestGain = Math.max(bestGain, leftPartialLength + zeroGroups.get(nextGroupIndex).length);
                }
            }

            if (s.charAt(right) == '0') {
                int previousGroupIndex = rightGroupIndex - 1;

                if (previousGroupIndex >= firstFullZeroGroup) {
                    bestGain = Math.max(bestGain, zeroGroups.get(previousGroupIndex).length + rightPartialLength);
                }
            }

            if (s.charAt(left) == '0' && s.charAt(right) == '0' && leftGroupIndex + 1 == rightGroupIndex) {
                bestGain = Math.max(bestGain, leftPartialLength + rightPartialLength);
            }

            answer.add(totalOnes + bestGain);
        }

        return answer;
    }

    private static class ZeroGroup {

        int start;
        int length;

        ZeroGroup(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    private static class SegmentTree {

        private final int size;
        private final int[] tree;

        SegmentTree(int[] values) {
            int size = 1;

            while (size < values.length) {
                size <<= 1;
            }

            this.size = size;
            this.tree = new int[size << 1];

            for (int i = 0; i < values.length; i++) {
                tree[size + i] = values[i];
            }

            for (int i = size - 1; i >= 1; i--) {
                tree[i] = Math.max(tree[i << 1], tree[i << 1 | 1]);
            }
        }

        int query(int left, int right) {
            if (left > right) {
                return 0;
            }

            left += size;
            right += size;
            int result = 0;

            while (left <= right) {
                if ((left & 1) == 1) {
                    result = Math.max(result, tree[left++]);
                }

                if ((right & 1) == 0) {
                    result = Math.max(result, tree[right--]);
                }

                left >>= 1;
                right >>= 1;
            }

            return result;
        }
    }
}
