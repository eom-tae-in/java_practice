package Category.baekjoon;

import java.util.Scanner;

public class q_5585 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] moneytype = {500, 100, 50, 10, 5, 1};

        int money = 1000 - sc.nextInt();
        int count = 0;

        for (int i = 0; i < moneytype.length; i++) {
            count += money / moneytype[i];
            money = money % moneytype[i];

            if (money == 0) {
                break;
            }
        }
        System.out.println(count);
    }


}


