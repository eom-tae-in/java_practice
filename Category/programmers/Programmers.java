package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String my_string = sc.next();
            System.out.println(solution(my_string));
        }

        public static String solution(String my_string) {
            String answer = "";
            char[] my_stringToChar = my_string.toLowerCase().toCharArray();
            Arrays.sort(my_stringToChar);
            answer = String.valueOf(my_stringToChar);
            return answer;
        }
    }
}