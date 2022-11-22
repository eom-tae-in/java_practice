package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(solution(n, m));
        }
            public static long solution(int a, int b) {
                long answer = 0;
                for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
                    answer += i;
                }
                return answer;
            }
    }
}