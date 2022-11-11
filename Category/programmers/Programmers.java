package Category.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        System.out.println(Solution.solution(a));

    }
    class Solution {
        public static String solution(int num) {
            String answer = "";
            if (num % 2 == 0) {
                answer += "Even";
            } else {
                answer += "Odd";
            }
            return answer;
        }
    }
}