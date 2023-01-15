package Category.programmers;


import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(solution(i, j, k));
        }

        public static int solution(int i, int j, int k) {
            int answer = 0;
            for (int a = i; a <= j; a++) {
                String num = Integer.toString(a);
                for (int b = 0; b < num.length(); b++) {
                    if (num.charAt(b) - '0' == k) {
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}