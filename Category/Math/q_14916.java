package Category.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = N / 5;

        if (N == 1 || N == 3) {

            System.out.println(-1);
        }

        else {

            if ((N % 5) % 2 == 1) {

                count--;
                count += (N % 5 + 5) / 2;
            } else {
                count += (N % 5) / 2;
            }

            System.out.println(count);

        }
    }
}
