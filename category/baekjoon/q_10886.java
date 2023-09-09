package category.baekjoon;

import java.util.Scanner;

public class q_10886 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int C = 0;
        int NC = 0;
        for (int i = 0; i < T; i++) {
            if (sc.nextInt() == 1) {
                C++;
            } else {
                NC++;
            }
        }
        if (C > NC) {
            System.out.println("Junhee is cute!");
        } else {
            System.out.println("Junhee is not cute!");
        }
    }
}
