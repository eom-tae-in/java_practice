package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int price = sc.nextInt();
            int money = sc.nextInt();
            int count = sc.nextInt();
            System.out.println(solution(price, money, count));
        }

        public static long solution(int price, int money, int count) {
            long answer = 0;
            long total = 0;
            for (int i = 1; i <= count; i++) {
                total += (long) price * i;
            }
            if (money - total >= 0) {
                return answer;
            }
            answer = total - money;
            return answer;
        }
    }
}