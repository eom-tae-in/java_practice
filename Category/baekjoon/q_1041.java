package Category.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q_1041 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long T = Integer.parseInt(br.readLine());

        long[] arr = new long[6];

        long sum;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 6; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }


        arr[0] = Math.min(arr[0],arr[5]);
        arr[1] = Math.min(arr[1],arr[4]);
        arr[2] = Math.min(arr[2],arr[3]);
        arr[5] = Math.max(arr[3],Math.max(arr[4],arr[5]));



        if (T == 1){

            sum = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];

        }
        else {

            long A = arr[0];
            long B = arr[0] + arr[1];
            long C = arr[0] + arr[1] + arr[2];

            long One = 5 * (T - 2) * (T - 2) + 4 * (T-2);
            long Two = 8 * T - 12;
            long Three = 4;

            sum = A * One + B * Two + C * Three;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
