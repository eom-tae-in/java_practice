package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int price = sc.nextInt();
            System.out.println(solution(price));
        }

        public static int solution(int price) {
            int answer = 0;
            if (price >= 500000) {
                answer = price * 8 / 10;
            } else if (price >= 300000) {
                answer = price * 9 / 10;
            } else if (price >= 100000) {
                answer = price * 95 / 100;
            } else {
                answer = price;
            }
            return answer;
        }
    }
}