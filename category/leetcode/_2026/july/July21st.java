package category.leetcode._2026.july;

public class July21st {

    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        int zeroBeforeOne = 0;
        int gains = 0;

        for (int i = 0; i < n; i++) {
            int oneBetweenZero = 0;

            while (i < n && s.charAt(i) == '1') {
                oneBetweenZero++;
                ones++;
                i++;
            }

            int zeroAfterOne = 0;

            while (i < n && s.charAt(i) == '0') {
                zeroAfterOne++;
                i++;
            }

            if (zeroBeforeOne > 0 && oneBetweenZero > 0 && zeroAfterOne > 0) {
                gains = Math.max(gains, zeroBeforeOne + zeroAfterOne);
            }

            zeroBeforeOne = zeroAfterOne;
            i--;
        }

        return ones + gains;
    }
}
