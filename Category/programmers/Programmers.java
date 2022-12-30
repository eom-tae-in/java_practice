package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int order = sc.nextInt();
            System.out.println(solution(order));
        }
    }

    public static int solution(int order) {
        int answer = 0;
        String str = Integer.toString(order);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') {
                answer++;
            }
        }
        return answer;
    }
}