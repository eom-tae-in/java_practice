package category.baekjoon;

import java.util.Scanner;

public class q_2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(n));
        for (int i = n - 1; i >= 0; i--) {
            sb.setCharAt(i, '*');
            System.out.println(sb);
        }
    }
}
