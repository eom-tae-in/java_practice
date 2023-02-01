package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            System.out.println(solution(s));
        }

        public static String solution(String s) {
            String answer = "";
            if (s.length() % 2 == 0) {
                answer += s.charAt(s.length() / 2 - 1);
                answer += s.charAt(s.length() / 2);
                return answer;
            }
            answer += s.charAt(s.length() / 2);
            return answer;
        }
    }
}