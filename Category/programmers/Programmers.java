package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            String[] arr = new String[index];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.next();
            }
            System.out.println(Arrays.toString(solution(arr)));
        }
    }

    public static int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}