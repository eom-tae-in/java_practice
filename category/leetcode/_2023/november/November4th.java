package category.leetcode._2023.november;

public class November4th {

    public int getLastMoment(int n, int[] left, int[] right) {
        int max = -1;

        for (int l : left) {
            if (l > max) {
                max = l;
            }
        }

        for (int r : right) {
            if (n - r > max) {
                max = n - r;
            }
        }

        return max;
    }
}
