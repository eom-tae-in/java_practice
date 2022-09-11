package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_9461 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 파도반 수열의 경우 N이 100일 때 9000억 가까이 되므로 long타입으로 선언
        long[] arr = new long[101];

        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;


        for(int i = 3; i < 101; i++){

            arr[i] = arr[i-3] + arr[i-2];
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++){

            int N = Integer.parseInt(br.readLine());

            sb.append(arr[N]).append("\n");
        }

        System.out.println(sb);

    }
}
