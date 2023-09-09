package category.baekjoon;

import java.util.Scanner;

public class q_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        double max = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            if (max < scores[i]) {
                max = scores[i];
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += (scores[i] / max) * 100;
        }
        System.out.println(total / n);
    }
}
