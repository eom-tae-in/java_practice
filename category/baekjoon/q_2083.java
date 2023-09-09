package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2083 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        while (true) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (str.equals("#") || age == 0 || weight == 0) {
                break;
            }

            if (age > 17 || weight >= 80) {
                sb.append(str).append(" ").append("Senior").append("\n");
            } else {
                sb.append(str).append(" ").append("Junior").append("\n");
            }
        }
        System.out.println(sb);
    }
}
