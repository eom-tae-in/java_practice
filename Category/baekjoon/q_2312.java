package Category.baekjoon;

import java.util.Scanner;

public class q_2312 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++){

            int A = sc.nextInt();
            int[] arr = new int[A + 1];

            for (int j = 2; j * j <= A; j++){

                if (A % j == 0){

                    A /= j;
                    arr[j]++;
                    j--;
                }
            }

            if (A != 1){
                arr[A]++;
            }

            for (int j = 0; j < A + 1; j++){

                if (arr[j] != 0){

                    sb.append(j).append(" ").append(arr[j]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }


}

