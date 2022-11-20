package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(Arrays.toString(solution(x, n)));
        }

        public static long[] solution(int x, int n) {
            long[] answer = new long[n];
            for (int i = 0; i < n; i++) {
                answer[i] = (long) x * (i + 1);
            }
            return answer;
        }
    }
}