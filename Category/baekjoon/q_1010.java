package Category.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class q_1010 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] array = new int[30][30];


        for (int i = 0; i < 30; i++) {
            array[i][i] = 1;
            array[i][0] = 1;
        }


        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {

                array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine(), " ");


            int N = Integer.parseInt(st.nextToken());	// N = r
            int M = Integer.parseInt(st.nextToken());	// M = n

            sb.append(array[M][N]).append('\n');
        }

        System.out.println(sb);

    }
}