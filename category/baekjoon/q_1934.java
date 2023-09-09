package category.baekjoon;

import java.util.Scanner;

public class q_1934 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++){

            int G = 0;

            int a = sc.nextInt();
            int b = sc.nextInt();

            G = gcd(a,b);

            int M = (a * b) / G;

            System.out.println(M);
        }

    }


    public static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

