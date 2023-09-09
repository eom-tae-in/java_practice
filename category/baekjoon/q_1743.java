package category.baekjoon;

import java.util.Scanner;

public class q_1743 {


    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] ch;

    static int n;
    static int m;
    static int csum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        int[][] floor = new int[n + 1][m + 1];
        ch = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            floor[y][x] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (floor[i][j] == 1 && !ch[i][j]) {
                    csum = 1;
                    dfs(i, j, floor);
                    sum = Math.max(sum, csum);
                }
            }
        }
        System.out.println(sum);

    }

    public static void dfs(int y, int x, int[][] floor) {
        ch[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int cy = y + dy[i];
            int cx = x + dx[i];
            if (cx >= 0 && cx < m + 1 && cy >= 0 && cy < n + 1) {
                if (floor[cy][cx] == 1 && !ch[cy][cx]) {
                    csum++;
                    dfs(cy, cx, floor);
                }
            }
        }
    }
}
