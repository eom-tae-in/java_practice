package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1173 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int current = m;
        int count = 0;

        if (m + T > M) {
            System.out.println(-1);
            return;
        }


        while (N > 0) {

            if (current + T > M) {
                current -= R;
                count++;
                if (current < m) {
                    current = m;
                }
            } else {
                current += T;
                N--;
                count++;
            }
        }
        System.out.println(count);

    }
}

