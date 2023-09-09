package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_25373 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int a = T / 7;
        int sum = 0;
        for (int i = a - 3; i < a + 3; i++) {
            sum += i;
        }
        System.out.println(T - sum);

    }
}
