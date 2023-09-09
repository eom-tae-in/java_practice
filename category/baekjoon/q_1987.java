package category.baekjoon;

import java.util.Scanner;

public class q_1987 {

    static char[][] array;
    static boolean[] check;
    static int w, h, max = Integer.MIN_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int y, int x, int len) {
        check[array[y][x] -  'A'] = true;
        max = Math.max(max, len);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((ny >= 0 && ny < h && nx >= 0 && nx < w) && !check[array[ny][nx] - 'A']) {
                dfs(ny, nx, len + 1);
                check[array[ny][nx] - 'A'] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        array = new char[h][w];
        check = new boolean[26];
        for (int i = 0; i < h; i++) {
            String str = sc.next();
            for (int j = 0; j < w; j++) {
                array[i][j] = str.charAt(j);
            }
        }
        dfs(0,0, 1);
        System.out.println(max);
    }
}
