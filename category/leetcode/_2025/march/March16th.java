package category.leetcode._2025.march;

public class March16th {

    public long repairCars(final int[] ranks, final int cars) {
        long max = 0;

        for (int rank : ranks) {
            max = Math.max(max, rank);
        }

        long left = 1;
        long right = max * cars * cars;

        while (left < right) {
            long mid = (left + right) / 2;
            long carCount = 0;

            for (int rank : ranks) {
                carCount += (long) Math.sqrt(mid / rank);
            }

            if (carCount < cars) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
