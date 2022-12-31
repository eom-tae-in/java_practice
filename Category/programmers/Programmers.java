package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int[] size = new int[3];
            for (int i = 0; i < size.length; i++) {
                size[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            System.out.println(solution(size, n));
        }
    }

    public static int solution(int[] box, int n) {
        int answer = 1;
        for (int i : box) {
            answer *= i / n;
        }
        return answer;
    }
}