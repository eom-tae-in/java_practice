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
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                answer++;
                break;
            }
            if (n % i == 0) {
                answer += 2;
            }
        }
        return answer;
    }
}