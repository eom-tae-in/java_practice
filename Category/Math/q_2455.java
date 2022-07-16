package Category.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_2455 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] A = new int[4];
        int[] B = new int[4];
        int[] sum = new int[5];
        sum[0] = 0;

        StringTokenizer st;

        for (int i = 0; i < 4; i++){

            st = new StringTokenizer(br.readLine(), " ");

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 5; i++){

            sum[i] = sum[i-1] - A[i-1] + B[i-1];
        }

        Arrays.sort(sum);

        System.out.println(sum[4]);
    }
}
