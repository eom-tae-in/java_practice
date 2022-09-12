package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_14720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        int count = 0;
        int type = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < T; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

            if (type == arr[i]) {
                type++;
                count++;
            }
            if (type == 3) {
                type = 0;
            }
        }


        System.out.println(count);
    }
}
