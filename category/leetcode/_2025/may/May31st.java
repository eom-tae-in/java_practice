package category.leetcode._2025.may;

import java.util.LinkedList;
import java.util.Queue;

public class May31st {

    public int snakesAndLadders(int[][] board) {
        int rowLength = board.length;
        int columnLength = board[0].length;
        int[] flatBoard = new int[rowLength * columnLength + 1];
        boolean[] seen = new boolean[rowLength * columnLength + 1];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                int row = (rowLength - 1 - i) * columnLength;
                int column = (rowLength - i) % 2 == 0 ? columnLength - j : j + 1;
                flatBoard[row + column] = board[i][j];
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        for (int step = 1; !queue.isEmpty(); step++) {
            for (int size = queue.size(); size > 0; size--) {
                int current = queue.poll();

                for (int depth = current + 1; depth <= Math.min(current + 6, rowLength * columnLength); depth++) {
                    int next = flatBoard[depth] == -1 ? depth : flatBoard[depth];

                    if (seen[next]) {
                        continue;
                    }

                    if (next == rowLength * columnLength) {
                        return step;
                    }

                    queue.offer(next);
                    seen[next] = true;
                }
            }
        }

        return  -1;
    }
}
