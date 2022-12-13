package Category.programmers;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            System.out.println(solution(str));
        }
    }

    public static String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        sb.reverse();
        answer = String.valueOf(sb);
        return answer;
    }
}