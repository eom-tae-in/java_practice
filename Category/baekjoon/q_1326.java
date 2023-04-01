package Category.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q_1326 {

    static class Board {

        int position;
        int sum;
        public Board(int position, int sum) {
            this.position = position;
            this.sum = sum;
        }
    }
    static int total = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] bridge = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            bridge[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(bfs(bridge, a, b));
    }

    public static int bfs(int[] bridge, int a, int b) {
        Queue<Board> queue = new LinkedList<>();
        queue.add(new Board(a, 0));

        while (!queue.isEmpty()) {
            Board board = queue.remove();

            if (board.position == b) {
                total = Math.min(board.sum, total);
            }
            for (int i = board.position + 1; i <= b; i++) {
                if ((i - board.position) % bridge[board.position] == 0) {
                    queue.add(new Board(i, board.sum + 1));
                }
            }
        }
        if (total == Integer.MAX_VALUE) {
            return -1;
        }

        return total;
    }
}
