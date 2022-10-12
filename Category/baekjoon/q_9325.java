package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_9325 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int total = 0;

            int car = Integer.parseInt(br.readLine());
            int option = Integer.parseInt(br.readLine());

            if (option != 0) {
                for (int j = 0; j < option; j++) {
                    st = new StringTokenizer(br.readLine());
                    int p = Integer.parseInt(st.nextToken());
                    int q = Integer.parseInt(st.nextToken());
                    total += p * q;
                }
            }
            total += car;

            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}
