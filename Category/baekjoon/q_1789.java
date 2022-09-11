package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_1789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int sum = 0;
        int count = 0;

        for (int i = 1; sum + i < T; i++){

            sum += i;
            count++;

        }

        System.out.println(count);


    }
}