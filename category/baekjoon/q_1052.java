package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count;
        if (N <= K) {
            System.out.println(0);
            return;
        }
        int buy = 0;
        while (true) {
            count = 0;
            int num = N;
            while (num != 0) {
                if (num % 2 == 1) {
                    count += 1;
                }
                num /= 2;
            }
            if (count <= K){
                break;
            }
            N += 1;
            buy += 1;

        }
        System.out.println(buy);

    }
}
