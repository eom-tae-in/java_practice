package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            System.out.println(Arrays.toString(solution(number)));
        }
    }

    public static int[] solution(int n) {
        int count = 0;
        if (n % 2 == 0) {
            count = n / 2;
        } else {
            count = n / 2 + 1;
        }
        int[] answer = new int[count];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 2 * i + 1;
        }
        return answer;
    }
}