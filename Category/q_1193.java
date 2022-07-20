package Category;

import java.util.Scanner;

public class q_1193 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int pre_sum = 0;

        int now_num = 1;

        while (true) {

            if (x <= pre_sum + now_num) {

                if (now_num % 2 == 0) {

                    System.out.println((x - pre_sum) + "/" + (now_num - (x - pre_sum - 1)));
                    break;
                } else {

                    System.out.println((now_num - (x - pre_sum - 1)) + "/" + (x - pre_sum));
                    break;
                }
            } else {
                pre_sum += now_num;
                now_num++;
            }
        }
    }
}




