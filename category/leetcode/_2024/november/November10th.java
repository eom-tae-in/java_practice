package category.leetcode._2024.november;

public class November10th {

    public int minimumSubarrayLength(final int[] nums, final int k) {
        int n = nums.length;
        int[] count = new int[30];
        int answer = n + 1;
        int ors = 0;

        for (int l = 0, r = 0; r < n; r++) {
            ors = addOrNum(ors, nums[r], count);
            while (ors >= k && l <= r) {
                answer = Math.min(answer, r - l + 1);
                ors = subtractOrNum(ors, nums[l], count);
                l++;
            }
        }

        return answer == n + 1 ? -1 : answer;
    }

    private int addOrNum(int ors, final int num, final int[] count) {
        int n = getBitLength(num);

        for (int i = 0; i < n; i++) {
            if ((num >> i & 1) == 1 && ++count[i] == 1) {
                ors += 1 << i;
            }
        }

        return ors;
    }

    private int subtractOrNum(int ors, final int num, final int[] count) {
        int n = getBitLength(num);

        for (int i = 0; i < n; i++) {
            if ((num >> i & 1) == 1 && --count[i] == 0) {
                ors -= 1 << i;
            }
        }

        return ors;
    }

    private int getBitLength(final int num) {
        return 32 - Integer.numberOfLeadingZeros(num);
    }
}
