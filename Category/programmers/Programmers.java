package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] emergency = new int[index];
            for (int i = 0; i < emergency.length; i++) {
                emergency[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(solution(emergency)));
        }
        public static int[] solution(int[] emergency) {
            int[] answer = new int[emergency.length];
            int[] reverse = new int[emergency.length];
            for (int i = 0; i < reverse.length; i++) {
                reverse[i] = emergency[i];
            }
            Arrays.sort(reverse);
            int number = emergency.length;
            for (int i = 0; i < reverse.length; i++) {
                for (int j = 0; j < emergency.length; j++) {
                    if (reverse[i] == emergency[j]) {
                        answer[j] = number;
                        number--;
                    }
                }
            }
            return answer;
        }
    }
}