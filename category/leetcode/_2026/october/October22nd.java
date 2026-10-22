package category.leetcode._2026.october;

public class October22nd {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
            }

            int next = nums[(i + 1) % n];

            if (next != (nums[i] + 1) % n) {
                ascending = false;
            }

            if (next != (nums[i] + n - 1) % n) {
                descending = false;
            }
        }

        int answer = Integer.MAX_VALUE;

        if (ascending) {
            int rotateLeft = zeroIndex;
            int rotateRight = n - zeroIndex + 2;
            answer = Math.min(rotateLeft, rotateRight);
        }

        if (descending) {
            int reverseThenRotate = n - zeroIndex;
            int rotateThenReverse = (zeroIndex + 1) % n + 1;
            answer = Math.min(answer, Math.min(reverseThenRotate, rotateThenReverse));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
