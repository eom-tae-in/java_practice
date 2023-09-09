package category.baekjoon;

import java.util.Scanner;


public class q_2839 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();


        if (a == 4 || a == 7) {
            System.out.println(-1);
        } else if (a % 5 == 0) {
            System.out.println(a / 5);
        } else if (a % 5 == 1 || a % 5 == 3) {
            System.out.println((a / 5) + 1);
        } else if (a % 5 == 2 || a % 5 == 4) {
            System.out.println((a / 5) + 2);
        }
    }
}
