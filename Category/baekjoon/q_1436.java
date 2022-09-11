package Category.baekjoon;

import java.util.Scanner;

public class q_1436 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int num = 666;

        while (T > 0) {

            String str = Integer.toString(num);

            if (str.contains("666")) {

                T -= 1;
            }
            num ++;
        }

        System.out.println(num-1);

    }
}
