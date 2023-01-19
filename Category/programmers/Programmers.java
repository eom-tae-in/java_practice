package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int peopleNumber = sc.nextInt();
            System.out.println(solution(peopleNumber));
        }

        public static int solution(int n) {
            int answer = 0;
            int pizzaPiece = 6;
            while (pizzaPiece % n != 0) {
                pizzaPiece += 6;
            }
            answer = pizzaPiece / 6;
            return answer;
        }
    }
}