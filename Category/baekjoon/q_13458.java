package Category.baekjoon;

import java.util.Scanner;

public class q_13458 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] x = new int[T];

        int sum = 0;

        for(int i = 0; i < T; i++){

            x[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int m = sc.nextInt();


        for(int i = 0; i < T; i++){


            if(x[i]<=M){
                sum++;

            }else {
                sum++;
                x[i] -= M;
                if(x[i]%m==0) {
                    sum+=x[i]/m;
                }
                else if(x[i]%m!=0) {
                    sum+=x[i]/m+1;
                }
            }

        }
        System.out.println(sum);

    }
}
