package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] absolute = new int[index];
            for (int i = 0; i < absolute.length; i++) {
                absolute[i] = sc.nextInt();
            }
            boolean[] signs = new boolean[index];
            for (int i = 0; i < signs.length; i++) {
                signs[i] = sc.nextBoolean();
            }
            System.out.println(solution(absolute, signs));
        }
        public static int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for (int i = 0; i < absolutes.length; i++) {
                if (signs[i]) {
                    answer += absolutes[i];
                    continue;
                }
                answer -= absolutes[i];
            }
            return answer;
        }
    }
}