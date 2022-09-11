package Category.baekjoon;

import java.util.Scanner;

public class q_2581 {

    public static boolean prime[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m= sc.nextInt();
        int n = sc.nextInt();

        prime = new boolean[n + 1];


        Prime();


        int sum = 0;

        int min = Integer.MAX_VALUE;

        for(int i = m; i <= n; i++) {
            if(prime[i] == false) {
                sum += i;
                if(min == Integer.MAX_VALUE) {
                    min = i;
                }
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }



    public static void Prime() {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

    }
}