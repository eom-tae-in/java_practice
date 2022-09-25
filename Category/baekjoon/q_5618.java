package Category.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_5618 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int a, b, c;

        if (T == 2) {

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= Math.min(a, b); i++) {

                if (a % i == 0 && b % i == 0) {

                    sb.append(i).append("\n");
                }
            }
        } else {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= Math.min(a, Math.min(b, c)); i++) {

                if (a % i == 0 && b % i == 0 && c % i == 0) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}


