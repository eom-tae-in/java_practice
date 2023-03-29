package Category.baekjoon;

import java.util.Scanner;

public class q_1388 {

    static int[][] height = {{0, 1}, {0, -1}};
    static int[][] width = {{1, 0}, {-1, 0}};

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
                    System.out.println(i+" : " + j);
                    dfs(i, j, floor);
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y, char[][] floor) {
        ch[x][y] = true;
        if (floor[x][y]== '-') {
            for (int i = 0; i < width.length; i++) {
                int cx = x + width[i][0];
                int cy = y + width[i][1];
                System.out.println("x :" + cx + " y :" + cy);
                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (floor[cx][cy]== '-' && !ch[cx][cy]) {
                        System.out.println("cx :" + cx + " cy :" + cy);
                        dfs(cx, cy, floor);

                    }
                }
            }
        }
        if (floor[x][y] == '|') {
            for (int i = 0; i < height.length; i++) {
                int cx = x + height[i][0];
                int cy = y + height[i][1];
                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (floor[cx][cy] == '|' && !ch[cx][cy]) {
                        dfs(cx, cy, floor);
                    }
                }
            }
        }


    }
}
