package Category.baekjoon;

import java.util.Scanner;

public class q_1476 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int e = 1, s = 1, m = 1;
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        for (int year = 1; ; year++) {
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            e += 1;
            s += 1;
            m += 1;
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
        }
    }
}
