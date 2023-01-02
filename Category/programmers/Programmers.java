package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] arr = new int[index];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr));
        }
    }

    public static int solution(int[] array) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            String str = Integer.toString(array[i]);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '7') {
                    answer++;
                }
            }
        }
        return answer;
    }
}