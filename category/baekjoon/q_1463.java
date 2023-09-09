package category.baekjoon;

import java.util.Scanner;

public class q_1463 {

    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] power2 = new int[20];
        power2[0] = 2;
        int[] power3 = new int[13]; // 3의 13제곱이 1_000_000만이 넘기 때문에 13까지만 한다.
        power3[0] = 3;

        if (N == 1 || N == 2 || N == 3){
            System.out.println(1);
            return;
        }
        for (int i = 1; i <= 19; i++) { // power2배열 초기화
            power2[i] = power2[i-1] * 2;
        }
        for (int i = 1; i <= 12; i++) {
            power3[i] = power3[i - 1] * 3; // power3 배열 초기화
        }

        if (N % 2 == 0 && N % 3 != 0) {
            for (int i = 1; i <= 19; i++) {
                if (N == power2[i]) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        for (int i = 1; i <= 12; i++) {
            if (N == power3[i]) {
                System.out.println(i + 1);
                return;
            }
        }
        while (N != 1) {
            int C3 = 0;
            int C2 = 0;

            for (int i = 0; i <= 12; i++) { // N의 몫이 3의 제곱수인지 확인

                if (N / 3 == power3[i]) {
                    C3 = i + 2;
                }
            }
            if (C3 != 0) { // C가 0이 아니라는 것은 N을 3으로 나눴을 때 몫이 3의 제곱수라는 뜻이다.
                if (N % 3 == 1) {
                    count += 1 + C3;
                } else if (N % 3 == 2) {
                    count += 2 + C3;
                } else {
                    count += C3;
                }
                System.out.println(count);
                return;
            }
            if (N % 3 == 0) {
                N /= 3;
                count++;
            }
            for (int i = 0; i <= 19; i++) { // N의 몫이 2의 제곱수인지 확인
                if (N / 2 == power2[i]) {
                    C2 = i + 2;
                }
            }
            if (C2 != 0) { // C가 0이 아니라는 것은 N을 2으로 나눴을 때 몫이 2의 제곱수라는 뜻이다.
                if (N % 2 == 1) {
                    count += 1 + C2;
                }else{
                    count += C2;
                }
                System.out.println(count);
                return;
            }
            else {
                if (N == 2){
                    count++;
                    N = 1;
                }
                else if (N % 2 == 0) {
                    N /= 2;
                    count++;
                } else {
                    N = div(N);
                }
            }
        }
        System.out.println(count);
    }
    static int div (int a){

        if (a % 3 == 1){
            a -= 1;
            a /= 3;
            count += 2;
        }
        else if (a % 3 == 2) {
            a -= 2;
            a /= 3;
            count += 3;
        }
        return a;
    }
}
