package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str1 = sc.next();
            String str2 = sc.next();
            System.out.println(solution(str1, str2));
        }

        public static int solution(String str1, String str2) {
            int answer = 0;
            if (str1.contains(str2)) {
                answer = 1;
            } else {
                answer = 2;
            }
            return answer;
        }
    }
}