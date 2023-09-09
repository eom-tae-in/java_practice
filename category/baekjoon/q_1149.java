package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1149 {

    static final int Red = 0;
    static final int Green = 1;
    static final int Blue = 2;
    static int[][] Cost;
    static int[][] Dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Cost = new int[T][3];
        Dp = new int[T][3];


        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Cost[i][Red] = Integer.parseInt(st.nextToken());
            Cost[i][Green] = Integer.parseInt(st.nextToken());
            Cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        Dp[0][Red] = Cost[0][Red];
        Dp[0][Green] = Cost[0][Green];
        Dp[0][Blue] = Cost[0][Blue];

        System.out.println(Math.min(costMin(T - 1, Red), Math.min(costMin(T - 1, Green), costMin(T - 1, Blue))));
    }


    static int costMin(int N, int color) {

        if (Dp[N][color] == 0) {

            if (color == Red) {
                Dp[N][Red] = Math.min(costMin(N - 1, Green), costMin(N - 1, Blue)) + Cost[N][Red];
            } else if (color == Green) {
                Dp[N][Green] = Math.min(costMin(N - 1, Red), costMin(N - 1, Blue)) + Cost[N][Green];
            } else {
                Dp[N][Blue] = Math.min(costMin(N - 1, Red), costMin(N - 1, Green)) + Cost[N][Blue];
            }
        }
        return Dp[N][color];
    }
}
