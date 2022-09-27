package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_13410 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = N * (i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            String str = String.valueOf(arr[i]);
            String reverse = "";
            for (int j = 0; j < str.length(); j++) {
                reverse += str.charAt(str.length() - (1 + j));
            }
            arr[i] = Integer.parseInt(reverse);
        }
        Arrays.sort(arr);

        System.out.println(arr[K - 1]);
    }
}
