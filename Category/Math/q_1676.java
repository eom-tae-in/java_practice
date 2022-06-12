package Category.Math;

import java.util.Scanner;

public class q_1676 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int value = 0;


        while(a >= 5){

            value += a/5;

            a /= 5;
        }

        System.out.println(value);
    }
}

