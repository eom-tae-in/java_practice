package Category.baekjoon;

import java.util.Scanner;

public class q_4963 {

    static int w, h;
    static int[][] array;
    static boolean[][] check;

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void dfs(int y, int x) {
        if (check[y][x]) {
            return;
        }
        check[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((ny >= 0 && ny < h && nx >= 0 && nx < w) && !check[ny][nx] && array[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            array = new int[h][w];
            check = new boolean[h][w];
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!check[i][j] && array[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

}
