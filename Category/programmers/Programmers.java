package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            System.out.println(solution(a));
        }

        public static boolean solution(int x) {
            boolean answer = true;
            String str = Integer.toString(x);
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            answer = x % sum == 0;
            return answer;
        }
    }
}