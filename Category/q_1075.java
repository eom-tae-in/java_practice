package Category;

import java.util.Scanner;

public class q_1075 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int a = sc.nextInt();
        int b = sc.nextInt();

        int x = a / b;
        int y = x * b / 100;
        int k = x * b % 100;
        int z = a / 100;

        int R = 0;
        int count = 0;

        if (z == y){

            for (k -= b; k >= 0; k -=b){

                count++;
            }

            R = (x-count) * b % 100;

        }

        else {

            R = (x+1) * b % 100;
        }

        if (R < 10 ){
            sb.append(0);
        }
        sb.append(R);

        System.out.println(sb);
    }
}