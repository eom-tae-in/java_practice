package category.leetcode._2024.may;

public class May10th {

    public int[] kthSmallestPrimeFraction(final int[] arr, final int k) {
        int length = arr.length;
        double left = 0.0;
        double right = 1.0;

        while (left < right) {
            double middle = (left + right) / 2.0;
            int p = 0;
            int q = 1;
            int count = 0;

            for (int i = 0, j = 1; i < length; i++) {
                while (j < length && arr[i] > arr[j] * middle) {
                    ++j;
                }

                if (j == length) {
                    break;
                }

                count += length - j;

                if (p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }

            if (count == k) {
                return new int[]{p, q};
            } else if (count > k) {
                right = middle;
            } else {
                left = middle;
            }
        }

        throw new IllegalArgumentException();
    }
}
