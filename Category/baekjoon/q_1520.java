package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_1520 {

    static int[][] location, dp;
    static int n, m;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static int dfs(int y, int x) {
        if (dp[y][x] != Integer.MIN_VALUE) {
            return dp[y][x];
        }
        if (y == n - 1 && x == m - 1) {
            return 1;
        }
        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((ny >= 0 && ny < n && nx >= 0 && nx < m) && location[y][x] > location[ny][nx]) {
                dp[y][x] += dfs(ny, nx);
            }
        }
        return dp[y][x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        location = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                location[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 0));
    }
}
