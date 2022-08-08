package Category;

import java.util.Arrays;
import java.util.Scanner;

public class q_5543 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] Burger = new int[3];
        int[] Drink = new int[2];

        for (int i = 0; i < 3; i++) {

            Burger[i] = sc.nextInt();
        }

        for (int i = 0; i < 2; i++) {

            Drink[i] = sc.nextInt();
        }

        Arrays.sort(Burger);
        Arrays.sort(Drink);

        System.out.println(Burger[0] + Drink[0] - 50);

    }
}
