package category.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class q_2217 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] arr = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++){

            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < T; i++){

            max = Math.max(max, arr[i] * (T - i));

        }

        System.out.println(max);
    }
}
