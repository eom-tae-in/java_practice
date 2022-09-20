package Category.baekjoon;

import java.util.Scanner;

public class q_17618 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int count = 0;

        for (int i = 1; i <= Integer.parseInt(str); i++) {

            int sum = 0;
            int num = 0;
            String S = String.valueOf(i);
            for (int j = 0; j < S.length(); j++) {

                int p = S.charAt(j) - '0';
                sum += p;
                num += p * (int) Math.pow(10, str.length() - (j + 1));
            }

            if (num % sum == 0) {
                count++;
            }
        }
        System.out.println(count);


    }
}
