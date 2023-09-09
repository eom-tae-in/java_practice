package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_13866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[4];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int A = arr[1] + arr[2];
        int B = arr[0] + arr[3];

        System.out.println(Math.max(A, B) - Math.min(A, B));
    }
}
