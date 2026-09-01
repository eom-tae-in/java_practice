package category.leetcode._2026.september;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class September1st {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;
        int[][] litterBits = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = classroom[row].charAt(col);

                if (cell == 'S') {
                    startRow = row;
                    startCol = col;
                } else if (cell == 'L') {
                    litterBits[row][col] = 1 << litterCount++;
                }
            }
        }

        int targetMask = (1 << litterCount) - 1;

        if (targetMask == 0) {
            return 0;
        }

        int cellCount = rows * cols;
        int[][] maxRemainingEnergy = new int[1 << litterCount][cellCount];

        for (int[] energies : maxRemainingEnergy) {
            Arrays.fill(energies, -1);
        }

        Queue<State> queue = new ArrayDeque<>();
        int startPosition = startRow * cols + startCol;
        queue.offer(new State(startRow, startCol, 0, energy));
        maxRemainingEnergy[0][startPosition] = energy;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                State current = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int nextRow = current.row + direction[0];
                    int nextCol = current.col + direction[1];

                    if (!isValid(nextRow, nextCol, rows, cols) || classroom[nextRow].charAt(nextCol) == 'X') {
                        continue;
                    }

                    char nextCell = classroom[nextRow].charAt(nextCol);
                    int nextEnergy = current.remainingEnergy - 1;
                    int nextMask = current.litterMask | litterBits[nextRow][nextCol];

                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    }

                    if (nextMask == targetMask) {
                        return moves + 1;
                    }

                    if (nextEnergy == 0) {
                        continue;
                    }

                    int nextPosition = nextRow * cols + nextCol;

                    if (maxRemainingEnergy[nextMask][nextPosition] >= nextEnergy) {
                        continue;
                    }

                    maxRemainingEnergy[nextMask][nextPosition] = nextEnergy;
                    queue.offer(new State(nextRow, nextCol, nextMask, nextEnergy));
                }
            }

            moves++;
        }

        return -1;
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static class State {

        private final int row;
        private final int col;
        private final int litterMask;
        private final int remainingEnergy;

        private State(int row, int col, int litterMask, int remainingEnergy) {
            this.row = row;
            this.col = col;
            this.litterMask = litterMask;
            this.remainingEnergy = remainingEnergy;
        }
    }
}
