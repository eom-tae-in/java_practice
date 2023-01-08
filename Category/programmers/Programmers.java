package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            System.out.println(solution(num));
        }

        public static int solution(int n) {
            int answer = 0;
            if (Math.sqrt(n) % 1 == 0) {
                answer = 1;
            } else {
                answer = 2;
            }
            return answer;
        }
    }
}