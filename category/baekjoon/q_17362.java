package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_17362 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int num = T % 8;

        if (num == 2 || num == 0) {
            System.out.println(2);
        } else if (num == 3 || num == 7) {
            System.out.println(3);
        } else if (num == 4 || num == 6) {
            System.out.println(4);
        } else if (num == 5) {
            System.out.println(5);
        } else {
            System.out.println(1);
        }

    }
}
