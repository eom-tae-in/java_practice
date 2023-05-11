package Category.baekjoon;

import java.util.*;

public class q_2667 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int[][] arrays;
    static boolean[][] check;
    static int count = 0;

    public static void dfs(int y, int x) {
        check[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((ny >= 0 && ny < n && nx >= 0 && nx < n) && !check[ny][nx] && arrays[ny][nx] == 1) {
                check[ny][nx] = true;
                count++;
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arrays = new int[n][n];
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                arrays[i][j] = str.charAt(j) - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arrays[i][j] == 1 && !check[i][j]) {
                    count = 0;
                    count++;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }
}
