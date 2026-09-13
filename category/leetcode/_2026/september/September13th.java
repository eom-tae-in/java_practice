package category.leetcode._2026.september;

public class September13th {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int answer = 0;

        for (int rowShift = -n + 1; rowShift < n; rowShift++) {
            for (int colShift = -n + 1; colShift < n; colShift++) {
                int overlap = 0;

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        int nr = r + rowShift;
                        int nc = c + colShift;

                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && img1[r][c] == 1 && img2[nr][nc] == 1) {
                            overlap++;
                        }
                    }
                }

                answer = Math.max(answer, overlap);
            }
        }

        return answer;
    }
}
