package Category.baekjoon;

import java.util.Scanner;

public class q_6588 {

    static boolean[] prime;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        make_prime(1000001);
        while (true) {


            int A = sc.nextInt();

            if (A == 0) {
                return;
            }

            for (int j = 0; j <= A/2; j++) {
                if (!prime[j] && j % 2 == 1) {    // 소수(false)일 경우 출력
                    if (!prime[A - j]) {
                        System.out.println(A + " = " + j + " + " + (A - j));
                        break;
                    }
                }
                if (j == A / 2) {

                    System.out.println("Goldenbach's conjecture is wrong.");

                }
            }
        }

    }

    public static void make_prime(int N) {
        prime = new boolean[N + 1];    // 0 ~ N
		/*
		소수가 아닌 index = true
		소수인 index = false
		*/
        // 2 미만의 N 을 입력받으면 소수는 판별할 필요 없으므로 바로 return
        if (N < 2) {
            return;
        }
        prime[0] = prime[1] = true;
        // 제곱근 함수 : Math.sqrt()
        for (int i = 2; i <= Math.sqrt(N); i++) {
            // 이미 체크된 배열이면 다음 반복문으로 skip
            if (prime[i]) {
                continue;
            }
            // i 의 배수들을 걸러주기 위한 반복문
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true; // boolean의 초기값은 false이다.
            }
        }
    }
}
