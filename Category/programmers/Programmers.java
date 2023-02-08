package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(solution(n));
        }

        public static int solution(int n) {
            int answer = 0;
            for (int i = 4; i <= n; i++) {
                if (compositionNumber(i)) {
                    answer++;
                }
            }
            return answer;
        }

        public static boolean compositionNumber(int number) {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    return true;
                }
            }
            return false;
        }
    }
}