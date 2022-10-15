package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_11943 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] apple = new int[2];
        int[] orange = new int[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            apple[i] = Integer.parseInt(st.nextToken());
            orange[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.min(apple[0] + orange[1], apple[1] + orange[0]));
    }
}
