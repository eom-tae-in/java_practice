package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_3059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean[] alphabet = new boolean[26];
            int sum = 0;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {

                int num = str.charAt(j) - 'A';
                if (!alphabet[num]) {
                    alphabet[num] = true;
                }
            }
            for (int k = 0; k < alphabet.length; k++) {
                if (!alphabet[k]) {
                    sum += k + 'A';
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
