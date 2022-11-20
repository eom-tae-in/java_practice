package Category.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(solution(n));
        }

        public static int solution(int n) {
            int answer = 0;
            for (int i = 2; i < n; i++) {
                if (n % i == 1) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}