package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_25704 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        if (N < 5) {
            System.out.println(P);
        } else if (N < 10) {
            if (P > 500) {
                System.out.println(P - 500);
            } else {
                System.out.println(0);
            }
        } else if (N < 15) {
            if (P > 5000) {
                System.out.println((int)(P * 0.9));
            } else {
                if (P > 500) {
                    System.out.println(P - 500);
                } else {
                    System.out.println(0);
                }
            }
        } else if (N < 20) {
            if (P > 20000) {
                System.out.println((int) (P * 0.9));
            } else {
                if (P > 2000) {
                    System.out.println(P - 2000);
                } else {
                    System.out.println(0);
                }
            }
        } else {
            if (P > 8000) {
                System.out.println((int) (P * 0.75));
            } else {
                if (P > 2000) {
                    System.out.println(P - 2000);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
