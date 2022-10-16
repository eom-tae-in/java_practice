package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_5176 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int participant = Integer.parseInt(st.nextToken());
            int place = Integer.parseInt(st.nextToken());
            int people = 0;
            boolean[] p = new boolean[place + 1];

            for (int j = 0; j < participant; j++) {
                int s = Integer.parseInt(br.readLine());
                if (!p[s]) {
                    p[s] = true;
                } else {
                    people++;
                }
            }
            sb.append(people).append("\n");
        }
        System.out.println(sb);
    }
}
