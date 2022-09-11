package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_15904 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;

        for (int i = 0; i < str.length(); i++) {

            if (ucpc[index] == str.charAt(i)) {
                index++;
            }

            if (index == 4) {
                break;
            }
        }

        System.out.println(index == 4 ? "I love UCPC" : "I hate UCPC");
    }
}
