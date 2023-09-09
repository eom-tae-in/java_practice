package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] time = new int[S + 1];
        int count = 0;

        for (int i = 0; i < N; i++) {
            int per = Integer.parseInt(br.readLine());
            int c = S / per;
            for (int j = 1; j <= c; j++) {
                time[j * per]++;
            }
        }
        for (int i = 1; i < time.length; i++) {
            if (time[i] >= 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
