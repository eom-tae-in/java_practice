package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(solution(n));
        }
        public static int solution(int num) {
            int answer = 0;
            int count = 0;
            long number = num;
            for (int i = 0; i < 500; i++) {
                if (number != 1) {
                    count++;
                    if (number % 2 == 0) {
                        number /= 2;
                    } else {
                        number = 3 * number + 1;
                    }
                } else {
                    break;
                }
            }
            if (count == 500 && number != 1) {
                answer = -1;
            } else {
                answer = count;
            }
            return answer;
        }
    }
}