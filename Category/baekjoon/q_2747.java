package Category.baekjoon;

import java.util.Scanner;

public class q_2747 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        System.out.println(Fibonacci(T - 1));
    }

    public static int Fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }

    }

}
