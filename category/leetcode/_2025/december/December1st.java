package category.leetcode._2025.december;

import java.util.Arrays;

public class December1st {

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;

        for (int battery : batteries) {
            sum += battery;
        }

        Arrays.sort(batteries);
        int i = batteries.length - 1;

        while (batteries[i] > sum / n) {
            sum -= batteries[i--];
            n--;
        }

        return sum / n;
    }
}
