package Category.baekjoon;

import java.util.Scanner;

public class q_2468 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int maxHeight;

    static boolean[][] calculate;

    static boolean[][] check;

    static int[][] array;

    static int N;


    public static void dfs(int x, int y, int height) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx >= 0 && nx < N && ny >= 0 && ny < N) && !check[nx][ny] && array[nx][ny] >= height) {
                dfs(nx, ny, height);
            }
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N][N];
        calculate = new boolean[N][N];
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
        for (int height = 2; height <= maxHeight; height++) {
            check = new boolean[N][N];
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
