package Category;

import java.util.Scanner;

public class q_2018 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int sum = 0;
        int count = 0;

        for (int j = 1; j <=T; j++) {

            for (int i = j; i <= T; i++) {

                sum += i;

                if (sum == T) {

                    count++;
                    sum = 0;
                    break;
                }
                else if (sum > T) {
                    sum = 0;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
