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

        public static int solution(String s) {
            int answer = 0;
            answer = Integer.parseInt(s);
            return answer;
        }
    }
}