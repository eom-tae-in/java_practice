package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_1027 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        int[] C = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < T; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T-1; i++) {

            double Gradient = arr[i+1] - arr[i];
            C[i]++;
            C[i+1]++;

            for (int j = i+2; j < T; j++){

                double angle = (double)(arr[j] - arr[i]) / (j - i);

                if (angle <= Gradient){
                    continue;
                }
                Gradient = angle;
                C[i]++;
                C[j]++;
            }
        }
        Arrays.sort(C);

        System.out.println(C[T-1]);

    }
}
