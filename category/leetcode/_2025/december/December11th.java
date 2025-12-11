package category.leetcode._2025.december;

public class December11th {

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][] rowSide = new int[n + 1][2];
        int[][] colSide = new int[n + 1][2];
        int answer = 0;

        for (int i = 0; i < n + 1; i++) {
            rowSide[i][0] = n + 1;
            rowSide[i][1] = -1;
            colSide[i][0] = n + 1;
            colSide[i][1] = -1;
        }

        for (int[] building : buildings) {
            int r = building[0];
            int c = building[1];
            rowSide[r][0] = Math.min(rowSide[r][0], c);
            rowSide[r][1] = Math.max(rowSide[r][1], c);
            colSide[c][0] = Math.min(colSide[c][0], r);
            colSide[c][1] = Math.max(colSide[c][1], r);
        }

        for (int[] building : buildings) {
            int r = building[0];
            int c = building[1];

            if (rowSide[r][0] < c && c < rowSide[r][1] && colSide[c][0] < r && r < colSide[c][1]) {
                answer++;
            }
        }

        return answer;
    }
}
