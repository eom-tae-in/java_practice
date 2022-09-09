package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_2720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] unit = {25, 10, 5, 1};
        int[] count = new int[4];

        for (int i = 0; i < T; i++) {

            int price = Integer.parseInt(br.readLine());

            for (int j = 0; j < unit.length; j++) {

                count[j] = price / unit[j];
                price = price % unit[j];
                sb.append(count[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


}
