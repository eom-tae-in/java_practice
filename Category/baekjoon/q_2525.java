package Category.baekjoon;

import java.util.Scanner;

public class q_2525 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();


        int min = h * 60 + m + t;

        h = min / 60;
        m = min % 60;


        if (h>=24) {
            h= h-24;
        }

        System.out.println(h + " "+ m);

    }
}
