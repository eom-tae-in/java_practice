package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_14470 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int second = 0;
        if (A < 0) {

            second = Math.abs(A) * C + D + B * E;
        } else if (A == 0) {
            second = D + B * E;
        } else {
            second = (B - A) * E;
        }
        System.out.println(second);
    }
}
