package category.leetcode._2026.october;

public class October10th {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff);
            totalDiff += diff;
        }

        long remaining = (long) k1 + k2;

        if (remaining >= totalDiff) {
            return 0L;
        }

        long[] count = new long[maxDiff + 1];

        for (int i = 0; i < nums1.length; i++) {
            count[Math.abs(nums1[i] - nums2[i])]++;
        }

        for (int diff = maxDiff; diff > 0 && remaining > 0; diff--) {
            if (count[diff] <= remaining) {
                remaining -= count[diff];
                count[diff - 1] += count[diff];
                count[diff] = 0;
            } else {
                count[diff] -= remaining;
                count[diff - 1] += remaining;
                remaining = 0;
            }
        }

        long answer = 0;

        for (int diff = 1; diff <= maxDiff; diff++) {
            answer += count[diff] * diff * diff;
        }

        return answer;
    }
}
