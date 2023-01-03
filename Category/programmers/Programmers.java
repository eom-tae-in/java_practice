package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            System.out.println(solution(str));
        }

        public static String solution(String rsp) {
            String answer = "";
            for (int i = 0; i < rsp.length(); i++) {
                if (rsp.charAt(i) == '2') {
                    answer += "0";
                } else if (rsp.charAt(i) == '0') {
                    answer += "5";
                } else {
                    answer += "2";
                }
            }
            return answer;
        }
    }
}