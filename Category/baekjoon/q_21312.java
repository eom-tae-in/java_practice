package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_21312 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A % 2 == 1) {
            if (B % 2 == 1) {
                if (C % 2 == 1) {
                    System.out.println(A * B * C);
                    return;
                }
                System.out.println(A * B);
                return;
            } else if (C % 2 == 1) {
                System.out.println(A * C);
                return;
            }
            System.out.println(A);
            return;
        } else if (B % 2 == 1) {
            if (C % 2 == 1) {
                System.out.println(B * C);
                return;
            }
            System.out.println(B);
            return;
        } else if (C % 2 == 1) {
            System.out.println(C);
            return;
        }
        System.out.println(A * B * C);
    }
}
