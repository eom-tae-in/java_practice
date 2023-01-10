package Category.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers {

    static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            System.out.println(solution(str));
        }

        public static String solution(String my_string) {
            String answer = "";
            for (int i = 0; i < my_string.length(); i++) {
                if (my_string.charAt(i) == 'a' ||
                  my_string.charAt(i) == 'e' ||
                  my_string.charAt(i) == 'i' ||
                  my_string.charAt(i) == 'o' ||
                  my_string.charAt(i) == 'u') {
                    continue;
                }
                answer += my_string.charAt(i);
            }
            return answer;
        }
    }
}