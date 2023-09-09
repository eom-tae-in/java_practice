package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_6502 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count = 1;

        while (true) {

            st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 1) {
                break;
            }
            int table = Integer.parseInt(st.nextToken());
            int pizzaWidth = Integer.parseInt(st.nextToken());
            int pizzaHeight = Integer.parseInt(st.nextToken());

            double max = Math.sqrt(Math.pow(pizzaHeight, 2) + Math.pow(pizzaWidth, 2));

            if (max <= table * 2) {
                sb.append("Pizza ").append(count).append(" fits on the table.").append("\n");
            } else {
                sb.append("Pizza ").append(count).append(" does not fit on the table.").append("\n");
            }
            count++;
        }
        System.out.println(sb);
    }
}
