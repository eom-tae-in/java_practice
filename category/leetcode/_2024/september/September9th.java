package category.leetcode._2024.september;

import java.util.Arrays;

public class September9th {

    public int[][] spiralMatrix(
            final int m,
            final int n,
            final ListNode head
    ) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] answer = new int[m][n];
        Arrays.stream(answer)
                .forEach(row -> Arrays.fill(row, -1));
        int rowIndex = 0;
        int columnIndex = 0;
        int directionsIndex = 0;
        for (ListNode current = head; current != null; current = current.next) {
            answer[rowIndex][columnIndex] = current.val;
            if (isChangeDirectionCase(answer, directions, directionsIndex, rowIndex, columnIndex, m, n)) {
                directionsIndex = (directionsIndex + 1) % 4;
            }
            rowIndex += directions[directionsIndex][0];
            columnIndex += directions[directionsIndex][1];
        }

        return answer;
    }

    private boolean isChangeDirectionCase(
            final int[][] answer,
            final int[][] directions,
            final int directionsIndex,
            final int rowIndex,
            final int columnIndex,
            final int rowLength,
            final int columnLength
    ) {
        int nextRowIndex = rowIndex + directions[directionsIndex][0];
        int nextColumnIndex = columnIndex + directions[directionsIndex][1];

        return nextRowIndex < 0 ||
                nextRowIndex == rowLength ||
                nextColumnIndex < 0 ||
                nextColumnIndex == columnLength ||
                answer[nextRowIndex][nextColumnIndex] != -1;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
