package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] numbers = new int[index];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextInt();
            }
            String direction = sc.next();
            System.out.println(Arrays.toString(solution(numbers, direction)));
        }

        public static int[] solution(int[] numbers, String direction) {
            int[] answer = new int[numbers.length];
            if (direction.equals("right")) {
                answer[0] = numbers[numbers.length - 1];
                System.arraycopy(numbers, 0, answer, 1, numbers.length - 1);
                return answer;
            }
            System.arraycopy(numbers, 1, answer, 0, numbers.length - 1);
            answer[answer.length - 1] = numbers[0];
            return answer;
        }
    }
}