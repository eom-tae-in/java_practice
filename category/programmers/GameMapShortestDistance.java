package category.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameMapShortestDistance {

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] ch;

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] maps = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                maps[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps)  {
        n = maps.length;
        m = maps[0].length;
        ch = new int[n][m];
        bfs(maps, 0, 0);
        return ch[n - 1][m - 1] == 0 ? -1 : ch[n - 1][m - 1];
    }

    public static void bfs(int[][] maps, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        ch[y][x] = 1;
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] cLocation = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cLocation[0] + dy[i];
                int nx = cLocation[1] + dx[i];
                if (ny < n && ny >= 0 && nx < m && nx >= 0) {
                    if (ch[ny][nx] == 0 && maps[ny][nx] == 1) {
                        ch[ny][nx] = ch[cLocation[0]][cLocation[1]] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
