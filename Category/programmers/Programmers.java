package Category.programmers;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
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
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(Arrays.toString(solution(numbers, num1, num2)));
        }
    }

    public static int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2 - num1 + 1];
        int index = 0;
        for (int i = num1; i <= num2; i++) {
            answer[index] = numbers[i];
            index++;
        }
        return answer;
    }
}