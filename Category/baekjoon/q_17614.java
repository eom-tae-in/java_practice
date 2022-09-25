package Category.baekjoon;

import java.util.Scanner;

public class q_17614 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= T; i++) {

            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
