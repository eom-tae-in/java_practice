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
        public long solution(long n) {
            long answer = 0;
            if (n % Math.sqrt(n) == 0) {
                answer = (long) Math.pow((Math.sqrt(n) + 1), 2);
            } else {
                answer = -1;
            }
            return answer;
        }
    }
}