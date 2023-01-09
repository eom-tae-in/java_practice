package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int hp = sc.nextInt();
            System.out.println(solution(hp));
        }

        public static int solution(int hp) {
            int answer = 0;
            if (hp >= 5) {
                answer += hp / 5;
                hp %= 5;
            }
            answer += hp / 3 + hp % 3;
            return answer;
        }
    }
}