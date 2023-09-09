package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int sum = 0;
        int price = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < T; i++) {
            sum += arr[i];
            arr[i] = sum;
            price += arr[i];
        }

        System.out.println(price);

    }
}
