package Category.baekjoon;

import java.util.Scanner;

public class q_9085 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T;
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < t; j++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);

        }
    }
}
