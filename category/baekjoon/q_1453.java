package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1453 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean[] seat = new boolean[101];

        int deniedPeople = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < T; i++) {

            int num = Integer.parseInt(st.nextToken());

            if (seat[num]) {
                deniedPeople++;
            } else {
                seat[num] = true;
            }
        }
        System.out.println(deniedPeople);
    }
}
