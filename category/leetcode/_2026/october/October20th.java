package category.leetcode._2026.october;

public class October20th {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] nextDrop = new int[n];
        nextDrop[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            nextDrop[i] = nums[i] > nums[i + 1] ? i : nextDrop[i + 1];
        }

        int answer = 0;

        for (int k = 1; k <= n / k; k++) {
            if (n % k != 0) {
                continue;
            }

            if (isSortable(nums, nextDrop, k)) {
                answer += k;
            }

            int other = n / k;

            if (other != k && isSortable(nums, nextDrop, other)) {
                answer += other;
            }
        }

        return answer;
    }

    private boolean isSortable(int[] nums, int[] nextDrop, int k) {
        int previousMax = 0;

        for (int left = 0; left < nums.length; left += k) {
            int right = left + k - 1;
            int drop = nextDrop[left];
            int min;
            int max;

            if (drop >= right) {
                min = nums[left];
                max = nums[right];
            } else {
                if (nextDrop[drop + 1] < right) {
                    return false;
                }

                if (nums[right] > nums[left]) {
                    return false;
                }

                min = nums[drop + 1];
                max = nums[drop];
            }

            if (left > 0 && previousMax > min) {
                return false;
            }

            previousMax = max;
        }

        return true;
    }
}
