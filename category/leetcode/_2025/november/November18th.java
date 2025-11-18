package category.leetcode._2025.november;

public class November18th {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int idx = 0;

        while (idx < n) {
            if (idx == n - 1) {
                return true;
            }

            if (bits[idx] == 1) {
                idx++;
            }

            idx++;
        }

        return false;
    }
}
