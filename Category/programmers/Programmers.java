package Category.programmers;


import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(solution(num, k));
        }

        public static int solution(int num, int k) {
            int answer = 0;
            String number = Integer.toString(num);
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) - '0' == k) {
                    answer = i + 1;
                    break;
                }
            }
            if (answer == 0) {
                answer = -1;
            }
            return answer;
        }
    }
}