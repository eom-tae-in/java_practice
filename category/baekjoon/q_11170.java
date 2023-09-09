package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_11170 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = 0;

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j = N; j <= M; j++) {

                String str = String.valueOf(j);

                for (int k = 0; k < str.length(); k++) {

                    if (str.charAt(k) == '0') {

                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }


        System.out.println(sb);
    }
}
