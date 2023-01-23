package Category.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Programmers {

    static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String my_string = br.readLine();
            System.out.println(solution(my_string));
        }
        public static String solution(String my_string) {
            String answer = "";
            for (int i = 0; i < my_string.length(); i++) {
                if (my_string.indexOf(my_string.charAt(i)) == i) {
                    answer += my_string.charAt(i);
                }
            }
            return answer;
        }
    }
}