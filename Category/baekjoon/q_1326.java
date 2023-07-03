package Category.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q_1326 {

    static class Board {

        int position;
        int sum;
        int value;

        public Board(int position, int sum, int value) {
            this.position = position;
            this.sum = sum;
            this.value = value;
        }
    }
    static int total = Integer.MAX_VALUE;

    static boolean[] ch;

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] bridge = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            bridge[i] = sc.nextInt();
        }
        ch = new boolean[n + 1];
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(bfs(bridge, a, b));
    }

    public static int bfs(int[] bridge, int a, int b) {
        Queue<Board> queue = new LinkedList<>();
        queue.add(new Board(a, bridge[a], 0));
        ch[a] = true;

        while (!queue.isEmpty()) {
            Board board = queue.remove();

            if (board.position == b) {
                total = Math.min(board.sum, total);
                break;
            }
            for (int i = 1; i < bridge.length; i++) {
                if (Math.abs(i - board.position) % bridge[board.position] == 0 && !ch[i]) {
                    ch[i] = true;
                    queue.add(new Board(i, bridge[i], board.sum + 1));
                }
            }
        }
        if (total == Integer.MAX_VALUE) {
            return -1;
        }
        return total;
    }
}