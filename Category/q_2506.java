package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2506 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;
        int count = 0;

        for (int i = 0; i < T; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == 1) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }

        System.out.println(sum);


    }
}
