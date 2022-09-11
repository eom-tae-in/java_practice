package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_16917 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        if (A + B > 2 * C) {
            int P = Math.min(X, Y);
            int cheap;
            if (P == X) {
                if (B > 2 * C) {
                    cheap = (Y - P) * 2 * C;
                } else {
                    cheap = (Y - P) * B;
                }
            } else {
                if ((A > 2 * C)) {
                    cheap = (X - P) * 2 * C;
                } else {
                    cheap = (X - P) * A;
                }
            }
            System.out.println(P * C * 2 + cheap);
        } else {
            System.out.println(X * A + Y * B);
        }
    }
}
