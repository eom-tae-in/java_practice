package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] numbers = new int[index];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextInt();
            }
            System.out.println(solution(numbers));
        }

        public static int solution(int[] numbers) {
            int answer = 45;
            for (int i = 0; i < numbers.length; i++) {
                answer -= numbers[i];
            }
            return answer;
        }
    }
}