package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String my_string = sc.next();
            System.out.println(solution(my_string));
        }
        public static String solution(String my_string) {
            String answer = "";
            for (int i = 0; i < my_string.length(); i++) {
                answer += (my_string.charAt(i) < 'a') ? String.valueOf(my_string.charAt(i)).toLowerCase() :
                  String.valueOf(my_string.charAt(i)).toUpperCase();
            }
            return answer;
        }
    }
}