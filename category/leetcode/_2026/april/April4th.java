package category.leetcode._2026.april;

public class April4th {

    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = encodedText.charAt(i * cols + j);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            int i = 0;
            int j = col;

            while (i < rows && j < cols) {
                ans.append(matrix[i][j]);
                i++;
                j++;
            }
        }

        int end = ans.length();

        while (end > 0 && ans.charAt(end - 1) == ' ') {
            end--;
        }

        return ans.substring(0, end);
    }
}
