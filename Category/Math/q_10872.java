package Category.Math;

import java.util.Scanner;

public class q_10872 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        int b = 1;

        for (int i = a; i>0; i--){

            b *= i;

        }

        System.out.println(b);


    }
}
