package Category.programmers;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int money = sc.nextInt();
            System.out.println(Arrays.toString(solution(money)));
        }
    }

    public static int[] solution(int money) {
        int[] answer = new int[2];
        int num = money / 5500;
        int R = money % 5500;
        answer[0] = num;
        answer[1] = R;
        return answer;
    }
}