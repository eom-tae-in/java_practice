package Category.baekjoon;

import java.util.Scanner;

public class q_2748 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long[] Farr = new long[91];
        Farr[0] = 0;
        Farr[1] = 1;

        int A = sc.nextInt();
        for (int i = 2; i <= A; i++) {
            Farr[i] = Farr[i - 2] + Farr[i - 1];
        }

        System.out.println(Farr[A]);


    }
}
