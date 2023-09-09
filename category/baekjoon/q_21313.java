package category.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q_21313 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean odd = false;

        if (T % 2 == 1) {
            odd = true;
            T--;
        }

        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            if (T % 2 == 0) {
                sb.append(1).append(" ");
            } else {
                sb.append(2).append(" ");
            }
            T--;
        }
        if (odd) {
            sb.append(3);
        }

        System.out.println(sb);
    }
}
