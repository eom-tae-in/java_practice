package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class q_3460 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int num = Integer.parseInt(br.readLine());
            int location = 0;

            ArrayList<Integer> arr = new ArrayList<>();


            while (num != 0) {

                if (num % 2 == 1) {

                    arr.add(location);
                }
                num /= 2;
                location++;
            }
            for (int j = 0; j < arr.size(); j++) {
                sb.append(arr.get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
