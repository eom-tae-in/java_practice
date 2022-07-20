package Category;

import java.util.Scanner;

public class q_2292 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        int b = 1;
        int c = 0;
        int i = 0;

        while (c<1){

             c= b/a;
             i++;
             b = b + 6 * i;

        }

        System.out.println(i);

    }
}
