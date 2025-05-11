package category.leetcode._2025.may;

public class May11th {

    public boolean threeConsecutiveOdds(final int[] arr) {
        int arrLength = arr.length;

        if (arrLength < 3) {
            return false;
        }

        for (int i = 0; i < arrLength - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }

        return false;
    }
}
