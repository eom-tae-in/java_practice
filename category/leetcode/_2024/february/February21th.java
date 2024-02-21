package category.leetcode._2024.february;

public class February21th {

    public int rangeBitwiseAnd(final int left, final int right) {
        int bitShiftSize = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            bitShiftSize++;
        }

        return left << bitShiftSize;
    }
}
