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
            int[] numbers = new int[index];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(solution(numbers)));
        }
    }

    public static int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int odd = 0;
        int even = 0;
        for (int j : num_list) {
            if (j % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        answer[0] = even;
        answer[1] = odd;
        return answer;
    }
}