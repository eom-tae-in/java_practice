package category.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q_2583 {
    static boolean[][] graph;
    static int Y, X, k, count, area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void dfs(int y, int x) {
        graph[y][x] = true;
        area++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((ny >= 0 && ny < Y && nx >= 0 && nx < X) && !graph[ny][nx]) {
                dfs(ny, nx);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();
        k = sc.nextInt();
        ArrayList<Integer> totalArea = new ArrayList<>();
        graph = new boolean[Y][X];
        for (int i = 0; i < k; i++) {
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int fx = sc.nextInt();
            int fy = sc.nextInt();
            for (int j = Y - fy; j < Y - sy; j++) {
                for (int n = sx; n < fx; n++) {
                    if (!graph[j][n]) {
                        graph[j][n] = true;
                    }
                }
            }
        }
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (!graph[i][j]) {
                    area = 0;
                    count++;
                    dfs(i, j);
                    totalArea.add(area);
                }
            }
        }
        Collections.sort(totalArea);
        System.out.println(count);
        for (int i : totalArea) {
            System.out.print(i + " ");
        }
    }
}
