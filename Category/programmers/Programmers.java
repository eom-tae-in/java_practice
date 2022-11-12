package Category.programmers;

import java.io.IOException;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int T = sc.nextInt();
            int[] arr = new int[T];

            for (int i = 0; i < T; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr));
        }

        public static double solution(int[] arr) {
            double answer = 0;
            for (int i = 0; i < arr.length; i++) {
                answer += arr[i];
            }
            return answer / arr.length;
        }
    }
}