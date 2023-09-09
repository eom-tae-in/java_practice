package category.baekjoon;

import java.util.Scanner;

public class q_2010 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < T; i++) {

            int A = sc.nextInt();
            sum += A;
            count = i;

        }
        System.out.println(sum - count);

    }
}
