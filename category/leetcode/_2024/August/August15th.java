package category.leetcode._2024.August;

public class August15th {

    public boolean lemonadeChange(final int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (final int bill : bills) {
            if (bill == 5) {
                ++count5;
            } else if (bill == 10) {
                --count5;
                ++count10;
            } else {
                if (count10 > 0) {
                    --count10;
                    --count5;
                } else {
                    count5 -= 3;
                }
            }
            if (count5 < 0) {
                return false;
            }
        }

        return true;
    }
}
