package Category.Math;

import java.util.Scanner;

public class q_10156 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int money = p * n - m;

        sc.close();

        System.out.println(money > 0 ? money : 0);

    }
}
