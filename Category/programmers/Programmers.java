package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String cipher = sc.next();
            int code = sc.nextInt();
            System.out.println(solution(cipher, code));
        }
        public static String solution(String cipher, int code) {
            String answer = "";
            for (int i = code - 1; i < cipher.length(); i += code) {
                answer += cipher.charAt(i);
            }
            return answer;
        }
    }
}