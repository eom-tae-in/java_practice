package category.leetcode._2025.march;

public class March6th {

    public int[] findMissingAndRepeatedValues(final int[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int[] counts = new int[rowLength * columnLength + 1];

        for (int[] row : grid) {
            for (int num : row) {
                counts[num]++;
            }
        }

        int[] answer = new int[2];

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 2) {
                answer[0] = i;
            }

            if (counts[i] == 0) {
                answer[1] = i;
            }
        }

        return answer;
    }
}
