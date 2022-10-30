package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_25238 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (B == 100) {
            System.out.println(1);
        } else {
            if ((A * 100 - (A * B)) >= 10000) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
}
