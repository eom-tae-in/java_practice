package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_1100 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        for (int i = 0; i < 8; i++) {

            String str = br.readLine();
            String s = "";
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j += 2) {
                    if (str.charAt(j) == 'F') {
                        count++;
                    }
                }
            } else {
                for (int j = 1; j < 8; j += 2) {
                    if (str.charAt(j) == 'F') {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
