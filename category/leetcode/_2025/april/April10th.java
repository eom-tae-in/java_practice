package category.leetcode._2025.april;

public class April10th {

    public long numberOfPowerfulInt(
            final long start,
            final long finish,
            final int limit,
            final String s
    ) {
        long suffix = 0L;

        for (char c : s.toCharArray()) {
            suffix = suffix * 10 + c - '0';
        }

        if (suffix > finish) {
            return 0;
        }

        long div = (long) Math.pow(10, s.length());
        long ps = start / div;
        long pf = finish / div;

        if (finish % div >= suffix) {
            pf++;
        }

        if (start % div > suffix) {
            ps++;
        }

        return getAvailNum(pf, limit) - getAvailNum(ps, limit);
    }

    private long getAvailNum(long num, long limit) {
        if (num == 0) {
            return 0;
        }

        if (limit == 9) {
            return num;
        }

        int digits = (int) Math.log10(num);
        long div = (long) Math.pow(10, digits);
        long res = 0L;

        for (int i = digits; i >= 0; i--) {
            int d = (int) (num / div);

            if (d > limit) {
                return res + (long) Math.pow(limit + 1, i + 1);
            } else {
                res += d * (long) Math.pow(limit + 1, i);
            }

            num %= div;
            div /= 10;
        }

        return res;
    }
}
