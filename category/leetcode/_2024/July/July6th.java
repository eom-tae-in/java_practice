package category.leetcode._2024.July;

public class July6th {

    public int passThePillow(final int n, int time) {
        time %= (n - 1) * 2;
        if (time < n) {
            return 1 + time;
        }

        return 2 * n - 1 - time;
    }
}
