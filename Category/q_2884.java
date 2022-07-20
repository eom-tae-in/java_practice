package Category;

import java.util.Scanner;

public class q_2884 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a,b;

        a = sc.nextInt();
        b = sc.nextInt();

        if(b<45){

            b += 60 - 45;

            a--;

            if(a<0){

                a += 24;
            }
        }
        else {

            b -= 45;
        }

        System.out.println(a + " " + b);

    }
}
