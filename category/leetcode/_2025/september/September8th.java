package category.leetcode._2025.september;

public class September8th {

    public int[] getNoZeroIntegers(int n) {
        int left = 1;
        int right = n - 1;

        while (hasZero(left, right)) {
            left++;
            right--;
        }

        return new int[]{left, right};
    }

    private boolean hasZero(int left, int right) {
        while (left > 0) {
            if (left % 10 == 0) {
                return true;
            }

            left /= 10;
        }

        while (right > 0) {
            if (right % 10 == 0) {
                return true;
            }

            right /= 10;
        }

        return false;
    }
}
