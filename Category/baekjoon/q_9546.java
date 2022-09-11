package Category.baekjoon;

import java.util.Scanner;

public class q_9546 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++){

            int A = sc.nextInt();
            sb.append((int)Math.pow(2,A) - 1).append("\n");
        }

        System.out.println(sb);
    }
}
