package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();


        int[] arr = new int[5];
        int max = 0;
        int N = 0;

        for (int i = 0; i < 5; i++){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            arr[i] = A + B + C + D;
        }

        for (int i = 0; i < 5; i++){

            if(Math.max(max,arr[i]) == arr[i]){

                N = i+1;
            }

            max = Math.max(max,arr[i]);
        }

        sb.append(N).append(" ").append(max);

        System.out.println(sb);
    }
}
