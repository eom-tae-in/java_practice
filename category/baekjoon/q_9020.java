package category.baekjoon;

import java.util.Scanner;

public class q_9020 {

    public static boolean[] prime = new boolean[10001]; // 0 ~ 10000

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Get_prime();

        int T = sc.nextInt();

        while (T-- > 0) {

            int num = sc.nextInt();
            int a = num / 2;
            int b = num / 2;

            while(true) {

                if(!prime[a] && !prime[b]) {

                    System.out.println(a + " " + b);
                    break;
                }

                a--;
                b++;

            }
        }
    }

    public static void Get_prime() {

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {

            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }

        }

    }
}

