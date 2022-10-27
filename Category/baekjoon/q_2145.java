package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_2145 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.equals("0")) {
                break;
            }

            while (true) {
                int sum = 0;

                for (int i = 0; i < str.length(); i++) {
                    sum += str.charAt(i) - '0';
                }
                str = String.valueOf(sum);

                if (sum < 10) {
                    sb.append(sum).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
