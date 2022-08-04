package Category;

import java.util.Scanner;

public class q_5724 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int A = sc.nextInt();

        while (A != 0) {

            int sum = 0;

            for (int j = A; j > 0; j--) {
                sum += j * j;
            }
            sb.append(sum).append("\n");

            A = sc.nextInt();
        }

        System.out.println(sb);
    }
}
