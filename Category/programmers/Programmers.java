package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String strings = sc.next();
            System.out.println(solution(strings));
        }
        public static String solution(String phone_number) {
            String answer = "";
            for (int i = 0; i < phone_number.length() - 4; i++) {

                answer += "*";
            }
            answer += phone_number.substring(phone_number.length() - 4);
            return answer;
        }
    }
}