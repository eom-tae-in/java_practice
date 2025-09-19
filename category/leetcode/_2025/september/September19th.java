package category.leetcode._2025.september;

public class September19th {

    private static class Spreadsheet {

        private final int[][] sheet;

        public Spreadsheet(int rows) {
            sheet = new int[rows + 1][26];
        }

        public void setCell(String cell, int value) {
            int row = Integer.parseInt(cell.substring(1));
            int col = cell.charAt(0) - 'A';
            sheet[row][col] = value;
        }

        public void resetCell(String cell) {
            int row = Integer.parseInt(cell.substring(1));
            int col = cell.charAt(0) - 'A';
            sheet[row][col] = 0;
        }

        public int getValue(String formula) {
            int sum = 0;
            int separator = formula.indexOf('+');
            String primary = formula.substring(1, separator);
            String secondary = formula.substring(separator + 1);
            sum += calculateValue(primary);
            sum += calculateValue(secondary);

            return sum;
        }

        private int calculateValue(String secondary) {
            if (Character.isDigit(secondary.charAt(0))) {
                return Integer.parseInt(secondary);
            } else {
                int row = Integer.parseInt(secondary.substring(1));
                int col = secondary.charAt(0) - 'A';

                return sheet[row][col];
            }
        }
    }
}
