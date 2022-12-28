package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int index = sc.nextInt();
            int[] array = new int[index];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(solution(n, array)));
        }
    }

    public static int[] solution(int n, int[] numlist) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int j : numlist) {
            if (j % n == 0) {
                count++;
                sb.append(j).append(" ");
            }
        }
        String str = String.valueOf(sb);
        String[] numbers = str.split(" ");
        int[] answer = new int[count];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(numbers[i]);
        }
        return answer;
    }
}