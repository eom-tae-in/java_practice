package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_23795 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int a;

        while ((a = Integer.parseInt(br.readLine())) != -1) {
            sum += a;
        }

        System.out.println(sum);
    }
}
