package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_4796 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 0;

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L + P + V == 0) {

                System.out.println(sb);
                return;
            }
            int Days = (V / P) * L + Math.min(V % P, L);
            count++;

            sb.append("Case ").append(count).append(": ").append(Days).append("\n");
        }
    }
}
