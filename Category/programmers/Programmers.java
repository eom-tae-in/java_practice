package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int arraySize = sc.nextInt();
            int[] array = new int[arraySize];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(solution(array)));
        }
    }

    public static int[] solution(int[] array) {
        int[] answer = new int[2];
        int index = 0;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                index = i;
                max = array[i];
            }
        }
        answer[0] = max;
        answer[1] = index;
        return answer;
    }
}