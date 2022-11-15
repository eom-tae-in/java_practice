package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long T = sc.nextLong();
            int[] arr = solution(T);
            System.out.println(Arrays.toString(arr));

        }
        public static int[] solution(long n) {
            StringBuilder sb = new StringBuilder();
            sb.append(n);
            String str = String.valueOf(sb.reverse());
            int[] answer = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                answer[i] = str.charAt(i) - '0';
            }
            return answer;
        }
    }
}