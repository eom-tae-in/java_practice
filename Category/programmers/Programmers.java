package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(solution(n));
        }
    }

    public static int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n);
        for (int i = 0; i < str.length(); i++) {
            answer += str.charAt(i) - '0';
        }
        return answer;
    }
}