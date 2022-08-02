package Category;

import java.io.*;
public class q_11068 {

    static int A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++){

            A = Integer.parseInt(br.readLine());

            if (A < 64 || A > 1_000_000){
                sb.append("범위를 벗어난 입력입니다.").append("\n");
            }
            else {
                int k;
                for (int j = 2; j <= 64; j++) {
                    k = Number(j);
                    if (k == 1) {
                        sb.append(k).append("\n");
                        break;
                    }
                    if (j == 64) {
                        sb.append(k).append("\n");
                    }
                }
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    static int Number(int j){

        int[] arr = new int[A];
        int Z = A;
        int count = 0;

        for (int i = 0; i < A; i++){

            arr[i] = Z % j;
            Z /= j;
            count++;
            if (Z < j){
                arr[i+1] = Z;
                count++;
                break;
            }
        }
        int R = count / 2;
        int C = 0;

        if (count % 2 == 0){
            for (int i = 1; i <= R; i++){

                if(arr[R - i] == arr[R + i - 1]){
                    C++;
                }
            }
        }
        else {
            for (int i = 1; i <= R; i++){

                if(arr[R - i] == arr[R + i]){
                    C++;
                }
            }
        }
        if (C == R){
            return 1;
        }
        return 0;
    }
}
