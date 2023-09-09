package category.baekjoon;

import java.util.Scanner;

public class q_1388 {
    static int[][] height = {{1, 0}, {-1, 0}};
    static int[][] width = {{0, 1}, {0, -1}};

    static boolean[][] ch;
    static int n;
    static int m;


    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] floor = new char[n][m];
        ch = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                floor[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!ch[i][j]) {
                    answer++;
                    dfs(i, j, floor);
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int y, int x, char[][] floor) {
        ch[y][x] = true;
        if (floor[y][x]== '-') {
            for (int i = 0; i < width.length; i++) {
                int cy = y + width[i][0];
                int cx = x + width[i][1];
                if (cx >= 0 && cx < m && cy >= 0 && cy < n) {
                    if (floor[cy][cx]== '-' && !ch[cy][cx]) {
                        dfs(cy, cx, floor);

                    }
                }
            }
        }
        if (floor[y][x] == '|') {
            for (int i = 0; i < height.length; i++) {
                int cy = y + height[i][0];
                int cx = x + height[i][1];
                if (cx >= 0 && cx < m && cy >= 0 && cy < n) {
                    if (floor[cy][cx] == '|' && !ch[cy][cx]) {
                        dfs(cy, cx, floor);
                    }
                }
            }
        }
    }
}
