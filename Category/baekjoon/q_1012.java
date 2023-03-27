package Category.baekjoon;

import java.util.Scanner;

public class q_1012 {
    static boolean[][] location;
    static int[][] ground;
    static int width;
    static int height;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            width = sc.nextInt();
            height = sc.nextInt();
            int cabbage = sc.nextInt();
            location = new boolean[height][width];
            ground = new int[height][width];
            for (int j = 0; j < cabbage; j++) {
                int w = sc.nextInt();
                int h = sc.nextInt();
                ground[h][w] = 1;
            }
            int count = 0;
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (ground[j][k] == 1 && !location[j][k]) {
                        dfs(j,k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int h, int w) {
        location[h][w] = true;
        for (int i = 0; i < 4; i++) {
            int cy = h + dy[i];
            int cx = w + dx[i];
            if (cx < 0 || cx >= width || cy < 0 || cy >= height) {
                continue;
            }
            if (ground[cy][cx] == 1 && !location[cy][cx]) {
                dfs(cy, cx);
            }
        }
    }
}
