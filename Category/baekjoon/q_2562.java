package Category.baekjoon;

import java.util.Scanner;

public class q_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[9];
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
            if (max < numbers[i]) {
                max = Math.max(max, numbers[i]);
                index = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
