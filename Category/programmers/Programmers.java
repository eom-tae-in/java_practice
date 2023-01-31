package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] arr = new int[index];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(Arrays.toString(solution(arr)));
        }

        public long solution(int price, int money, int count) {
            long answer = 0;
            long total = 0;
            for (int i = 1; i <= count; i++) {
                total += (long) price * i;
            }
            if (money - total >= 0) {
                return answer;
            }
            answer = total - money;
            return answer;
        }
    }
}