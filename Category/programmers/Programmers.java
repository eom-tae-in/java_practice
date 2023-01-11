package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            System.out.println(solution(str));
        }

        public static int solution(String my_string) {
            int answer = 0;
            for (int i = 0; i < my_string.length(); i++) {
                if (Character.isDigit(my_string.charAt(i))) {
                    answer += my_string.charAt(i) - '0';
                }
            }
            return answer;
        }
    }
}