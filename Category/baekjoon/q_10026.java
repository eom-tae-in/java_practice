package Category.baekjoon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class q_10026 {

    static char[][] array;
    static boolean[][] check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;

    public static void ordinaryDfs(int y, int x, char ch) {
        if (check[y][x]) {
            return;
        }
        check[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((ny < N && ny >= 0 && nx < N && nx >= 0) && !check[ny][nx] && array[ny][nx] == ch) {
                ordinaryDfs(ny, nx, ch);
            }
        }
    }

    public static void colorBlindDfs(int y, int x, char ch) {
        if (check[y][x]) {
            return;
        }
        check[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ch == 'R' || ch == 'G') {
                if ((ny < N && ny >= 0 && nx < N && nx >= 0) && !check[ny][nx] && (array[ny][nx] == 'R' || array[ny][nx] == 'G')) {
                    colorBlindDfs(ny, nx, ch);
                }
            } else {
                if ((ny < N && ny >= 0 && nx < N && nx >= 0) && !check[ny][nx] && array[ny][nx] == 'B') {
                    colorBlindDfs(ny, nx, ch);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new char[N][N];
        check = new boolean[N][N];
        int colorBlindCase = 0;
        int ordinaryCase = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                array[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    char ch = array[i][j];
                    ordinaryCase++;
                    ordinaryDfs(i, j, ch);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(check[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    char ch = array[i][j];
                    colorBlindCase++;
                    colorBlindDfs(i, j, ch);
                }
            }
        }
        System.out.println(ordinaryCase + " " + colorBlindCase);
    }


}
