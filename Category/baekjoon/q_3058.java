package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_3058 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] arr = new int[7];

        for (int i = 0; i < T; i++) {

            int sum = 0;
            int min = 101;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 7; j++) {

                arr[j] = Integer.parseInt(st.nextToken());

                if (arr[j] % 2 == 0) {

                    sum += arr[j];
                    if (min > arr[j]) {
                        min = arr[j];
                    }
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }
}
