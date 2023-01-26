package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int M = sc.nextInt();
            int N = sc.nextInt();
            System.out.println(solution(M, N));
        }
        public static int solution(int M, int N) {
            int answer = 0;
            int piece = 1;
            while (M != 1) {
                answer += 1;
                piece += 1;
                M--;
            }
            answer += piece * (N - 1);
            return answer;
        }
    }
}