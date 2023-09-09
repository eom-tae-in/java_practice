package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_11134 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (N % C == 0){

                sb.append(N / C).append("\n");
            }
            else {
                sb.append(N / C + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
