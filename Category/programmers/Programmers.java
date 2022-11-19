package Category.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long n = sc.nextLong();
            System.out.println(solution(n));
        }

        public static long solution(long n) {
            long answer = 0;
            String str = Long.toString(n);
            String[] strings = str.split("");
            Arrays.sort(strings, Collections.reverseOrder());
            String sortrdStr = String.join("", strings);
            answer = Long.parseLong(sortrdStr);
            return answer;
        }
    }
}