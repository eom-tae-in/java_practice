package category.leetcode._2025.april;

public class April21st {

    public int numberOfArrays(final int[] differences, final int lower, final int upper) {
        long min = 0;
        long max = 0;
        long accumulate = 0;

        for (int difference : differences) {
            accumulate += difference;
            min = Math.min(min, accumulate);
            max = Math.max(max, accumulate);
        }

        if (upper - lower < max - min) {
            return 0;
        }

        return (int) ((upper - lower) - (max - min)) + 1;
    }
}
