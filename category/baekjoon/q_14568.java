package category.baekjoon;

import java.util.Scanner;

public class q_14568 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        if (T < 6 || T > 100) {

            System.out.println(0);
            return;
        }
        int count = 0;

        while (T > 0) {

            for (int i = 1; i < (T - 2) / 2; i++) {
                if ((T - 2) - i > 2) {
                    count++;
                }
            }
            T -= 2;
        }

        System.out.println(count);


    }
}
