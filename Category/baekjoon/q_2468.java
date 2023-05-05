package Category.baekjoon;

import java.util.Scanner;

public class q_2468 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int maxHeight;
    static boolean[][] check;
    static int[][] array;
    static int N;

    public static void dfs(int y, int x, int height) {
        check[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((nx >= 0 && nx < N && ny >= 0 && ny < N) && !check[ny][nx] && array[ny][nx] >= height) {
                dfs(ny, nx, height);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N][N];
        maxHeight = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.nextInt();
                if (array[i][j] > maxHeight) {
                    maxHeight = array[i][j];
                }
            }
        }
        int max = 0;
        int count = 0;
        for (int height = 1; height <= maxHeight; height++) {
            check = new boolean[N][N];
            count = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] >= height && !check[i][j]) {
                        count++;
                        dfs(i, j, height);
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
