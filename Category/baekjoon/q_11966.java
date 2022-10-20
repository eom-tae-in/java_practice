package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_11966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[31];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int) Math.pow(2, i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == T) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
