package Category.programmers;

import Category.programmers.Programmers.Solution;
import java.io.IOException;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            System.out.println(solution(T));
        }

        public static int solution(int n) {
            int answer = 0;
            if (n == 1) {
                answer = 1;
                return answer;
            }
            for (int i = 1; i <= (int)Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (i != n / i) {
                        answer += n / i;
                    }
                    answer += i;
                }
            }
            return answer;
        }
    }
}