package Category.baekjoon;

import java.util.Scanner;

public class q_1568 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int count = 0;
        int num = 1;

        while (T >= num) {

            T -= num;
            num++;
            count++;
            if (T < num) {
                num = 1;
            }
        }
        System.out.println(count);

    }
}
