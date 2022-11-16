package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            System.out.println(solution(str));
        }

        static boolean solution(String s) {
            boolean answer = true;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                    count++;
                }
                if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                    count--;
                }
            }
            if (count != 0) {
                answer = false;
            }
            return answer;
        }
    }
}