package category.leetcode._2026.february;

public class February4th {

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        long res = Long.MIN_VALUE;
        long psum = nums[0];
        int l = 0;
        int p = 0;
        int q = 0;

        for (int r = 1; r < n; ++r) {
            psum += nums[r];

            if (nums[r - 1] == nums[r]) {
                l = r;
                psum = nums[r];
            } else if (nums[r - 1] > nums[r]) {
                if (r > 1 && nums[r - 2] < nums[r - 1]) {
                    p = r - 1;

                    while (l < q) {
                        psum -= nums[l];
                        l++;
                    }

                    while (l + 1 < p && nums[l] < 0) {
                        psum -= nums[l];
                        l++;
                    }
                }
            } else {
                if (r > 1 && nums[r - 2] > nums[r - 1]) {
                    q = r - 1;
                }

                if (l < p && p < q) {
                    res = Math.max(res, psum);
                }
            }
        }

        return res == Long.MIN_VALUE ? 0 : res;
    }
}
