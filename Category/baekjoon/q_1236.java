package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1236 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] strs = new String[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                strs[i][j] = String.valueOf(str.charAt(j));
            }
        }

        boolean[] column = new boolean[M];
        int col = 0;
        boolean[] rows = new boolean[N];
        int row = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (strs[i][j].equals("X")) {
                    rows[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            if (!column[i]) {
                col++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (!rows[i]) {
                row++;
            }
        }
        System.out.println(Math.max(row, col));
    }
}
