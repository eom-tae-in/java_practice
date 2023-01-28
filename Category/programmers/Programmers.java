package Category.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String my_string = sc.next();
            System.out.println(Arrays.toString(solution(my_string)));
        }

        public static int[] solution(String my_string) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < my_string.length(); i++) {
                if (Character.isDigit(my_string.charAt(i))) {
                    list.add(my_string.charAt(i) - '0');
                }
            }
            Collections.sort(list);
            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}