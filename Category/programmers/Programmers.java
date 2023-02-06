package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            System.out.println(solution(s));
        }

        public static boolean solution(String s) {
            boolean answer = true;
            int stringLength = s.length();
            if (!(stringLength == 4 || stringLength == 6)) {
                answer = false;
                return answer;
            }
            for (int i = 0; i < stringLength; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    answer = false;
                    return answer;
                }
            }
            return answer;
        }
    }
}