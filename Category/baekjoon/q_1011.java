package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1011 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int price = (int) Math.sqrt(Y - X);

            if (Y - X == Math.pow(price, 2)) {
                sb.append(2 * price - 1).append("\n");
            } else if (Y - X <= Math.pow(price, 2) + price) {
                sb.append(2 * price).append("\n");
            } else {
                sb.append(2 * price + 1).append("\n");
            }
        }

        System.out.println(sb);

    }
}
