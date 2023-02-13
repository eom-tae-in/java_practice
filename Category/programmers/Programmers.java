package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int indexLength = sc.nextInt();
            int[] num_list = new int[indexLength];
            for (int i = 0; i < num_list.length; i++) {
                num_list[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            System.out.println(Arrays.deepToString(solution(num_list, n)));
        }

        public static int[][] solution(int[] num_list, int n) {
            int[][] answer = new int[num_list.length / n][n];
            for (int i = 0; i < num_list.length / n; i++) {
                System.arraycopy(num_list, i * n, answer[i], 0, n);
            }
            return answer;
        }
    }
}