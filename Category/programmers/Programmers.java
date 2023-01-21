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
            int answer = 0;
            Arrays.sort(numbers);
            if (numbers[1] < 0) {
                if (numbers.length < 4) {
                    answer = numbers[0] * numbers[1];
                } else {
                    answer = Math.max(numbers[0] * numbers[1],
                      numbers[numbers.length - 2] * numbers[numbers.length - 1]);
                }
            } else {
                answer = numbers[numbers.length - 2] * numbers[numbers.length - 1];
            }
            return answer;
        }
    }
}