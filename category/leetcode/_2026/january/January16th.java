package category.leetcode._2026.january;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class January16th {

    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int hLen = hFences.length;
        int vLen = vFences.length;
        hFences = Arrays.copyOf(hFences, hLen + 2);
        vFences = Arrays.copyOf(vFences, vLen + 2);
        hFences[hLen] = 1;
        hFences[hLen + 1] = m;
        vFences[vLen] = 1;
        vFences[vLen + 1] = n;
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> hGaps = getGaps(hFences);
        Set<Integer> vGaps = getGaps(vFences);
        int maxLen = -1;

        for (int hGap : hGaps) {
            if (vGaps.contains(hGap)) {
                maxLen = Math.max(maxLen, hGap);
            }
        }

        return maxLen == -1 ? -1 : (int) ((long) maxLen * maxLen % MOD);
    }

    private Set<Integer> getGaps(int[] fences) {
        Set<Integer> gaps = new HashSet<>();

        for (int i = 0; i < fences.length; i++) {
            for (int j = 0; j < i; j++) {
                gaps.add(fences[i] - fences[j]);
            }
        }

        return gaps;
    }
}
