package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_4619 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while (true) {
            st = new StringTokenizer(br.readLine());

            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (B == 0 && N == 0) {
                break;
            }
            double num = Math.pow(B, 1.0 / N);

            int N1 = (int) Math.ceil(num);
            int N2 = (int) Math.floor(num);
            int num1 = (int) Math.pow(N1, N) - B;
            int num2 =  B - (int) Math.pow(N2, N);

            int min = Math.min(num1,num2);
            if (min == num1) {
                sb.append(N1).append("\n");
            } else {
                sb.append(N2).append("\n");
            }
        }
        System.out.println(sb);
    }
}
