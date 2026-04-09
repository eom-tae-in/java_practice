package category.leetcode._2026.april;

import java.util.ArrayList;
import java.util.List;

public class April9th {

    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int limit = (int) Math.sqrt(n);
        List<Update>[][] group = new ArrayList[limit + 1][limit];

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int step = query[2];
            int value = query[3];

            if (step > limit) {
                for (int i = start; i <= end; i += step) {
                    nums[i] = (int) ((long) nums[i] * value % MOD);
                }
            } else {
                int remainder = start % step;
                int left = (start - remainder) / step;
                int right = (end - remainder) / step;

                if (group[step][remainder] == null) {
                    group[step][remainder] = new ArrayList<>();
                }

                group[step][remainder].add(new Update(left, right, value));
            }
        }

        for (int step = 1; step <= limit; step++) {
            for (int remainder = 0; remainder < step; remainder++) {
                if (group[step][remainder] == null) {
                    continue;
                }

                int len = (n - 1 - remainder) / step + 1;
                long[] diff = new long[len + 1];

                for (int i = 0; i <= len; i++) {
                    diff[i] = 1L;
                }

                for (Update update : group[step][remainder]) {
                    diff[update.start] = diff[update.start] * update.value % MOD;

                    if (update.end + 1 < len) {
                        diff[update.end + 1] = diff[update.end + 1] * modInverse(update.value) % MOD;
                    }
                }

                long prefixMul = 1L;

                for (int t = 0; t < len; t++) {
                    prefixMul = prefixMul * diff[t] % MOD;
                    int idx = t * step + remainder;
                    nums[idx] = (int) (nums[idx] * prefixMul % MOD);
                }
            }
        }

        int answer = 0;

        for (int num : nums) {
            answer ^= num;
        }

        return answer;
    }

    private long modInverse(int num) {
        return modPow(num, MOD - 2);
    }

    private long modPow(long base, int exp) {
        long result = 1L;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }

    private static class Update {

        private final int start;
        private final int end;
        private final int value;

        private Update(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
