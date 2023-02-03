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
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            answer = new StringBuilder(String.valueOf(charArray)).reverse().toString();
            return answer;
        }
    }
}