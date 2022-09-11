package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_1500 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long sum = 1;
        Arrays.fill(arr, S / K);

        int R = S % K;

        for (int i = 0; i < R; i++){

            arr[i]++;
        }
        for (int i = 0; i < K; i++){

            sum *= arr[i];
        }
        System.out.println(sum);
    }
}
