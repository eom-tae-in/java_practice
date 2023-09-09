package category.baekjoon;

import java.util.Scanner;

public class q_1926 {

    static boolean[][] check;
    static int[][] board;
    static int width, height, count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int y, int x) {
        check[y][x] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < height && ny >= 0 && nx < width && nx >= 0 && !check[ny][nx] && board[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        int result = 0;
        int max = Integer.MIN_VALUE;
        check = new boolean[height][width];
        board = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1 && !check[i][j]) {
                    result++;
                    count = 0;
                    dfs(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        if (result == 0) {
            max = 0;
        }
        System.out.println(result);
        System.out.println(max);
    }
}
