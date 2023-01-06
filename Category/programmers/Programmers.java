package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] triangle = new int[3];
            for (int i = 0; i < triangle.length; i++) {
                triangle[i] = sc.nextInt();
            }
            System.out.println(solution(triangle));
        }

        public static int solution(int[] sides) {
            int answer = 0;
            Arrays.sort(sides);
            if (sides[0] + sides[1] > sides[2]) {
                answer = 1;
            } else {
                answer = 2;
            }
            return answer;
        }
    }
}