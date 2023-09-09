package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2475 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[5];
        int check = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++){

            a[i] = Integer.parseInt(st.nextToken());

            check += a[i] * a[i];
        }

        System.out.println(check % 10);
    }
}
