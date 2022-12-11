package Category.programmers;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] arrayNumber = new int[index];
            for (int i = 0; i < arrayNumber.length; i++) {
                arrayNumber[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(solution(arrayNumber)));
        }
    }

    public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length - (i + 1)];
        }
        return answer;
    }
}