package Category;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class q_2108 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = sc.nextInt();
        int[] count = new int[8001];
        Arrays.fill(count,0);
        int[] arr = new int[T];

        int C = 0;

        double sum = 0;


        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < T; i++){

            arr[i] = sc.nextInt();

            sum += arr[i];

        }

        sb.append(Math.round(sum/T)).append("\n");

        Arrays.sort(arr);

        int max = arr[T-1];
        int min = arr[0];

        sb.append(arr[T/2]).append("\n");

        for (int i = 0; i < T; i++){

            count[arr[i] + 4000]++;
        }

        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i = 0; i < 7998; i++){

            int K = 0;

            if(count[i] != 0){

                arr[K] = i - 4000;
                K++;
            }

            if (count[i] < count[i+1]){

                Arrays.fill(arr, Integer.MAX_VALUE);
                arr[C] = i+1 - 4000;
                K = 0;

            } else if (count[i] == count[i+1] && count[i] != 0){

                arr[K] = i+1 - 4000;
                K++;
            }
        }

        Arrays.sort(arr);

        if (arr[1] == Integer.MAX_VALUE){
            sb.append(arr[0]).append("\n");
        }

        else {

            sb.append(arr[1]).append("\n");
        }

        sb.append(max - min);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
