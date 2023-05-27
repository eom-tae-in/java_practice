package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q_14502 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] location;
    static int n, m, max = Integer.MIN_VALUE;

    static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

     public static void dfs(int count) {
        if (count == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (location[i][j] == 0) {
                    location[i][j] = 1;
                    dfs(count + 1);
                    location[i][j] = 0;
                }
            }
        }
    }

     public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (location[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }
        int[][] copyLocation = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyLocation[i] = location[i].clone();
        }
        while (!queue.isEmpty()) {
            Node cv = queue.poll();
            int cy = cv.y;
            int cx = cv.x;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if ((ny >= 0 && ny < n & nx >= 0 && nx < m) && copyLocation[ny][nx] == 0) {
                    copyLocation[ny][nx] = 2;
                    queue.add(new Node(ny, nx));
                }
            }
        }
        countSafeArea(copyLocation);
    }

    public static void countSafeArea(int[][] copyLocation) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyLocation[i][j] == 0) {
                    sum++;
                }
            }
        }
        max = Math.max(max, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        location = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                location[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }
}
