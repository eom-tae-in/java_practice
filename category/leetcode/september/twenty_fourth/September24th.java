package category.leetcode.september.twenty_fourth;

public class September24th {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[query_row + 1][];
        for (int i = 0; i < glasses.length; i++) {
            glasses[i] = new double[i + 1];
        }
        glasses[0][0] = poured;
        for (int i = 0; i < query_row; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (glasses[i][j] > 1) {
                    glasses[i + 1][j] += (glasses[i][j] - 1) / 2.0;
                    glasses[i + 1][j + 1] += (glasses[i][j] - 1) / 2.0;
                }
            }
        }
        return Math.min(1.0, glasses[query_row][query_glass]);
    }
}
