package category.leetcode._2026.october;

import java.util.Arrays;

public class October17th {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] sorted = new int[n][3];

        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = digitSum(nums[i]);
            sorted[i][2] = i;
        }

        Arrays.sort(sorted, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int current = i;
            int cycleLength = 0;

            while (!visited[current]) {
                visited[current] = true;
                current = sorted[current][2];
                cycleLength++;
            }

            answer += cycleLength - 1;
        }

        return answer;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
