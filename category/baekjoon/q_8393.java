package category.baekjoon;

import java.util.Scanner;

public class q_8393 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), r = 0;


        for(int i=1; i<=a; i++){

            r = i + r;
        }

        System.out.println(r);
    }

}
