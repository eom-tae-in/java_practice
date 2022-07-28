package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_13410 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[B];

        for (int i = 1; i <= B; i++){

            arr[i-1] = A * i;

            if (arr[i-1] >= 10) {

                arr[i-1] = (arr[i-1] % 10) * 10 + arr[i-1] / 10;
            }
        }
        Arrays.sort(arr);

        System.out.println(arr[B-1]);

    }
}
