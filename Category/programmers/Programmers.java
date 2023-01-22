package Category.programmers;


import java.util.HashSet;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            System.out.println(solution(str));

        }
        public static String solution(String my_string) {
            String answer = "";
            HashSet<String> string = new HashSet<>();
            string.add(my_string);
            return answer;
        }
    }
}