package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_3003 {

    public static void main(String[] args) throws IOException {

        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] num = new int[6];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 6; i++) {

            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {

            sb.append(chess[i] - num[i]).append(" ");
        }

        System.out.println(sb);
    }
}
