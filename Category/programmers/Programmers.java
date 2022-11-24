package Category.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String strings = sc.next();
            System.out.println(solution(strings));
        }
        public int[] solution(int[] arr, int divisor) {
            int[] answer;
            int index = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j : arr) {
                if (j % divisor == 0) {
                    list.add(j);
                }
            }
            if (list.size() == 0) {
                answer = new int[]{-1};
            } else {

                answer = new int[list.size()];

                for (int i = 0; i < answer.length; i++) {
                    answer[i] = list.get(i);
                }

                Arrays.sort(answer);
            }

            return answer;
        }
    }
}