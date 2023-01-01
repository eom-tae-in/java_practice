package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(solution(n));
        }
    }

    public static int solution(int n) {
        int answer = 1;
        int count = 1;
        while (n >= answer) {
            count++;
            answer *= count;
        }
        count--;
        answer = count;
        return answer;
    }
}