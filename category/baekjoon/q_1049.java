package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_1049 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] all = new int[M];
        int[] one = new int[M];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            all[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(all);
        Arrays.sort(one);

        if (all[0] < one[0] * 6) {
            System.out.println(all[0] * (N / 6) + Math.min(all[0], one[0] * (N % 6)));
        }
        else {
            System.out.println(one[0] * N);
        }
    }
}
