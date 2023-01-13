package Category.programmers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String my_string = br.readLine();
            int num1 = Integer.parseInt(br.readLine());
            int num2 = Integer.parseInt(br.readLine());
            System.out.println(solution(my_string, num1, num2));
        }

        public static String solution(String my_string, int num1, int num2) {
            String answer = my_string.substring(0, num1) + my_string.charAt(num2) +
              my_string.substring(num1+1, num2) + my_string.charAt(num1) + my_string.substring(num2+1);
            return answer;
        }
    }
}