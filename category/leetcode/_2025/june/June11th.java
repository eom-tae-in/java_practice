package category.leetcode._2025.june;

public class June11th {

    public int maxDifference(String s, int k) {
        int n = s.length();
        int[][] preSum = new int[n + 1][5];

        for (int i = 0; i < s.length(); i++) {
            System.arraycopy(preSum[i], 0, preSum[i + 1], 0, preSum[i].length);
            preSum[i + 1][s.charAt(i) - '0'] = preSum[i][s.charAt(i) - '0'] + 1;
        }

        int max = Integer.MIN_VALUE;

        for (int a = 0; a <= 4; a++) {
            for (int b = 0; b <= 4; b++) {
                if (a == b) {
                    continue;
                }

                int left = 0;
                int right = 0;

                int[][] min = new int[][]{
                        {Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2},
                        {Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2}
                };

                while (right < n) {
                    while (right - left + 1 >= k &&
                            preSum[right + 1][a] > preSum[left][a] &&
                            preSum[right + 1][b] > preSum[left][b]) {
                        int p = preSum[left][a] & 1;
                        int q = preSum[left][b] & 1;
                        min[p][q] = Math.min(min[p][q], preSum[left][a] - preSum[left][b]);
                        left++;
                    }

                    int x = preSum[right + 1][a] & 1 ^ 1;
                    int y = preSum[right + 1][b] & 1;
                    max = Math.max(max, preSum[right + 1][a] - preSum[right + 1][b] - min[x][y]);
                    right++;
                }
            }
        }

        return max;
    }
}
