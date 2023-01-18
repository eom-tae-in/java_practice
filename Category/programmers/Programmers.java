package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            System.out.println(solution(age));
        }

        public static String solution(int age) {
            String answer = "";
            String str = Integer.toString(age);
            for (int i = 0; i < str.length(); i++) {
                answer += Character.toString(str.charAt(i) + (char) 49);
            }
            return answer;
        }
    }
}