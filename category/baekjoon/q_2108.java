package category.baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class q_2108 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        int[] arr1 = new int[T];
        int[] arr2 = new int[T];
        Arrays.fill(arr2, 4001);

        double sum = 0;

        for (int i = 0; i < T; i++){

            arr1[i] = sc.nextInt();
            sum += arr1[i];
        }

        Arrays.sort(arr1);

        sb.append(Math.round(sum/T)).append("\n");

        sb.append(arr1[(T-1)/2]).append("\n");

        int max = arr1[T-1];
        int min = arr1[0];
        int[] count = new int[max - min + 1];
        Arrays.fill(count,0);

        if (T == 1){
            sb.append(arr1[0]).append("\n");
        }

        else {
            for (int i = 0; i < T; i++) {

                count[arr1[i] - min]++;

            }

            int W = 1;
            int K;
            int z = 0;
            for (int i = 0; i <= max - min; i++) {

                if (count[i] > W) {
                    z = 0;
                    W = count[i];
                    K = i + min;
                    arr2[z] = K;
                    z++;
                } else if (count[i] == W && W != 1) {
                    K = i + min;
                    arr2[z] = K;
                    z++;
                }
            }

            if (arr2[1] == 4001 && arr2[0] != 4001) {

                sb.append(arr2[0]).append("\n");

            } else if (W == 1) {

                sb.append(arr1[1]).append("\n");

            } else {

                sb.append(arr2[1]).append("\n");

            }
        }

        sb.append(arr1[T-1] - arr1[0]);


        System.out.println(sb);
    }
}
