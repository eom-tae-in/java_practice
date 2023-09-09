package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1350 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[T];
        long sum = 0;

        for (int i = 0; i < T; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

        }
        int cluster = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            } else if (arr[i] > cluster) {
                if (arr[i] % cluster != 0) {
                    sum += ((arr[i] / cluster) + 1) * cluster;
                } else {
                    sum += (arr[i] / cluster) * cluster;
                }
            } else {
                sum += cluster;
            }
        }
        System.out.println(sum);

    }
}
