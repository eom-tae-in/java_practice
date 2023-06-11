package Category.baekjoon;

import java.util.Scanner;

public class q_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            if (N % H == 0) {
                sb.append(H * 100 + N / H).append("\n");
                continue;
            }
            sb.append(N % H * 100 + N / H + 1).append("\n");
        }
        System.out.println(sb);
    }
}
