package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_25496 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = 200 - Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int i = 0;
        while (P > 0) {
            P -= arr[i];
            i++;
            count++;
            if (i == arr.length) {
                break;
            }
        }
        System.out.println(count);
    }
}
