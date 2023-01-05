package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int slice = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(solution(slice, n));
        }

        public static int solution(int slice, int n) {
            int answer = 0;
            if (n % slice != 0) {
                answer = n / slice + 1;
            } else {
                answer = n / slice;
            }
            return answer;
        }
    }
}