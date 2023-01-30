package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] arr = new int[index];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(solution(arr)));
        }

        public static int[] solution(int[] arr) {
            if (arr.length == 1) {
                int[] answer = new int[1];
                answer[0] = -1;
                return answer;
            }
            int[] answer = new int[arr.length - 1];
            int min = arr[0];
            int index = 0;
            for (int i = 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    index = i;
                }
            }
            for (int i = 0; i < index; i++) {
                answer[i] = arr[i];
            }
            for (int i = index; i < answer.length; i++) {
                answer[i] = arr[i + 1];
            }
            return answer;
        }
    }
}