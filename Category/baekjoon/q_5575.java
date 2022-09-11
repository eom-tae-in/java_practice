package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_5575 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] H = new int[2];
        int[] M = new int[2];
        int[] S = new int[2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            H[0] = Integer.parseInt(st.nextToken());
            M[0] = Integer.parseInt(st.nextToken());
            S[0] = Integer.parseInt(st.nextToken());
            H[1] = Integer.parseInt(st.nextToken());
            M[1] = Integer.parseInt(st.nextToken());
            S[1] = Integer.parseInt(st.nextToken());

            if (S[1] < S[0]) {
                S[1] += 60;
                M[1] -= 1;
            }
            if (M[1] < M[0]) {
                M[1] += 60;
                H[1] -= 1;
            }
            sb.append(H[1] - H[0]).append(" ").append(M[1] - M[0]).append(" ").append(S[1] - S[0]).append("\n");
        }
        System.out.println(sb);

    }
}
