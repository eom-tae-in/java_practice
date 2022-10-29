package Category.baekjoon;

import java.util.Scanner;

public class q_15700 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        if (A == 1 && B == 1) {
            System.out.println(0);
        } else {
            if (A == 1) {
                System.out.println(B / 2);
            } else if (B == 1) {
                System.out.println(A / 2);
            } else {
                if (B % 2 != 0) {
                    System.out.println(A * (B / 2) + A / 2);
                } else {
                    System.out.println(A * (B / 2));
                }
            }
        }
    }
}
